package com.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用reentrantlock可以进行“尝试锁定”tryLock.
 * 无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 */
public class TryLock {

    private Lock lock = new ReentrantLock();

    public void m1() {
        try {
            lock.lock();

            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m2() {
        boolean locked = false;
        try {
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            // lock.lockInterruptibly();
            System.out.println("locked = " + locked);
        } catch (InterruptedException e) {
            System.out.println("中断了" + e);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TryLock trylock = new TryLock();

        Thread thread1 = new Thread(trylock::m1);
        Thread thread2 = new Thread(trylock::m2);

        thread1.start();
        thread2.start();

//        thread2.interrupt();
//        thread2.join();

        System.out.println("end");
    }
}
