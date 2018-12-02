package com.cs.multithreading;

import java.util.concurrent.Callable;

public class InterruptException {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadInterruptRunnableClass());
		t1.start();
		System.out.println("before calling interrupt");
		t1.interrupt();
		//t1.isInterrupted();
		System.out.println("after calling interrupt");
	}

}

class ThreadInterruptRunnableClass implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
				Thread.sleep(10);
				//Thread.currentThread().isInterrupted();
				if(Thread.interrupted()){ break; }
				 
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt(); // set the flag to true again,
												// don' t swallow the interrupts
		}
	}

}

class ThreadInterruptCallableClass implements Callable<String>{

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread.sleep(10);
		}
		return null;
	}
}
