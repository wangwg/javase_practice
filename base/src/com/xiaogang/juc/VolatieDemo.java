package com.xiaogang.juc;

/**
 * xiaOgang
 */
public class VolatieDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread).start();

        while (true) {
            // 同步锁可以解决问题，但是效率非常低
            //synchronized (myThread) {
            if (myThread.isFlag()) {
                System.out.println("------------");
                break;
            }
            //}
        }
    }

}

class MyThread implements Runnable {

    // volatile可以保证多个线程操作的时候内存的可见性
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.flag = true;
        System.out.println("this.flag = " + this.flag);
    }

    public boolean isFlag() {
        return flag;
    }
}
