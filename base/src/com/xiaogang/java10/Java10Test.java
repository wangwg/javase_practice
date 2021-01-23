package com.xiaogang.java10;

import org.junit.Test;

import java.util.ArrayList;

public class Java10Test {

	@Test
	public void test1() {

		var number = 10;

		var list = new ArrayList<Integer>();
		list.add(100);
		list.add(number);

		for (var item : list) {
			// 100,class java.lang.Integer
			// 10,class java.lang.Integer
			System.out.println(item + "," + item.getClass());
		}

		// var url = new URL("www.sina.com.cn");

	}
}
