package com.cs.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(2);
		CountDownLatch latch = new CountDownLatch(2);
		
		service.submit(new DependetService(latch));
		/*Thread.sleep(2);
		System.out.println(latch.getCount());*/
		
		service.submit(new DependetService(latch));
		/*Thread.sleep(2);
		System.out.println(latch.getCount());*/
		
		latch.await();
		//System.out.println("Latch Down  " + latch.getCount()+ " --- " + Thread.currentThread().getName());
		System.out.println("All threads initialized");
		service.shutdownNow();
	}

}

class DependetService implements Runnable {

	private CountDownLatch latch;
	
	public DependetService(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10);
			latch.countDown();
			System.out.println("Latch Down  " + latch.getCount()+ " --- " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
