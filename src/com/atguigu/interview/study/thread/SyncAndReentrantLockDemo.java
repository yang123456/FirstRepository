package com.atguigu.interview.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by H on 2020/3/21.
 */
public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                shareResource.print5();
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                shareResource.print10();
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                shareResource.print15();
            }
        },"C").start();
    }
}

class ShareResource{
    private int number = 1;//A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void  print5(){
        lock.lock();
        try {
            //1 判断
            while (number != 1){
                c1.await();
            }
            //2 干活
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3 通知
            number = 2;
            c2.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void  print10(){
        lock.lock();
        try {
            //1 判断
            while (number != 2){
                c2.await();
            }
            //2 干活
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3 通知
            number = 3;
            c3.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void  print15(){
        lock.lock();
        try {
            //1 判断
            while (number != 3){
                c3.await();
            }
            //2 干活
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3 通知
            number = 1;
            c1.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

}
