package com.jvm.jmm;

/**
 * 证明CPU乱序执行
 */
public class Disorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(new Runnable() {
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            one.start();
            other.start();

            one.join();
            other.join();

            if (x == 0 && y == 0) {
                String result = "第" + i + "次 (" + x + "," + y + "）";
                System.err.println(result);
                break;
            }
        }
    }

}
