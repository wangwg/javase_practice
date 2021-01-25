package com.juc.lock;

/**
 * xiaog
 */
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                // 配合线程中断的判断代码
                if (Thread.currentThread().isInterrupted())
                    break;
                System.out.println("i = " + i);
            }
        });

        myThread.start();
        Thread.sleep(10);
        // 给线程该线程一个标志位，让该线程自己决定该怎么办
        // 单纯用 interrupt() 中断线程方法并不能停止当前正在运行的线程
        // 需要配合其他方法才能正确停止线程。
        myThread.interrupt();

        // 等待 myThread运行停止
        myThread.join();

        System.out.println("end");

    }
}
