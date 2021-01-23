package com.xiaogang.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * xiaOgang
 */
public class CopyAndWriteDemo {

    public static void main(String[] args) {
        final CopyAndWriteThread thread = new CopyAndWriteThread();
        for (int i = 0; i < 10; i++) {
            new Thread(thread).start();
        }
    }
}

class CopyAndWriteThread implements Runnable {

    //public static List<String> list = Collections.synchronizedList(new ArrayList<>());
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add("DD");
        }
    }
}
