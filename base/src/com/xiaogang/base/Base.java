package com.xiaogang.base;

public class Base {

    public static void main(String[] args) {

        // 8进制，0开头，表示10进制15
        int a = 017;
        // 16进制，0x开头，表示10进制161
        int b = 0xa1;
        System.out.println(a);
        System.out.println(b);

        int c = 3 / 2; //1
        double d = 3 / 2;//1.0
        double e = 3.0 / 2;//1.5
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        int and = 4 & 5;
        System.out.println(and);
        int and1 = -4 & 5;
        System.out.println(and1);

        Integer i1 = new Integer(100);
        Integer i2 = Integer.valueOf(100);
        Integer i3 = Integer.valueOf(100);
        Integer i4 = 100; // 直接赋值实际上调用的就是valueof方法

        System.out.println(i1 == i2); // false
        System.out.println(i2 == i3); // true
        System.out.println(i3 == i4); // true
        System.out.println(i3 == i4); // true

    }
}
