/**
 *Julia Smith
 *Date: Dec 4, 2020
 * 
 */

package application;
 

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Server extends Application {
	
	 static int  flag = 0;
	 String result = null;
	 int num;
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Text area for displaying contents
    TextArea ta = new TextArea();

    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 450, 200);
    primaryStage.setTitle("Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    new Thread( () -> {
      try {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        Platform.runLater(() ->
          ta.appendText("Server started at " + new Date() + '\n'));
  
        // Listen for a connection request
        Socket socket = serverSocket.accept();
  
        // Create data input and output streams
        DataInputStream inputFromClient = new DataInputStream(
          socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
          socket.getOutputStream());
  
        
       
        while (true) {
          // Receive number from the client
          
        	num = inputFromClient.readInt();
        
//        	boolean flag = false;
//         
//        	 for (int i = 2; i <= num / 2; ++i) {
//        	      // condition for nonprime number
//        	      if (num % i == 0) {
//        	        flag = true;
//        	        break;
//        	      }
//        	    }
//          
//        	 if (!flag)
//        	      System.out.println(num + " is a prime number.");
//        	    else
//        	      System.out.println(num + " is not a prime number.");
          
        	int  i = 2;
            boolean flag = false;
            while (i <= num / 2) {
              // condition for nonprime number
              if (num % i == 0) {
                flag = true;
                break;
              }

              ++i;
            }

            if (!flag)
              System.out.println(num + " is a prime number.");
            else
              System.out.println(num + " is not a prime number.");		
					
 
          // Send area back to the client
         
        outputToClient.writeBoolean(flag);
  
          Platform.runLater(() -> {
            ta.appendText("Number received from client: " 
              + num + '\n');
        //    ta.appendText(num + result +'\n' ); 
          });
      }
    }
      
      catch(IOException ex) {
        ex.printStackTrace();
      }
  }).start();
}

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
