package com.cs.main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableVsRunnable {

	public static void main(String[] args) {
		
		/*Thread thread = new Thread(new RunnableExample());
	    thread.start();*/
		
		
		int a = 1;
	    int b = 2;
	    
	    Callable<Integer> callable = new Summation(a,b);
	    
	    ExecutorService exec = Executors.newFixedThreadPool(3);
	    
	    Future<Integer> future = exec.submit(callable);
	    
	    try {
	      int result = future.get();
	      System.out.println(a + " + " + b + " = " + result); 
	    } 
	    catch (Exception e) {
	      System.out.println("The error is: " + e);
	    }
	}
}

class RunnableExample implements Runnable {
	  
	  @Override
	  public void run()  {
	    System.out.println("Hello World");
	  }  
}

class Summation implements Callable<Integer> {
	  private int a;
	  private int b;
	  
	  public Summation(int a, int b) {
	    this.a = a;
	    this.b = b;
	  }
	  
	  @Override
	  public Integer call() {
	    return this.a+this.b;
	  }
}