package com.xiaogang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class WindowCall implements Callable {

	private int ticket = 100;

	@Override
	public Object call() throws Exception {

		while (true) {

			synchronized (this) {

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
			}

		}

		return null;

	}
}

public class WindowCallable {

	public static void main(String[] args) {

		WindowCall windowCall = new WindowCall();

		FutureTask task = new FutureTask(windowCall);
		FutureTask task1 = new FutureTask(windowCall);

		new Thread(task).start();
		new Thread(task1).start();

		try {
			Object obj = task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
