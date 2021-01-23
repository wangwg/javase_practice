package com.xiaogang.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * xiaOgang
 */
public class CallableDemo {
    public static void main(String[] args) {
        ThreadCallableDemo td = new ThreadCallableDemo();

        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> result = new FutureTask<>(td);
        new Thread(result).start();

        //2.接收线程运算后的结果
        try {
            //取得返回值结果会等待线程执行结束
            //所以FutureTask 可用于闭锁
            Integer sum = result.get();
            System.out.println(sum);
            System.out.println("------------------------------------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThreadCallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            sum += i;
        }
        return sum;
    }
}
