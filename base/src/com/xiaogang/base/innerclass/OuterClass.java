package com.xiaogang.base.innerclass;

/**
 * xiaOgang
 */
public class OuterClass {

    public static final int STATIC_ID = 999;

    private int id;

    private String desc;

    // 成员内部类
    class InnerClass {
        private int id;
        private int innerId;

        public void testInner() {
            System.out.println("hello inner");
            System.out.println("OuterClass.this.id = " + OuterClass.this.id);
            System.out.println("id = " + id);
        }
    }

    // 静态内部类
    static class InnerStatic {
        public void testInner() {
            System.out.println("STATIC_ID = " + STATIC_ID);
        }
    }

    // 匿名内部类
    Person p = new Person() {
        private String desc;

        public void testPerson() {
            super.testPerson();
            setSalary(1000.00);
            System.out.println("getSalary() = " + getSalary());
        }
    };

    public void testOuter() {

    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        outer.setId(100);
        outer.setDesc("Outer desc");

        inner.testInner();

        InnerStatic innerStatic = new InnerStatic();
        innerStatic.testInner();

        outer.p.testPerson();

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
