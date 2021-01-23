package com.xiaogang.thread;

class Window extends Thread {

	private static int ticket = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (Window.class) {
				if (ticket > 0) {
					System.out.println(getName() + ": " + ticket);
					ticket--;
				} else {
					break;
				}
			}

		}
	}
}

public class WindowThread {
	public static void main(String[] args) {
		Window win1 = new Window();
		Window win2 = new Window();
		Window win3 = new Window();

		win1.start();
		win2.start();
		win3.start();
	}
}
