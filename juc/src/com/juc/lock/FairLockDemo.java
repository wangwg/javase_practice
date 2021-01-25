package com.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * xiaog
 */
public class FairLockDemo {

    // 公平锁
    private Lock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final FairLockDemo demo = new FairLockDemo();
        new Thread(demo::run, "Thread-1").start();
        new Thread(demo::run, "Thread-2").start();
        new Thread(demo::run, "Thread-3").start();
        new Thread(demo::run, "Thread-4").start();
        new Thread(demo::run, "Thread-5").start();
    }
}
