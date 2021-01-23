package com.xiaogang.lambda;

import com.xiaogang.reflection.Person;

import java.util.Comparator;


public class LambdaTest {

    public static void main(String[] args) {

        Person p1 = new Person("Wayne", 30);
        Person p2 = new Person("Allen", 30);

        Comparator<Person> comparator = new Comparator<>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        System.out.println(comparator.compare(p2, p1));

        Comparator<Person> comparatorLambda = (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        };

        System.out.println(comparatorLambda.compare(p1, p2));

        Comparator<Person> comparatorLambda1 = (o1, o2) -> o1.getName().compareTo(o2.getName());

        System.out.println(comparatorLambda1.compare(p1, p2));

    }

}
