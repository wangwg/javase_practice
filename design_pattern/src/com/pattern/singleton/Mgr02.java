package com.pattern.singleton;

/*
 * 饿汉式
 * 线程安全
 */
public class Mgr02 {

	// volatile防止指令重排 JIT
	private static volatile Mgr02 INSTANCE;

	private Mgr02() {
	}

	public static Mgr02 getInstance() {
		// 双重检查
		if (INSTANCE == null) {
			synchronized (Mgr02.class) {
				if (INSTANCE == null) {
					INSTANCE = new Mgr02();
				}
			}
		}
		return INSTANCE;
	}
}
