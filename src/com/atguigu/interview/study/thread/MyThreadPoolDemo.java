package com.atguigu.interview.study.thread;

import java.util.concurrent.*;

/**
 * Created by H on 2020/3/21.
 *  第4种获得/使用java多线程的方式，线程池
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //threadPoolInit();
        Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory() ,
                new ThreadPoolExecutor.DiscardPolicy());//new ThreadPoolExecutor.DiscardOldestPolicy());//new ThreadPoolExecutor.CallerRunsPolicy());//new ThreadPoolExecutor.AbortPolicy()

        try {
            //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for(int i = 0; i < 10; i++){
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    public static void threadPoolInit() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程
        //ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程


        try {
            //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for(int i = 0; i < 100; i++){
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
