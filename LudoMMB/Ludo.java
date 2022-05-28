/**
* @author Loneboy - Mateo Matijevic Bosnjak
* Mini Project ISTE121 
* Section 801
* Instructor Alan Mutka
* @since 08.03.2020
*/
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.Math;
import java.awt.event.MouseMotionListener;
  
/*
   This class creates the GUI board and the tokens. This class controlls all the functions of the game
**/
public class Ludo extends JFrame{
   private Client client;

   private BackgroundPanel imagePanel=null;
   private JLabel jlTokenBlue1=null;
   private JLabel jlTokenBlue2=null;
   private JLabel jlTokenBlue3=null;
   private JLabel jlTokenBlue4=null;
   private JLabel jlTokenRed1=null;
   private JLabel jlTokenRed2=null;
   private JLabel jlTokenRed3=null;
   private JLabel jlTokenRed4=null;
   private JLabel jlTokenGreen1=null;
   private JLabel jlTokenGreen2=null;
   private JLabel jlTokenGreen3=null;
   private JLabel jlTokenGreen4=null;
   private JLabel jlTokenYellow1=null;
   private JLabel jlTokenYellow2=null;
   private JLabel jlTokenYellow3=null;
   private JLabel jlTokenYellow4=null;
   /*
      ArrayLists which keep track of whos playing and whos turn it is
   */
   private ArrayList<String>playerList = new ArrayList<>();
   private int playerNameCounter = 0;
   private int playerNameNextPlayer = 1;
   private ArrayList<String>playerNames = new ArrayList<>();
   public String username = "";
   private String secondPlayerName = "";
   private String thirdPlayerName = "";
   private String fourthPlayerName = "";
   private int currentPlayerNameCounter = 0;
   public static JTextArea jtaMessages = new JTextArea();
   public JTextField jtfMessages;
   public JFrame chatFrame;

   
   private Icon blue1 = new ImageIcon("blue1.png");
   private Icon blue2 = new ImageIcon("blue2.png");
   private Icon blue3 = new ImageIcon("blue3.png");
   private Icon blue4 = new ImageIcon("blue4.png");
   
   private Icon red1 = new ImageIcon("red1.png");
   private Icon red2 = new ImageIcon("red2.png");
   private Icon red3 = new ImageIcon("red3.png");
   private Icon red4 = new ImageIcon("red4.png");
   
   private Icon green1 = new ImageIcon("green1.png");
   private Icon green2 = new ImageIcon("green2.png");
   private Icon green3 = new ImageIcon("green3.png");
   private Icon green4 = new ImageIcon("green4.png");
   
   private Icon yellow1 = new ImageIcon("yellow1.png");
   private Icon yellow2 = new ImageIcon("yellow2.png");
   private Icon yellow3 = new ImageIcon("yellow3.png");
   private Icon yellow4 = new ImageIcon("yellow4.png"); 
     
   //Coordinates
   
   //blue
   private int blue1x = 100;
   private int blue1y = 75;
   private int blue2x = 240;
   private int blue2y = 75;
   private int blue3x = 100;
   private int blue3y = 160;
   private int blue4x = 240;
   private int blue4y = 160;
   //red
   private int red1x = 750;
   private int red1y = 75;
   private int red2x = 890;
   private int red2y = 75;
   private int red3x = 750;
   private int red3y = 160;
   private int red4x = 890;
   private int red4y = 160;
   //green
   private int green1x = 750;
   private int green1y = 535;
   private int green2x = 890;
   private int green2y = 535;
   private int green3x = 750;
   private int green3y = 615;
   private int green4x = 890;
   private int green4y = 620;
   //yellow
   private int yellow1x = 90;
   private int yellow1y = 530;
   private int yellow2x = 230;
   private int yellow2y = 530;
   private int yellow3x = 90;
   private int yellow3y = 615;
   private int yellow4x = 230;
   private int yellow4y = 615;

   int blue1Pos = -1;
   boolean blue1out = false;
   
