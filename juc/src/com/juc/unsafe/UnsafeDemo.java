package com.juc.unsafe;

import sun.misc.Unsafe;

/**
 * xiaog
 */
public class UnsafeDemo {

    static class Demo {
        String name;
        int age;

        void methodDemo() {
            System.out.println("\"demo\" = " + "demo");
        }
    }

    public static void main(String[] args) {

        Unsafe unsafe = Unsafe.getUnsafe();

        try {
            Demo demo = (Demo) unsafe.allocateInstance(Demo.class);
            demo.age = 18;
            System.out.println("demo = " + demo);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
