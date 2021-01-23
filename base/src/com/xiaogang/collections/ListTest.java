package com.xiaogang.collections;

import org.junit.Test;

import java.util.*;

public class ListTest {

	@Test
	public void test1() {

		List<String> list = new ArrayList<String>();

		list.add("Allen");
		list.add("Wayne");
		list.add("Martin");

		System.out.println(list);

		List<String> linkList = new LinkedList<String>();
		linkList.add("Allen");
		linkList.add("Wayne");
		linkList.add("Martin");

		System.out.println(linkList);
		linkList.add(2, "xiaOgang");
		System.out.println(linkList);

		List<String> list2 = new Vector<String>();
		list2.add("Allen");
		list2.add("Wayne");
		list2.add("Martin");
		System.out.println(list2);

	}

	@Test
	public void test2() {

		Set<String> hashSet = new HashSet<String>();
		hashSet.add("Allen");
		hashSet.add("Wayne");
		hashSet.add("Martin");
		System.out.println(hashSet);

	}

}
