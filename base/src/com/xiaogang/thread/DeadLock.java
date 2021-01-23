package com.xiaogang.thread;

public class DeadLock {
	public static void main(String[] args) {

		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();

		new Thread() {
			@Override
			public void run() {

				synchronized (s1) {

					s1.append("A");
					s2.append("a");

					System.out.println(s1);
					System.out.println(s2);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}

					synchronized (s2) {
						s1.append("B");
						s2.append("b");

						System.out.println(s1);
						System.out.println(s2);
					}
				}

			};
		}.start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				synchronized (s2) {

					s1.append("C");
					s2.append("c");

					System.out.println(s1);
					System.out.println(s2);

					synchronized (s1) {
						s1.append("D");
						s2.append("d");

						System.out.println(s1);
						System.out.println(s2);
					}
				}

			}
		}).start();

	}
}
