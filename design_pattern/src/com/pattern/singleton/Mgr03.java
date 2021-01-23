package com.pattern.singleton;

/*
 * 静态内部类
 * JVM保证单例，保证线程安全
 * 加载外部类时不会加载内部类，实现懒加载
 */
public class Mgr03 {

	private Mgr03() {
	}

	private static class Mgr03Holder {
		private static final Mgr03 INSTANCE = new Mgr03();
	}

	public static Mgr03 getInstance() {
		return Mgr03Holder.INSTANCE;
	}

}
