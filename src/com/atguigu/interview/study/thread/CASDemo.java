package com.atguigu.interview.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by H on 2020/3/19.
 *  1、CAS是什么(CompareAndSet)
 *      比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        boolean tag = atomicInteger.compareAndSet(5,2020);
        System.out.println(tag+"\t current data: "+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t current data: "+atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
