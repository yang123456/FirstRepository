package com.atguigu.interview.study.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by H on 2020/3/21.
 *  并发 异步
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());

        new Thread(futureTask,"AAA").start();
        new Thread(futureTask,"BBB").start();
        System.out.println(Thread.currentThread().getName() + "*********************************come in Callable");
        int result01 = 100;
        int result02 = futureTask.get();//建议放在最后，要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，值得计算完成
        System.out.println("************result:"+ result02);

    }
}


class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "*********************************come in Callable");
        /*Random ran =new Random();
        return ran.nextInt();*/
        return 1024;
    }
}