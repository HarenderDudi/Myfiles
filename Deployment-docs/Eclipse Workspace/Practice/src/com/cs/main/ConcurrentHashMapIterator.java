package com.cs.main;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapIterator {
  
  public static void main(String[] args)
  {
    System.out.println("----------------------------------------");
    ConcurrentHashMap<String, String> myMap = new ConcurrentHashMap<String, String>();
    myMap.put("1", "One");
    myMap.put("2", "Two");
    myMap.put("3", "Three");
    myMap.put("4", "Four");
    myMap.put("5", "Five");
    
    scenario1(myMap);
  }

  private static void scenario1(ConcurrentHashMap<String, String> myMap)
  {
    myMap.forEach((k, v) -> {
      System.out.println(k + " in " + v);
      if (k.equals("3")) {
        myMap.put("6", "Six");
      }
    });
    System.out.println("out");
    
    myMap.forEach((k, v) -> {
      System.out.println(k + " in " + v);
    });
  }
  
  private static void scenario2(ConcurrentHashMap<String, String> myMap)
  {
    myMap.forEach((k, v) -> {
      System.out.println(k + " in " + v);
      if (k.equals("3")) {
        myMap.put("3", "Six");
      }
    });
    System.out.println("out");
    
    myMap.forEach((k, v) -> {
      System.out.println(k + " in " + v);
    });
  }
}
