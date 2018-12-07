package com.cs.ignitesol.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class UDPClient {
  
  final static String INET_ADDR = "224.0.0.1";
  final static int PORT = 1123;

  
  public static void main(String[] args) throws Exception
  {
    InetAddress address = InetAddress.getByName(INET_ADDR);
    MulticastSocket clientSocket = null;
    
    try {
      clientSocket = new MulticastSocket(PORT);
      clientSocket.joinGroup(address);
      
      while (true) {
        byte[] buf = new byte[256];
        DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
        clientSocket.receive(msgPacket);

        String msg = new String(buf, 0, buf.length, "UTF-8");
        System.out.println(msg.trim());
        buf = null;
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    } 
    finally {
      clientSocket.close();
    }

  }
  
}
