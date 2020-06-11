package com.atguigu.interview.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by H on 2020/3/20.
 *  题目：实现一个自旋锁
 *  自旋的好处：循环比较获取直到成功为止，没有类似于wait的阻塞
 *
 *  通过CAS操作完成自旋锁，A线程先进来调用mylock方法自己持有5秒钟，B随后进来后发现，当前有线程持有锁，不是null，所以只能通过自旋等待，直到A释放锁后B随后抢到
 */
public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnlock();
        },"BB").start();

    }

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"\t come in ");

        while (!atomicReference.compareAndSet(null,thread));
    }

    public void  myUnlock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(thread,null));
        System.out.println(thread.getName()+"\t invoked  myUnlock() ");
    }
}
