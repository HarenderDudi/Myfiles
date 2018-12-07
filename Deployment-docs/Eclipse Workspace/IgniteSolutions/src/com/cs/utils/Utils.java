package com.cs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.cs.ignitesol.tcp.client.TCPClient;


public class Utils {
  
  public static Properties readPropertiesFile()
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