   private Pos position0 = new Pos(170,290);
   private Pos position1 = new Pos(250,290);
   private Pos position2 = new Pos(330,290);
   private Pos position3 = new Pos(410,290);
   private Pos position4 = new Pos(410,230);
   private Pos position5 = new Pos(410,180);
   private Pos position6 = new Pos(410,120);
   private Pos position7 = new Pos(410,60);
   private Pos position8 = new Pos(490,60);
   private Pos position9 = new Pos(570,60);
   private Pos position10 = new Pos(570,120);
   private Pos position11 = new Pos(570,180);
   private Pos position12 = new Pos(570,230);
   private Pos position13 = new Pos(570,290);
   private Pos position14 = new Pos(650,290);
   private Pos position15 = new Pos(730,290);
   private Pos position16 = new Pos(815,290);
   private Pos position17 = new Pos(900,290);
   private Pos position18 = new Pos(900,340);
   private Pos position19 = new Pos(900,400);
   private Pos position20 = new Pos(815,400);
   private Pos position21 = new Pos(730,400);
   private Pos position22 = new Pos(650,400);
   private Pos position23 = new Pos(570,400);
   private Pos position24 = new Pos(570,460);
   private Pos position25 = new Pos(570,515);
   private Pos position26 = new Pos(570,570);
   private Pos position27 = new Pos(570,630);
   private Pos position28 = new Pos(490,630);
   private Pos position29 = new Pos(410,630);
   private Pos position30 = new Pos(410,570);
   private Pos position31 = new Pos(410,515);
   private Pos position32 = new Pos(410,460);
   private Pos position33 = new Pos(410,400);
   private Pos position34 = new Pos(330,400);
   private Pos position35 = new Pos(250,400);
   private Pos position36 = new Pos(170,400);
   private Pos position37 = new Pos(90,400);
   private Pos position38 = new Pos(90,340);
   private Pos position39 = new Pos(90,290);
   
   private int numPlayers;

   private ArrayList<Pos> pos = new ArrayList<Pos>();

   String currPlayerName;
   int players;
   int minPlayers = 2;
   int maxPlayers = 4;
   int currPlayer;
   int roll;
   
   int redStart1X = 111;
   int redStart1Y = 222;
   
   /*
      This is a constructor. It initializes all variables that Ludo class uses
   */
   
   public Ludo(){
   
      pos.add(position0);
      pos.add(position1);
      pos.add(position2);
      pos.add(position3);
      pos.add(position4);
      pos.add(position5);
      pos.add(position6);
      pos.add(position7);
      pos.add(position8);
      pos.add(position9);
      pos.add(position10);
      pos.add(position11);
      pos.add(position12);
      pos.add(position13);
      pos.add(position14);
      pos.add(position15);
      pos.add(position16);
      pos.add(position17);
      pos.add(position18);
      pos.add(position19);
      pos.add(position20);
      pos.add(position21);
      pos.add(position22);
      pos.add(position23);
      pos.add(position24);
      pos.add(position25);
      pos.add(position26);
      pos.add(position27);
      pos.add(position28);
      pos.add(position29);
      pos.add(position30);
      pos.add(position31);
      pos.add(position32);
      pos.add(position33);
      pos.add(position34);
      pos.add(position35);
      pos.add(position36);
      pos.add(position38);
      pos.add(position39);
           
      //Creating background panel  
      imagePanel = new BackgroundPanel("board.png");
         
      imagePanel.addMouseListener(
         new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               System.out.printf("%d, %d\n",e.getX(),e.getY());
            }
         });
   
      add(imagePanel);
      repaint();
   
      //Main Menu for Ludo
      JMenuBar ludoMenuBar = new JMenuBar();
      JMenu ludoMenuFirst = new JMenu("Information");
      ludoMenuBar.add(ludoMenuFirst);
      
      JMenuItem jmiDescription = new JMenuItem("Description");
      JMenuItem jmiHelp = new JMenuItem("Help");
      JMenuItem jmiRestart = new JMenuItem("Restart");
      JMenuItem jmiExit = new JMenuItem("Exit");
      
      ludoMenuFirst.add(jmiDescription);
      ludoMenuFirst.add(jmiHelp);
      ludoMenuFirst.add(jmiRestart);
      ludoMenuFirst.add(jmiExit);
      ludoMenuBar.add(ludoMenuFirst);
     
      setJMenuBar(ludoMenuBar);
      
      //Creates panels for GUI of Ludo
      JPanel jpCenter = new JPanel();
      jpCenter.setLayout(null);
      JPanel jpSouth = new JPanel();
      jpSouth.setLayout(new FlowLayout());
      
      add(jpSouth, BorderLayout.SOUTH); 
      JLabel jlPressToRoll = new JLabel("Press to roll!");
      JButton jbRoll = new JButton("Click me to roll!");
      jpSouth.add(jlPressToRoll);
      jpSouth.add(jbRoll);
      
      //East Panel with chat function
