package com.cs.ignitesol.tcp.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class TCPClient {
  
  private static final String IP = "localhost";

  public static void main(String[] args) throws Exception
  {
    
    int quit = 0;
    Socket client = null;
    Scanner sc = null;
    try {
      client = new Socket(IP, 1122);
      System.out.println("** Enter 'Q' to exit. \n**");
      while(quit == 0){
        sc = new Scanner(System.in);
        String text = sc.nextLine();
        if(text.equalsIgnoreCase("q")){
          quit = 1;
          continue;
        }
        PrintStream printStream = new PrintStream(client.getOutputStream());
        printStream.println(text);
        printStream.flush();
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    } 
    finally {
      client.close();
      sc.close();
    }
  }
  
}
