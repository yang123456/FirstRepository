package com.atguigu.interview.study.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by H on 2020/3/19.
 */
class user{
    String userName;
    int age;

    public user(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        user z3 = new user("z3",16);
        user l4 = new user("lisi",22);

        AtomicReference<user> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3,l4)+"\t "+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3,l4)+"\t "+atomicReference.get().toString());

    }
}
