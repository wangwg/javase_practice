package com.xiaogang.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * xiaOgang
 */
public class AtomicDemo {

    public static void main(String[] args) {
        MyAtomicThread myAtomicThread = new MyAtomicThread();

        for (int i = 0; i < 10; i++) {
            new Thread(myAtomicThread).start();
        }
    }
}

class MyAtomicThread implements Runnable {

    //private volatile int number = 0;
    private AtomicInteger number = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println("number = " + number.incrementAndGet());
    }
}
