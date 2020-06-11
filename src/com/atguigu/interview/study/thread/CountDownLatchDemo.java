package com.atguigu.interview.study.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by H on 2020/3/20.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t国，被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_ContryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t*************** 一统华夏");
    }

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教师");
                countDownLatch.countDown();
            },CountryEnum.forEach_ContryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t*************** 班长最后关门");
    }
}
