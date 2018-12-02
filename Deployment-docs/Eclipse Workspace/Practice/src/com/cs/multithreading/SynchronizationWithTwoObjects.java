package com.cs.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SynchronizationWithTwoObjects {
	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable Task1 = () -> {
		    try {
		    	synchronized (lock) {
		    		synchronousMethod();
				}
		    } catch (Exception e) {
				e.printStackTrace();
			}finally {
		    }
		};
		
		Runnable Task2 = () -> {
		    try {
		    	synchronized (lock2) {
		    		synchronousMethod();
				}
		    } catch (Exception e) {
				e.printStackTrace();
			}finally {
		    }
		};
		executor.submit(Task1);
		executor.submit(Task2);
		//executor.shutdownNow();
	}
	
	public static void synchronousMethod() throws InterruptedException{
		System.out.println("In Synchronous Method Before" + Thread.currentThread().getName());
		Thread.sleep(2000);
		System.out.println("In Synchronous Method After");
	}
}

