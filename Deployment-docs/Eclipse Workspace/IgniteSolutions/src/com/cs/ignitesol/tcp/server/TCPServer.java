package com.cs.ignitesol.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cs.utils.Utils;


public class TCPServer {
  
  private static final String        TCP_PORT        = "tcp_port";
  private static final String        UDP_IP          = "udp_ip";
  private static final String        UDP_PORT        = "udp_port";
  
  private static int                 tcpPort;
  private static int                 udpPort;
  private static String              udpIp;

  private static ExecutorService     executorService = Executors.newFixedThreadPool(100);
  final static BlockingQueue<Object> queue           = new ArrayBlockingQueue<Object>(1000);
  
  public static void main(String[] args) throws Exception
  {
    Properties prop = Utils.readPropertiesFile();
    
    // initialize ip and port
    initializeParameters(prop);
    
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    
    try {
      
      // start a UDP writer
      startUDPClient();
      
      serverSocket = new ServerSocket(tcpPort);
      
      while (true) 
      {
        // create a new socket connection with client, when new client is trying to connect
        clientSocket = serverSocket.accept();
        
        // handle this connection in a different thread, so that multiple client requests can be served simultaneously
        Runnable connectionHandler = new ConnectionHandler(clientSocket, queue);
        executorService.submit(connectionHandler);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    } 
    finally {
      serverSocket.close();
      executorService.shutdown();
    }
    
  }

  private static void initializeParameters(Properties prop)
  {
    if(prop != null){
      // get the property value
      String portString = prop.getProperty(TCP_PORT);
      tcpPort = Integer.parseInt(portString); 
      
      String udpPortString = prop.getProperty(UDP_PORT);
      udpPort = Integer.parseInt(udpPortString); 
      
      udpIp = prop.getProperty(UDP_IP);
    } else {
      tcpPort = 1122;
      udpPort = 1123;
      udpIp = "localhost";
    }
  }
  
  private static void startUDPClient()
  {
    // create a instance of writer and start in a new thread
    UDPServer server = new UDPServer(queue, udpPort, udpIp);
    Thread udpServerThread = new Thread(server);
    udpServerThread.start();
  }
}

class ConnectionHandler implements Runnable {
  
  Socket clientSocket;
  private BlockingQueue<Object> queue;
  
  public ConnectionHandler(Socket clientSocket, BlockingQueue<Object> queue)
  {
    super();
    this.clientSocket = clientSocket;
    this.queue = queue;
  }
  
  @Override
  public void run()
  {
    BufferedReader reader = null;

    try {
      
      System.out.println("New TCP Client Added : " + Thread.currentThread().getName());
      reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      
      // read the message from client and put in blocking queue
      String nextline;
      while ((nextline = reader.readLine()) != null) {
        System.out.println(nextline);
        try {
          queue.put(nextline);
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    catch (IOException e) 
    {
      System.out.println("Connection Closed: " + Thread.currentThread().getName());
    } 
    finally
    {
      try {
        // close connections
        clientSocket.close();
        reader.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

class UDPServer implements Runnable {
  
  private BlockingQueue<Object> queue;
  private int                 udpPort;
  private String              udpIp;
  
  public UDPServer(BlockingQueue<Object> queue, int udpPort, String udpIp)
  {
    super();
    this.queue = queue;
    this.udpPort = udpPort;
    this.udpIp = udpIp;
  }
  
  @Override
  public void run()
  {
    DatagramSocket datagramSocket = null;
    InetAddress IPAddress;
    
    try 
    {
    
      // create a DatagramSocket to carry packet to its destination
      datagramSocket = new DatagramSocket();
      IPAddress = InetAddress.getByName(udpIp);
      
      while(true)
      {
        // get the message from queue, it will return null if queue is empty
        Object msg = queue.poll();
      
        // send if message is not null
        if(msg != null)
        {
          // convert the message into byte[] and send the packet to destination
          byte[] sendData = getDataBytes(msg);
          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, udpPort);
          datagramSocket.send(sendPacket);
          
          // clear byte[]
          sendData = null;
        }
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      // close connection
      datagramSocket.close();
    }
    
  }

  private byte[] getDataBytes(Object msg)
  {
    String sendMsg = (String) msg;
    byte[] sendData = new byte[1024];
    sendData = sendMsg.getBytes();
    return sendData;
  }

}
