package com.juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 关于syn,AtomicInteger,LongAdder执行效率的对比
 * LongAdder采用了分段式锁，效率更高一些。
 */
public class LongAdderDemo {

    private static long count1 = 0L;
    private static final AtomicInteger count2 = new AtomicInteger(0);
    private static final LongAdder count3 = new LongAdder();

    public static void main(String[] args) {

        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    synchronized (LongAdderDemo.class) {
                        count1++;
                    }
                }
            }));
        }

        long start = System.currentTimeMillis();
        list.forEach(Thread::start);
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));

        // AtomicInteger
        list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    count2.incrementAndGet();
                }
            }));
        }

        start = System.currentTimeMillis();
        list.forEach(Thread::start);
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));

        // LongAdder
        list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    count3.increment();
                }
            }));
        }

        start = System.currentTimeMillis();
        list.forEach(Thread::start);
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));

    }
}
