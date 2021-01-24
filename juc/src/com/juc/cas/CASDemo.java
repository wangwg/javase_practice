package com.juc.cas;

/**
 * xiaOgang
 */
public class CASDemo {

    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int exceptedValue = cas.get();
                    boolean success = cas.compareAndSet(exceptedValue, (int) Math.random() * 101);
                    System.out.println("success = " + success);
                }
            }).start();

        }
    }

}

class CompareAndSwap {

    private int value;

    public synchronized int get() {
        return this.value;
    }

    public synchronized boolean compareAndSet(int exceptedValue, int newValue) {
        return exceptedValue == compareAndSwap(exceptedValue, newValue);
    }

    private synchronized int compareAndSwap(int exceptedValue, int newValue) {
        int oldValue = value;
        if (exceptedValue == oldValue) {
            this.value = newValue;
        }

        return oldValue;
    }
}
