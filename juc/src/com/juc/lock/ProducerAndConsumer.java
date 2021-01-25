package com.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * xiaog
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk);
        Consumer c = new Consumer(clerk);

        Thread p1 = new Thread(p, "生产者1");
        Thread p2 = new Thread(p, "生产者2");
        Thread c1 = new Thread(c, "消费者1");

        p1.start();
        p2.start();
        c1.start();
    }
}

class Clerk {

    private int productNum = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (productNum >= 3) {
                System.out.println("商品满了");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "生产商品:" + productNum++);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void sale() throws InterruptedException {
        lock.lock();
        try {
            // 为了避免虚假唤醒，应该总是使用在循环中。
            while (productNum <= 0) {
                System.out.println("该进货了");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "销售商品：" + productNum--);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                //Thread.sleep(1000);
                clerk.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                clerk.sale();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
