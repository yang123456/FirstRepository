package com.atguigu.interview.study.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by H on 2020/3/20.
 */
public class SemaphoreDemo {



    public static void main(String[] args) {
        Semaphore semaphoreDemo = new Semaphore(3);//模拟3个停车位
        for(int i = 0; i < 6; i++){//模拟6步汽车
            new Thread(() -> {
                try {
                    semaphoreDemo.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t停车3秒离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphoreDemo.release();
                }

            },String.valueOf(i)).start();

        }
    }



}
