package com.cs.ignitesol.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TCPServer {
  
  private static ExecutorService executorService = Executors.newFixedThreadPool(100);
  final static BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(1000);
  final static int TCP_PORT = 1122;
  
  public static void main(String[] args) throws Exception
  {
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    
    try {
      
      startUDPClient();
      
      serverSocket = new ServerSocket(TCP_PORT);
      
      while (true) {
        clientSocket = serverSocket.accept();
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

  private static void startUDPClient()
  {
    UDPServer server = new UDPServer(queue);
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
  
  private static final String IP = "localhost";
  final static int UDP_PORT = 1123;
  private BlockingQueue<Object> queue;
  
  public UDPServer(BlockingQueue<Object> queue)
  {
    super();
    this.queue = queue;
  }
  
  @Override
  public void run()
  {
    DatagramSocket datagramSocket = null;
    InetAddress IPAddress;
    
    try {
      datagramSocket = new DatagramSocket();
      IPAddress = InetAddress.getByName(IP);
      
      while(true){
        Object msg = queue.poll();
        if(msg != null){
          String sendMsg = (String) msg;
          byte[] sendData = new byte[1024];
          sendData = sendMsg.getBytes();
          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, UDP_PORT);
          datagramSocket.send(sendPacket);
          sendData = null;
        }
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      datagramSocket.close();
    }
    
  }
}
