package com.xiaogang.thread;

public class ThreadLocalTest {

	static ThreadLocal<String> tl = new ThreadLocal<>();

	public static void main(String[] args) {

		// 线程1
		new Thread(() -> {
			tl.set("线程1的value");

			System.out.println("线程1：" + tl.get());

			tl.remove();
		}).start();

		// 线程2
		new Thread(() -> {
			// 无法取得线程1的value
			System.out.println("线程2：" + tl.get());
		}).start();
	}

}
