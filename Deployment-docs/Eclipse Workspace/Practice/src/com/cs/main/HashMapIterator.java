package com.cs.main;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {
    public static void main(String[] args){
        Map myMap = new HashMap();

        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator it1 = myMap.keySet().iterator();
        while(it1.hasNext()){
            String key = (String) it1.next();
            System.out.println("Map Value:"+myMap.get(key));
            if(key.equals("2")){
                myMap.put("1","4"); // won't throw error
                // myMap.put("4", "4"); // will throw concurrentModificationError error
            }
        }
        
      myMap.forEach((k,v) -> System.out.println("---- " + v));
    }
}
