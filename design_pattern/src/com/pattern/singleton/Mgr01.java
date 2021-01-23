package com.pattern.singleton;

/*
 * 懒汉式
 */
public class Mgr01 {

	private static Mgr01 INSTANCE = new Mgr01();

	private Mgr01() {
	}

	public static Mgr01 getInstance() {
		return INSTANCE;
	}
}
