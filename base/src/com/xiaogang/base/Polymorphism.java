package com.xiaogang.base;

/**
 * xiaOgang
 */
public class Polymorphism {
    public static void main(String[] args) {
        Computer myComputer = new Computer();
        Phone myPhone = new Phone();
        Earphone myEarphone = new Earphone();
        myComputer.connect(myPhone);
        System.out.println("======================");
        myComputer.connect(myEarphone);
    }
}

class Computer {
    public void connect(USB usb) {
        usb.charge();

        if (usb instanceof Phone) {
            ((Phone) usb).transfer();
        }
    }
}

interface USB {
    default void charge() {
        System.out.println("Charging...");
    }
}

class Phone implements USB {

    public void transfer() {
        System.out.println("Coping file...");
    }
}

class Earphone implements USB {

}
