package com.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * xiaOgang
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        Thread thread1 = new Thread(ticket, "窗口-1");
        Thread thread2 = new Thread(ticket, "窗口-2");
        Thread thread3 = new Thread(ticket, "窗口-3");
        Thread thread4 = new Thread(ticket, "窗口-4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class Ticket implements Runnable {

    private int ticketNumber = 3;
    private int safeNumber = 100;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        saleTicket();
    }

    private void saleTicket() {
        while (true) {
            try {
                Thread.sleep(100);
                lock.lock();
                if (ticketNumber > 0) {
                    ticketNumber--;
                    System.out.println(Thread.currentThread().getName() +
                            " sales a ticket. The rest of the tickets is " + ticketNumber);
                    saleSafe();
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // ReentrantLock必须手动释放锁，即使发生异常也不会释放。
                lock.unlock();
            }
        }
    }

    private void saleSafe() {
        try {
            lock.lock();
            if (safeNumber > 0) {
                safeNumber--;
                System.out.println(Thread.currentThread().getName() +
                        " sales a safe. The rest of the sales is " + safeNumber);
            }
        } finally {
            lock.unlock();
        }
    }
}
