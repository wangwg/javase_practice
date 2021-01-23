package com.pattern.strategy;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Cat[] cats = new Cat[] { new Cat(1, 1), new Cat(9, 9), new Cat(5, 5) };

		final Sorter<Cat> sorter = new Sorter<>();
		// 传入不同排序策略
		sorter.sort(cats, (c1, c2) -> Integer.compare(c1.getWeight(), c2.getWeight()));

		System.out.println(Arrays.toString(cats));
	}
}
