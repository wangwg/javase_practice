package com.juc.volatie;

/**
 * xiaOgang
 */
public class VolatileReference {

    private static volatile VolatileReferenceDemo reference = new VolatileReferenceDemo();

    public static void main(String[] args) {

        Thread thread = new Thread(reference::run);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (reference.getFlag()){
            System.out.println("Get the after run");
        }

    }
}

class VolatileReferenceDemo {

    private boolean flag = false;

    public void run(){
        System.out.println("run");
        flag = true;
    }

    public boolean getFlag(){
        return flag;
    }
}

