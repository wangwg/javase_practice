package com.xiaogang.annotation;

public class RegexMatches {
	public static void main(String[] args) {
		String str = "123456789-AA";
		String pattern = "\\d{9}-[a-zA-z0-9]{2}";

//		Pattern r = Pattern.compile(pattern);
//		Matcher m = r.matcher(str);
//		System.out.println(m.matches());

		System.out.println(str.matches(pattern));
	}
}
