package com.xiaogang.thread;

class Signleton {

	private Signleton() {
		System.out.println("Hello");
	}

	// volatile防止指令重排，在双重检查的懒汉式必须
	private static volatile Signleton instance = null;

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
