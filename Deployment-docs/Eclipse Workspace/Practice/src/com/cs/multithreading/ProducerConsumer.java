package com.cs.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	static ReentrantLock lock = new ReentrantLock();
	static Queue<String> queue = new LinkedList<>();
	static Condition notFull = lock.newCondition();
	static Condition notEmpty = lock.newCondition();

	public static void main(String[] args) {

		// reference: https://www.youtube.com/watch?v=UOr9kMCCa5g
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.submit(() -> {
			int i = 0;
			while (i<=10) {
				System.out.println("producer 1 : " + queue.size());
				producer();
				i++;
			}
		});
		
		new Thread(() -> {
			int i = 0;
			while (i<=10) {
				System.out.println("producer 1 : " + queue.size());
				producer();
				i++;
			}
		}).start();

		new Thread(() -> {
			int i = 0;
			while (i<=10) {
				System.out.println("producer 2 : " + queue.size());
				producer();
				i++;
			}
		}).start();

		new Thread(() -> {
			int i = 0;
			while (i<=10) {
				System.out.println("consumer 1 : " + queue.size());
				consumer();
				i++;
			}
		}).start();

//		new Thread(() -> {
//			int i = 0;
//			while (i<=10) {
//				System.out.println("consumer 2 : " + queue.size());
//				consumer();
//				i++;
//			}
//		}).start();

	}

	public static void producer() {
		lock.lock();
		try {
			while (queue.size() == 2) {
				System.out.println("producer waiting");
				notFull.await();
			}
			queue.add("A");
			System.out.println("produced");
			notEmpty.signalAll();
		} catch (InterruptedException e) {

		} finally {
			lock.unlock();
		}

	}

	public static void consumer() {
		lock.lock();
		try {
			while (queue.size() == 0) {
				System.out.println("consumer waiting");
				notEmpty.await();
			}
			queue.remove();
			System.out.println("consumed");
			notFull.signalAll();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
