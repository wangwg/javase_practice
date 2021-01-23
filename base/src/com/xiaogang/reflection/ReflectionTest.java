package com.xiaogang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) {

		Person person = null;
		try {
			Class<?> clazz = Class.forName("com.java.reflection.Person");

			Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
			person = (Person) declaredConstructor.newInstance();

			Method declaredMethod = clazz.getDeclaredMethod("getMrName", String.class);
			declaredMethod.setAccessible(true);
			Object returnValue = declaredMethod.invoke(person, "abc");

			System.out.println(returnValue);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(person);

	}

}
