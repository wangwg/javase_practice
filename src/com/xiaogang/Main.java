package com.xiaogang;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        // write your code here
        System.out.println("Hello World!");

        ArrayList<Integer> integers = new ArrayList<>();

        var date = new Date();

        int a = 0xffffffff;
        System.out.println("a = " + a);

        String s1 = new String("hello");
        String s2 = new String("hello");

        String s3 = "hello";
        String s4 = "hello";

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);

        System.out.println(-127 & 127);
        // 1111,1111 1000,0001
        // 0111,1111 & 1000,0001 = 0000,0001 = 1

        // test1(1,new Integer(1));
        test();

    }

    private static void test1(int a, Integer i) {

    }

    private static void test1(Integer i, int a) {

    }

    private void testArr() {
        int[][] arr1 = new int[2][3];
        int[][] arr2 = new int[2][];
        int[][] arr3 = {{0, 1, 2}, {0}, {0, 1, 2, 3, 4, 5, 6, 7,}};
    }

    private static void test() {
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 3;
        int[] b = a;
        a[0] = 4;

        System.out.println(b[0]);

        a = new int[3];
        b = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 3;
        b[0] = a[0];
        a[0] = 4;

        System.out.println(b[0]);
    }
}
