package com.xiaogang.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * xiaOgang
 */
public class Hello {

    // prsf
    private static final int PAGE = 0;

    // psf
    public static final int AGE = 0;

    // psfs
    public static final String NAME = "hello";

    // psfi
    public static final int AGE_1 = 28;

    public static void main(String[] args) {
        int a = 0;
        Date date = new Date();
        // sout
        System.out.println("Hello World");
        // soutp
        System.out.println("args = " + Arrays.deepToString(args));
        // soutm
        System.out.println("Hello.main");
        // soutv
        System.out.println("date = " + date);
        // a.soutv
        System.out.println("a = " + a);

        String[] arr = new String[]{"Allen", "Wayne"};
        // iter
        for (String s : arr) {

        }
        // arr.fori
        for (int i = 0; i < arr.length; i++) {

        }

        ArrayList<String> list = new ArrayList<>();
        list.add("Allen");
        list.add("Wayne");
        // list.for
        for (String s : list) {

        }
        // list.fori
        for (int i = 0; i < list.size(); i++) {

        }
        // list.forr 倒叙
        for (int i = list.size() - 1; i >= 0; i--) {

        }

        // ifn
        if (list == null) {

        }
        // inn
        if (list != null) {

        }

        // list.null
        if (list == null) {

        }

        // list.nn
        if (list != null) {

        }
    }
}
