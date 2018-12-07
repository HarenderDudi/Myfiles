package com.cs.ignitesol.udp;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Properties;

import com.cs.ignitesol.tcp.client.TCPClient;
import com.cs.utils.Utils;


public class UDPClient {
  
  private static final String INET_ADDR = "inetAddr";
  private static final String UDP_PORT  = "udp_port";
  private static final String UTF_8     = "UTF-8";
  
  private static String       inetAddr;
  private static int          udpPort;

  public static void main(String[] args) throws Exception
  {
    Properties prop = Utils.readPropertiesFile();
    initializeParameters(prop);
    
    
    InetAddress address = InetAddress.getByName(inetAddr);
    MulticastSocket clientSocket = null;
    
    try {
      // Create a multicast socket and join a multicast group
      clientSocket = new MulticastSocket(udpPort);
      clientSocket.joinGroup(address);
      
      while (true) 
      {
        // create a DatagramPacket so that it can receive packets
        byte[] buf = new byte[256];
        DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
        clientSocket.receive(msgPacket);

        // print the message and clear the byte[]
        String msg = new String(buf, 0, buf.length, UTF_8);
        System.out.println(msg.trim());
        buf = null;
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    } 
    finally {
      // close connection
      clientSocket.close();
    }

  }


  private static void initializeParameters(Properties prop)
  {
    if (prop != null) {
      // get the property value
      inetAddr = prop.getProperty(INET_ADDR);
      
      String udpPortString = prop.getProperty(UDP_PORT);
      udpPort = Integer.parseInt(udpPortString);
      
    }
    else {
      udpPort = 1123;
      inetAddr = "224.0.0.1";
    }
  }
  

  private static Properties readPropertiesFile()
  {
    Properties prop = new Properties();
    InputStream input = null;

    try {

      String filename = "config.properties";
      input = TCPClient.class.getClassLoader().getResourceAsStream(filename);
      
      if (input == null) {
        System.out.println("Sorry, unable to find " + filename);
        return null;
      }
      
      // load a properties file
      prop.load(input);

      return prop;
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    finally {
      if (input != null) {
        try {
          input.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return prop;
  }
  
}
