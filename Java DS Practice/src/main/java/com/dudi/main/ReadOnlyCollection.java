package com.dudi.main;

import java.util.*;

public class ReadOnlyCollection {
 
 
    public static void main(String args[]) {
     
        //creating read only Collection in Java
        Collection readOnlyCollection = Collections.unmodifiableCollection(new ArrayList<String>());
        readOnlyCollection.add("Sydney Sheldon"); //raises UnSupportedOperation exception
   
        //making existing ArrayList readonly in Java
        ArrayList readableList = new ArrayList();
        readableList.add("Jeffrey Archer");
        readableList.add("Khalid Hussain");
     
        List unmodifiableList = Collections.unmodifiableList(readableList);
     
        //add will throw Exception because List is readonly
        unmodifiableList.add("R.K. Narayan");
     
        //remove is not allowed in unmodifiable list
        unmodifiableList.remove(0);
     
        //set is not allowed in unmodifiable List
        unmodifiableList.set(0, "Anurag Kashyap");
     
        //creating Fixed Length List from Array in Java
        List fixedLengthList = Arrays.asList("Mark" , "Twen");
        // readOnlyList.add("J.K. Rowling"); //raises Exception
     
        fixedLengthList.set(0, "J.K. Rowling"); //allowed that's why not read only list
        System.out.println(fixedLengthList.get(0));
    }
 
}