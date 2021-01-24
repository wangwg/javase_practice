package com.juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * xiaOgang
 */
public class AtomicIntegerDemo {

    private AtomicInteger count = new AtomicInteger(0);
    private CountDownLatch latch;

    public AtomicIntegerDemo() {
    }

    public AtomicIntegerDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                count.incrementAndGet();
            }
        } finally {
            latch.countDown();
        }

    }

    public static void main(String[] args) {

        final List<Thread> list = new ArrayList<>();
        final CountDownLatch latch = new CountDownLatch(10);
        final AtomicIntegerDemo demo = new AtomicIntegerDemo(latch);

        for (int i = 0; i < 10; i++) {
            list.add(new Thread(demo::run));
        }

        list.forEach(o -> o.start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count.get() = " + demo.count.get());

    }
}
