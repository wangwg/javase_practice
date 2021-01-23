package com.xiaogang.thread;

class Signleton {

	private Signleton() {
		System.out.println("Hello");
	}

	private static Signleton instance = null;

	public static Signleton getInstance() {

		if (instance == null) {

			synchronized (Signleton.class) {

				if (instance == null) {
					instance = new Signleton();
				}

			}

		}

		return instance;

	}
}

public class SignletonTest {

	public static void main(String[] args) {
		Signleton.getInstance();
	}
}
