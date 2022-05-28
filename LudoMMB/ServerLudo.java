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
//Class ServerLudo which starts the server for the game/msg system when called it runs the Server class
public class ServerLudo{
   public static void main(String[] args){
      Server.startServer(12345);//Port can be changed
   }//End of main
}//End of ServerLudo
