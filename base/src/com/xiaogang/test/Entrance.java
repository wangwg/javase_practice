package com.xiaogang.test;

/**
 * xiaOgang
 */

interface Teacher {
    int correct();
}

interface Parent {
    void criticize(int grade);
}

class Student {

    private int grade;
    private Teacher teacher;
    private Parent parent;

    public Student(Teacher teacher, Parent parent) {
        this.teacher = teacher;
        this.parent = parent;
    }

    public void doHomework() {
        grade = teacher.correct();
        parent.criticize(grade);
    }

}

public class Entrance {

    public static void main(String[] args) {
        Student s = new Student(() -> {
            return 98;
        }, grade -> {
            if (grade < 60) {
                System.out.println("bad");
            } else {
                System.out.println("good");
            }
        });

        Student s1 = new Student(() -> {
            return 66;
        }, grade -> {
            if (grade < 80) {
                System.out.println("bad");
            } else {
                System.out.println("good");
            }
        });

        s.doHomework();
        s1.doHomework();
    }
}
