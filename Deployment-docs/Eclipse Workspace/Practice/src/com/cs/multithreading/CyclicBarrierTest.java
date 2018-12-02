package com.cs.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(2);
		CyclicBarrier barrier = new CyclicBarrier(2);
		service.submit(new DependetCyclicService(barrier));
		
		service.submit(new DependetCyclicService(barrier));
		
	}

}

class DependetCyclicService implements Runnable {

	private CyclicBarrier barrier;
	
	public DependetCyclicService(CyclicBarrier latch) {
		this.barrier = latch;
	}

	@Override
	public void run() {
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}
