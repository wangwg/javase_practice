package com.xiaogang.annotation;

public class AnnotationTest {

	@MyAnnotation
	public void testAnnotation() {

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Currency cn = Currency.CN;
		System.out.println(cn.code);

		found: {
			if (cn != null) {
				break found;
			}
		}
	}
}
