package com.xiaogang.thread;

import java.util.concurrent.locks.ReentrantLock;

class WindowNew implements Runnable {

	private int ticket = 100;

	private ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {

		while (true) {

			// synchronized (this) {

			try {

				lock.lock();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + ": " + ticket);
					ticket--;
				} else {
					break;
				}

			} finally {
				lock.unlock();
			}

			// }

		}
	}

}

public class WindowRunable {

	public static void main(String[] args) {
		WindowNew windowNew = new WindowNew();

		Thread t1 = new Thread(windowNew);
		Thread t2 = new Thread(windowNew);
		Thread t3 = new Thread(windowNew);

		t1.start();
		t2.start();
		t3.start();
	}
}
