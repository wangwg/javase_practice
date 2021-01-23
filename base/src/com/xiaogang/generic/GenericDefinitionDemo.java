package com.xiaogang.generic;

public class GenericDefinitionDemo<T> {

	static <String, T, Alibaba> String get(String string, Alibaba alibaba) {
		return string;
	}

	public static void main(String[] args) {
		int first = 111;
		long second = 222;

		Integer result = get(first, second);
		System.out.println(result);
	}
}
