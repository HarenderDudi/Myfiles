package com.cs.main;

import java.util.ArrayList;
import java.util.List;


public class ArrayListConcurrentModification {
  
  public static void main(String[] args) throws Exception
  {
    //Employee raj = new Raj();
    List<String> list = new ArrayList<String>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    ModifyList modifyList = new ModifyList(list);
    modifyList.start();
    
    for (String string : list) {
      System.out.println(string);
    }
  }
}
  

class ModifyList extends Thread{

  List<String> list;
  
  public ModifyList(List<String> list)
  {
    this.list = list;
  }
  
  @Override
  public void run()
  {
    list.add("five");
    try {
      Thread.sleep(1000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
}
