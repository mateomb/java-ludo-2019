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
//Class Server used for everything connected to the server side of the program, it is used by ServerLudo to start the server.
public class Server{
   //Attributes
   private static DatagramSocket socket;
   private static boolean serverRunning;
   public static int id = 0;
   private static ArrayList<PlayerInfo> players = new ArrayList<PlayerInfo>();
   private static ArrayList<String> allPlayers = new ArrayList<String>();
   public static String sender;
   //Method that will start the server and show on which port (port is found in ServerLudo)
   public static void startServer(int port){
      try{
         socket = new DatagramSocket(port);
         serverRunning = true;
         getInput();
         System.out.println("Server started on port " + port);
      }catch(IOException ioe){
         ioe.getMessage();
      }
   }
   
   //Method that sends message that the server recieved from the client to all other clients
   public static void messageServer(String messages){
      for(PlayerInfo playerInfo : players){
         sendServer(messages, playerInfo.getAddress(), playerInfo.getPort());
      }
   }
   
   //Method with which the client sends the messages to server
   public static void sendServer(String messages, InetAddress address, int port){
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
   public static void getInput(){
      Thread threadInput = new Thread(){
         public void run(){
            try{
               while(serverRunning){
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
                     messageServer(": " + messages);
                  }
            }}catch(Exception e){
               e.getMessage();
            }
         }
      };//End of Thread
      threadInput.start();
   }
   
   //Commans that can be used on server \con will connect client to server \dis will disconnect client from server
   private static boolean messageType(String messages, DatagramPacket packet){
      if(messages.startsWith("\\Conn:")){
         String username = messages.substring(messages.indexOf(":")+1);
         //allPlayers.add(username);
         //ID was supposed to be used for a method that would show and print when players disconnected but I ran out of time
         players.add(new PlayerInfo(username, id++, packet.getAddress(), packet.getPort()));
         messageServer("User: " + username + ", connected to the server! Welcome! You've been assigned the blue color.");
         /*if(id == 1){
         sender = username;
         }if(id == 2){
         sender1 = username;
         }if(id == 3){
         sende2r = username;
         }if(id == 4){
         sender3 = username;
         }*/
         return true;
         
       /*  if(id == 0)
         }
         else if(id == 1){
         messageServer("User: " + username + ", connected to the server! Welcome! blue");
         return true;
      }

         else if(id == 2){
         messageServer("User: " + username + ", connected to the server! Welcome! red");
         return true;
      }
      for(int i=4; i> allPlayers.size(); i--){
         if(i == 4){
            messageServer("User: " + username + ", connected to the server! Welcome! You've been assigned the blue color.");
            return true;
         }else if(i == 3){
            messageServer("Usssssser: " + username + ", connected to the server! Welcome! You've been assigned the blue color.");
         return true;
         }*/
      }//End of \\Conn
      return false;
   }
   
   //Will stop the server
   public static void stopServer(){
      serverRunning = false;
   }
}