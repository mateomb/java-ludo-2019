import java.io.*;
import java.net.*;
import java.util.*;
/**
* @author Loneboy - Mateo Matijevic Bosnjak
* Mini Project ISTE121 
* Section 801
* Instructor Alan Mutka
* @since 08.03.2020
*/
public class Client{
/**
*  I do realise that by using DS instead of SS I am sending and recieving datagrams instead of accepting network connections on some protocol such as IP. 
*  However due to the smaller packages (only messages) this insures a faster transfer. Because I was told by my teammate that he dropped the course and wont be doing his part at all which we had previously 
*  agreed on a week prior to send what we did. I took up advice to take this approach by a family friend who has experience with java and he explained to me the differences and when to use each one. 
*  As the chat was from scratch because we did not do the team chat homework I took this approach as I could ask for help if I stumbled upon problems.
*/
   private DatagramSocket socket;
   private InetAddress address;
   private int port;
   private boolean running;
   
   public Client(String username, String address, int port){
      try{
         this.address = InetAddress.getByName(address);
         this.port = port;
         
         socket = new DatagramSocket();
         
         running = true;
         getInput();
         
         sendMessage("\\Conn:"+username);
         
      }catch(Exception e){
         e.printStackTrace();
      }
   }//End of constructor
   
   //Method with which the client sends the messages to server
   public void sendMessage(String messages){
   try{
            messages += "\\e";
            byte[] data = messages.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            socket.send(packet);
            System.out.println("Sent message to " + address.getHostAddress()+ ": " + port);
      }catch(Exception e){
               e.getMessage();
            }
   }
   
   //Method that reads what the user has writen and "reformats" it to be useable by the server
   public void getInput(){
      Thread threadInput = new Thread(){
         public void run(){
            try{
               while(running){
                  //Recives information and stores them into data
                  byte[] data = new byte[1024];
                  
                  DatagramPacket packet = new DatagramPacket(data, data.length);
                  //Socket waits for message and puts it into packet and packet will write message and store it into byte
                  socket.receive(packet);
                  
                  String messages = new String(data);
                  //Shortens message for bytes \\e marks the end of the message so that the message does not take 1024 bytes
                  messages = messages.substring(0, messages.indexOf("\\e"));
                  
                  //Manages messages we recieve and will not print everything out but rather messages only
                  if(!messageType(messages, packet)){
                    Ludo.messagePrinter(messages);
                  }
            }}catch(Exception e){
               e.getMessage();
            }
         }
      };//End of Thread
      threadInput.start(); //Starts thread
   }
   
   //Used to show that a user has connected, additional features can be used here such as disconnect to show when the user disconnects, when the user is afk etc.
      private static boolean messageType(String messages, DatagramPacket packet){
      if(messages.startsWith("\\Conn:")){
         return true;
      }
      return false;
   }
}//End of class Client