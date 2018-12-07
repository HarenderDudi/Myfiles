package com.cs.ignitesol.tcp.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

import com.cs.utils.Utils;


public class TCPClient {
  
  private static final String TCP_PORT = "tcp_port";
  private static final String TCP_IP   = "tcp_ip";
  private static String       tcpIp;
  private static int          tcpPort;
  
  public static void main(String[] args) throws Exception
  {
    Properties prop = Utils.readPropertiesFile();
    
    // initialize ip and port
    initializeParameters(prop);
    
    int quit = 0;
    Socket client = null;
    Scanner sc = null;
    
    try {
      
      // create a socket connection
      client = new Socket(tcpIp, tcpPort);
      
      System.out.println("** Enter 'Q' to exit.\n");
      
      while(quit == 0)
      {
        // get input from client
        sc = new Scanner(System.in);
        String text = sc.nextLine();
        
        // handle exit keyword 
        if(text.equalsIgnoreCase("q")){
          quit = 1;
          continue;
        }
        
        // write data to socket outputstream
        PrintStream printStream = new PrintStream(client.getOutputStream());
        printStream.println(text);
        printStream.flush();
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    } 
    finally {
      // close all the connections
      client.close();
      sc.close();
    }
  }

  private static void initializeParameters(Properties prop)
  {
    if(prop != null){
      // get the property value
      String portString = prop.getProperty(TCP_PORT);
      tcpIp = prop.getProperty(TCP_IP);
      tcpPort = Integer.parseInt(portString);  
    } else {
      tcpIp = "localhost";
      tcpPort = 1122; 
    }
  }
}
