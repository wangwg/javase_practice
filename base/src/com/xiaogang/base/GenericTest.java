package com.xiaogang.base;

import com.xiaogang.base.innerclass.Person;
import com.xiaogang.base.innerclass.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * xiaOgang
 */
public class GenericTest {

    public static void main(String[] args) {
        GenericTest genericTest = new GenericTest();
        List<Person> pList = new ArrayList<>();
        pList.add(new Person());
        List<Student> sList = new ArrayList<>();
        sList.add(new Student());

        genericTest.add(pList);
        genericTest.add1(pList);
        genericTest.add(sList);
        //genericTest.add1(sList);
    }

    public void add(List<? extends Person> list) {
        Student s1 = new Student();
        //list.add(s1);
        list.add(null);
    }

    public void add1(List<? super Person> list) {
        Student s1 = new Student();
        list.add(s1);
        list.notify();
    }
}

class LockDemo {
    private final ReentrantLock lock = new ReentrantLock();

    public void method() {
        lock.lock();
        try {
            // 线程逻辑代码
        } finally {
            lock.unlock();
        }
    }
}