package com.xiaogang.thread;

class MyThread extends Thread {

	private static int value = 0;

	@Override
	public void run() {

		while (value < 100) {

			synchronized (MyThread.class) {

				MyThread.class.notify();

				System.out.println(getName() + ": " + value);
				value++;

				try {
					MyThread.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}

public class ThreadTest {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		MyThread myThread2 = new MyThread();
		myThread.start();
		myThread2.start();
	}
}
