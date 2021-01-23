package com.xiaogang.juc;

import java.util.concurrent.CountDownLatch;

/**
 * xiaOgang
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        //每次有个线程执行完-1，设置初始值5
        final CountDownLatch latch = new CountDownLatch(5);
        ThreadDemo ld = new ThreadDemo(latch);

        long start = System.currentTimeMillis();

        //线程数需要和闭锁的初始化参数一致
        for (int i = 0; i < 5; i++) {
            new Thread(ld).start();
        }

        try {
            //50个线程执行完，才继续执行main线程
            latch.await();
        } catch (InterruptedException e) {
        }

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));
    }
}

class ThreadDemo implements Runnable {

    private CountDownLatch countDownLatch;

    public ThreadDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            //每次执行完-1，放在finally里确保每次都执行
            countDownLatch.countDown();
        }
    }
}
