package com.atguigu.interview.study.thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{

    volatile int number = 0;
    public  void addTo60(){
        number = 60;
    }

    //请注意，此时number前面是加了volatile关键字修饰的，volatile不保证原子性
    public void addPlusPlus(){
        //number++在多线程下是非线程安全的
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}
/**
 * Created by H on 2020/3/16.
 * 1、验证volatile的可见性
 *      1.1 假如number变量之前没有添加volatile关键字修饰,没有可见性
 *      1.2 添加了volatile，可以解决可见性问题
 *
 * 2、验证volatile不保证原子性
 *      2.1 原子性指的是什么意思？
 *          不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。需要整体完整
 *          要么同时成功，要么同时失败。
 *
 *      2.2 volatile不保证原子性的案例演示
 *
 *      2.3 why
 *      2.4 如何解决原子性?
 *          1) 加 synchronized
 *          2) 使用我们的juc下AtomicInteger
 *
 */
public class VolatileDemo {

    public static void main(String[] args) {
        //seeOkByVolatile();

        MyData myData = new MyData();
        for (int i=0; i<20; i++){
            new Thread(() -> {
                for(int j=0; j<1000; j++){
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值

        while(Thread.activeCount() > 2){

            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t int type,finally number value: "+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type,finally number value: "+myData.atomicInteger);

    }

    //volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
    public static void seeOkByVolatile() {
        MyData myData = new MyData();//资源类

        new Thread( () -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            //暂停一会儿线程
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t int type,finally number value: "+myData.number);

        },"AAA").start();


        //第2个线程是我们的main线程
        while(myData.number == 0){

            //main线程就一直在这里等待循环，直到number值不再等于零

        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over, main get number value:  "+myData.number);
    }
}
