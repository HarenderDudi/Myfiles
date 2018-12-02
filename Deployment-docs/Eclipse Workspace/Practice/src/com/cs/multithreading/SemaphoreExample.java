package com.cs.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) throws InterruptedException {

		SemaphoreTest t1 = new SemaphoreTest("A");
		t1.start();

		SemaphoreTest t2 = new SemaphoreTest("B");
		t2.start();

		/*SemaphoreTest t3 = new SemaphoreTest("C");
		t3.start();

		SemaphoreTest t4 = new SemaphoreTest("D");
		t4.start();*/

		/*SemaphoreTest t5 = new SemaphoreTest("E");
		t5.start();

		SemaphoreTest t6 = new SemaphoreTest("F");
		t6.start();*/
	}

	static class SemaphoreTest extends Thread {

		String name = "";
		static Semaphore semaphore = new Semaphore(1); // static is must, so that same semaphore can be shared b/w all the threads

		SemaphoreTest(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {

				//System.out.println(name + " : acquiring lock...");
				System.out.println(name	+ " : available Semaphore permits now: "
						+ semaphore.availablePermits());

				semaphore.acquire();
				System.out.println(name + " : got the permit!");
				System.out.println(name	+ " : available Semaphore permits now: "
						+ semaphore.availablePermits());

				try {

					//for (int i = 1; i <= 2; i++) {

						/*System.out.println(name + " : is performing operation "
								+ i + ", available Semaphore permits : "
								+ semaphore.availablePermits());*/

						// sleep 1 second
						Thread.sleep(1000);

					//}

				} finally {

					// calling release() after a successful acquire()
					System.out.println(name + " : releasing lock...");
					semaphore.release();
					System.out.println(name
							+ " : available Semaphore permits now: "
							+ semaphore.availablePermits());

				}

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}
}

/*class SemaphoreRunnable implements Runnable {

	@Override
	public void run() {
		semaphore.
	}
	
}*/