/*     JPanel jpEast = new JPanel();
      jpEast.setLayout(new GridLayout());
      add(jpEast, BorderLayout.EAST);
            
      jpEast.add(messagesScroll);
      jpEast.add(jtfMessages);
      jpEast.add(jbSendMessage);
      jbSendMessage.setPreferredSize(new Dimension(40, 40));
*/    
      //Promts the user to enter a name which is used for chat
      String username = JOptionPane.showInputDialog("Hello! Please enter your name: ");
      //Builds a new JFrame - Chat Frame so that chat is easily placed where ever it is needed
      chatFrame = new JFrame();
      chatFrame.setResizable(false);
      chatFrame.setTitle("Player Chat!");
      chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      chatFrame.setLayout(new BorderLayout(0,0));
      chatFrame.setBounds(100,100,450,450);
      chatFrame.setLocation(1200,150);
      
      //JFrame attributes
      JTextField jtfMessages = new JTextField();
      jtfMessages.setColumns(25);
      jtaMessages.setEditable(false);
      JScrollPane messagesScroll = new JScrollPane(jtaMessages);
      chatFrame.getContentPane().add(messagesScroll);
      JButton jbSendMessage = new JButton("Send message!");
      //JPanel Chat
      JPanel jpChat = new JPanel();
      chatFrame.add(jpChat, BorderLayout.SOUTH);
      jpChat.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      //jpChat.add(messagesScroll);
      jpChat.add(jtfMessages);
      jpChat.add(jbSendMessage);
      
      chatFrame.setVisible(true);
      client = new Client(username, "localhost", 12345);
      /*
         Popup window which opens upon the launch of the program - sets the number of players and creates an ArrayList in which it adds the players
      */
      addWindowListener(
         new WindowAdapter(){
            public void windowOpened(WindowEvent we){
               Object[] possiblePick = {"2","3", "4"};
               Object selectAPick = JOptionPane.showInputDialog(null, "Please select the amount of players", 
                  "Message", JOptionPane.INFORMATION_MESSAGE, null, possiblePick, possiblePick[0]);
               try{
                  if(selectAPick.equals("2")){
                     playerList.add("Blue");
                     playerList.add("Red");
                     JOptionPane.showMessageDialog(null, "Hello! " + username + " you are assigned to blue!");
                     //username = JOptionPane.showInputDialog("Enter the name of the blue player!");
                     secondPlayerName = JOptionPane.showInputDialog("Enter the name of the red player!");
                     playerNames.add(username);
                     playerNames.add(secondPlayerName);
                     numPlayers = 2;
                  }else if(selectAPick.equals("3")){
                     playerList.add("Blue");
                     playerList.add("Red");
                     playerList.add("Green");
                     //username = JOptionPane.showInputDialog("Enter the name of the blue player!");
                     secondPlayerName = JOptionPane.showInputDialog("Enter the name of the red player!");
                     thirdPlayerName = JOptionPane.showInputDialog("Enter the name of the green player!");
                     playerNames.add(username);
                     playerNames.add(secondPlayerName);
                     playerNames.add(thirdPlayerName);
                     numPlayers = 3;
                  }else if(selectAPick.equals("4")){
                     playerList.add("Blue");
                     playerList.add("Red");
                     playerList.add("Green");
                     playerList.add("Yellow");
                     //username = JOptionPane.showInputDialog("Enter the name of the blue player!");
                     secondPlayerName = JOptionPane.showInputDialog("Enter the name of the red player!");
                     thirdPlayerName = JOptionPane.showInputDialog("Enter the name of the green player!");
                     fourthPlayerName = JOptionPane.showInputDialog("Enter the name of the yellow player!");
                     playerNames.add(username);
                     playerNames.add(secondPlayerName);
                     playerNames.add(thirdPlayerName);
                     playerNames.add(fourthPlayerName);
                     numPlayers = 4;
                  }
               }catch(NullPointerException npe){
                  npe.getMessage();
               }
            }});
      /*
         Adding functionaliy to the jbRoll this changes the button to a image and changes players & TO-DO moves players
         This is an action listener (annonymous inner class) used to get a number on a dice
      */
      try{
         jbRoll.addActionListener(
            new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent ae){
                  roll = (int)(Math.random() * 6 +1);
                  if(currentPlayerNameCounter == numPlayers){
                     currentPlayerNameCounter = 0;
                  }
                  if(roll == 6){
                     jbRoll.setIcon(new ImageIcon("dice6.png"));
                     Object[] possiblePick = {"Extra turn","New board piece"};
                     Object selectAPick = JOptionPane.showInputDialog(null, playerList.get(playerNameNextPlayer) + " has rolled a 6! This lets you chose to roll again or to put in a new board piece into play", 
                        "Message", JOptionPane.INFORMATION_MESSAGE, null, possiblePick, possiblePick[0]);
                     movePlayer();
                  
                  }else if(roll == 5){
                  //JOptionPane.showMessageDialog(null, playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameCounter) + " has rolled " + roll);
                     jlPressToRoll.setText(playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameNextPlayer) + "'s player turn!");
                     jbRoll.setIcon(new ImageIcon("dice5.png"));
                     playerNameCounter++;
                     playerNameNextPlayer++;
                     currentPlayerNameCounter++;
                     if(playerNameCounter == playerList.size()){
                        playerNameCounter = 0;
                        playerList.get(playerNameCounter);
                     }else if(playerNameNextPlayer == playerList.size()){
                        playerNameNextPlayer = 0;
                     }else if(currentPlayerNameCounter == playerNames.size()){
                        currentPlayerNameCounter = 0;
                     }
                  }else if(roll == 4){
                  //JOptionPane.showMessageDialog(null, playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameCounter) + " has rolled " + roll);
                     jlPressToRoll.setText(playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameNextPlayer) + "'s player turn!");
                     jbRoll.setIcon(new ImageIcon("dice4.png"));
                     playerNameCounter++;
                     playerNameNextPlayer++;
                     currentPlayerNameCounter++;
                     if(playerNameCounter == playerList.size()){
                        playerNameCounter = 0;
                     }else if(playerNameNextPlayer == playerList.size()){
                        playerNameNextPlayer = 0;
                     }else if(currentPlayerNameCounter == playerNames.size()){
                        currentPlayerNameCounter = 0;
                     }
                  }else if(roll == 3){
                  //JOptionPane.showMessageDialog(null, playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameCounter) + " has rolled " + roll);
                     jlPressToRoll.setText(playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameNextPlayer) + "'s player turn!");
                     jbRoll.setIcon(new ImageIcon("dice3.png"));
                     playerNameCounter++;
                     playerNameNextPlayer++;
                     currentPlayerNameCounter++;
                     if(playerNameCounter == playerList.size()){
                        playerNameCounter = 0;
                     }else if(playerNameNextPlayer == playerList.size()){
                        playerNameNextPlayer = 0;
                     }else if(currentPlayerNameCounter == playerNames.size()){
                        currentPlayerNameCounter = 0;
                     }
                  }else if(roll == 2){
                  //JOptionPane.showMessageDialog(null,playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameCounter) + " has rolled " + roll);
                     jlPressToRoll.setText(playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameNextPlayer) + "'s player turn!");
                     jbRoll.setIcon(new ImageIcon("dice2.png"));
                     playerNameCounter++;
                     playerNameNextPlayer++;
                     currentPlayerNameCounter++;
                     if(playerNameCounter == playerList.size()){
                        playerNameCounter = 0;
                     }else if(playerNameNextPlayer == playerList.size()){
                        playerNameNextPlayer = 0;
                     }else if(currentPlayerNameCounter == playerNames.size()){
                        currentPlayerNameCounter = 0;
                     }
                  }else if(roll == 1){
                  //JOptionPane.showMessageDialog(null, playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameCounter) + " has rolled " + roll);
                     jlPressToRoll.setText(playerNames.get(currentPlayerNameCounter) + " " + playerList.get(playerNameNextPlayer) + "'s player turn!");
                     jbRoll.setIcon(new ImageIcon("dice1.png"));
                     playerNameCounter++;
                     playerNameNextPlayer++;
                     currentPlayerNameCounter++;
                     if(playerNameCounter == playerList.size()){
                        playerNameCounter = 0;
                     }else if(playerNameNextPlayer == playerList.size()){
                        playerNameNextPlayer = 0;
                     }else if(currentPlayerNameCounter == playerNames.size()){
                        currentPlayerNameCounter = 0;
                     }
                  }
               
               //moving blue
                  if(roll == 6 && blue1out == false){
                  //go Out
                     blue1x = 86;
                     blue1y = 286;
                  
                     blue1Pos = 0;
                     blue1out = true;
                  
                  }
                  else if((roll == 6 || roll == 5 || roll == 4 || roll == 3 || roll == 2 || roll == 1) && blue1out == true){
                     
                     int onPos = blue1Pos;
                     blue1Pos = onPos + roll;
                  
                     blue1x = pos.get(blue1Pos).getX();
                     blue1y = pos.get(blue1Pos).getY();
                     repaint();
                  }
               
               }//end ActionPerformed
            
            });
      }catch (NullPointerException npe){
         npe.getMessage();
      }
      
      /*
         Adding functionality/ActionListeners to MenuItems
      */
      jmiDescription.addActionListener(
         new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               JOptionPane.showMessageDialog(null, "Ludo is a board game played between 2 to 4 players, the aim of the game is to get all the tokens outside their starting fields and into the fields in the middle just next to their starting zone. Once the player enters with all four tokens the player has won.");
            }
         });
      
      jmiHelp.addActionListener(
         new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               JOptionPane.showMessageDialog(null, "After selecting how much players are are going to play, enter the name of each player.\n After doing this press the button at the bottom of the screen to roll and move your pieces the pieces.");
            }
         });
      
      jmiRestart.addActionListener(
         new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               restartGame();
            }
         });
    
      jmiExit.addActionListener(
         new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               System.exit(0);
            }
         });
      jbSendMessage.addActionListener(
         new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               client.sendMessage(jtfMessages.getText());
               jtfMessages.setText("");
            }});
      //finalize
      setTitle("Ludo");
      setResizable(false);
      setSize(1000, 900);
      setLocation(200,100);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }

   /*
      This is the main method. It calls the Ludo class which creates the GUI board and initializes all the elements
   */
   public static void main(String[] args) throws IOException{
      new Ludo();
   }//End of main
   
   /*
   this is a move player method, it moves the tokens according to the number rolled
   */
   public void movePlayer(){
      
   }
   
   public void restartGame(){
      Object[] possiblePick = {"Restart","Close"};
      Object selectAPick = JOptionPane.showInputDialog(null, "Are you sure that you want to restart the game?", 
               "Message", JOptionPane.INFORMATION_MESSAGE, null, possiblePick, possiblePick[0]);
      if(selectAPick =="Restart"){
         dispose();
         new Ludo();
      }else if(selectAPick == "Close"){
         System.exit(0);      
      }
   }
   
  /* 
   This is a class which save s the coordinates of each position and enables you to get the coordinates of the positions
  */ 
   public class Pos{
      int x;
      int y;
      public Pos(int x,int y){
         this.x=x;
         this.y=y;
      }//end pos constructor
   
      int getX(){
         return this.x;
      }
   
      int getY(){
         return this.y;
      }
   
   }//end Pos class

   /*JPanel with image background
   this is a class which draws the background panel and the tokens
   */
   class BackgroundPanel extends JPanel
   {
      Image image;
      public BackgroundPanel(String imageName)
      {
         try
         {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource(imageName), imageName));
         }
         catch (Exception e) { /*handled in paintComponent()*/ }
      }
   
      @Override
      protected void paintComponent(Graphics g)
      {
         super.paintComponent(g); 
         if (image != null){
            g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
         } 
         blue1.paintIcon(this,g,blue1x-16,blue1y-16);
         blue2.paintIcon(this,g,blue2x-16,blue2y-16);
         blue3.paintIcon(this,g,blue3x-16,blue3y-16);
         blue4.paintIcon(this,g,blue4x-16,blue4y-16);
      
         red1.paintIcon(this,g,red1x-16,red1y-16);
         red2.paintIcon(this,g,red2x-16,red2y-16);
         red3.paintIcon(this,g,red3x-16,red3y-16);
         red4.paintIcon(this,g,red4x-16,red4y-16);
         
         green1.paintIcon(this,g,green1x-16,green1y-16);
         green2.paintIcon(this,g,green2x-16,green2y-16);
         green3.paintIcon(this,g,green3x-16,green3y-16);
         green4.paintIcon(this,g,green4x-16,green4y-16);
         
         yellow1.paintIcon(this,g,yellow1x-16,yellow1y-16);
         yellow2.paintIcon(this,g,yellow2x-16,yellow2y-16);
         yellow3.paintIcon(this,g,yellow3x-16,yellow3y-16);
         yellow4.paintIcon(this,g,yellow4x-16,yellow4y-16);
         
      }
   
   }//end class BackgroundPanel
   
   //Sets text area to include new messages from users
   public static void messagePrinter(String messages){
      jtaMessages.setText(jtaMessages.getText()+messages+"\n");
   }
}//end class