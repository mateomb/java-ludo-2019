import java.net.*;
/**
* @author Loneboy - Mateo Matijevic Bosnjak
* Mini Project ISTE121 
* Section 801
* Instructor Alan Mutka
* @since 08.03.2020
*/
//Class used for getting information about the users
public class PlayerInfo{
   //Gets IP adress, Port, username and ID
   private InetAddress address;
   private int port;
   private String username;
   //Each player was supposed to have an unique ID (They do) with which some features would become usable such as showing who disconnected, limiting the counter at 4 etc
   private int id;
   
   public PlayerInfo(String username, int id, InetAddress address, int port){
      this.username = username;
      this.id = id;
      this.address = address;
      this.port = port;
   }
   
   //Method that returns username
   public String getUsername(){
      return username;
   }
   
   //Method that returns ID
   public int getID(){
      return id;
   }
   
   //Method that returns Address
   public InetAddress getAddress(){
      return address;
   }
   
   //Method that returns Port
   public int getPort(){
      return port;
   }
}