package com.atguigu.interview.study.thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by H on 2020/3/21.
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{

        //List list = new ArrayList();

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
       /* System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        */

        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        */
/*
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("x");

        System.out.println("==========================");
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
   */

        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("x",2, TimeUnit.SECONDS));



    }
}
