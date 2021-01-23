package com.xiaogang.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class NumberTest implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}

		}

	}

}

public class ThreadPoolText {

	public static void main(String[] args) {

		// ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		ThreadPoolExecutor newFixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

		// newFixedThreadPool.setCorePoolSize(2);

		newFixedThreadPool.execute(new NumberTest());
		newFixedThreadPool.execute(new NumberTest());
		newFixedThreadPool.execute(new NumberTest());

		newFixedThreadPool.shutdown();

	}

}
