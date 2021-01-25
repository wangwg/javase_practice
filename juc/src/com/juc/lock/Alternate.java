package com.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程循环输出ABC
 */
public class Alternate {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private int threadIndex = 1;

    public void printA() {
        try {
            lock.lock();

            if (threadIndex != 1) {
                conditionA.await();
            }

            System.out.print("A");
            threadIndex = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        try {
            lock.lock();

            if (threadIndex != 2) {
                conditionB.await();
            }

            System.out.print("B");
            threadIndex = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        try {
            lock.lock();

            if (threadIndex != 3) {
                conditionC.await();
            }

            System.out.print("C");
            threadIndex = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final Alternate alternate = new Alternate();
        Thread a = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                alternate.printA();
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                alternate.printB();
            }
        });
        Thread c = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                alternate.printC();
            }
        });
        a.start();
        b.start();
        c.start();
    }
}


