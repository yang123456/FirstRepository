package com.atguigu.interview.study.thread;

/**
 * Created by H on 2020/3/22.
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {

        /*
             long totalMemory = Runtime.getRuntime().totalMemory();
       long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY(-Xms)" + totalMemory + "(字节)、" + (totalMemory / (double)1024 / 1024) +"MB");
        System.out.println("MAX_MEMORY(-Xms)" + maxMemory + "(字节)、" + (maxMemory / (double)1024 / 1024) +"MB");
         */
        System.out.println("*************HelloGC****************");
        //byte[] byteArray = new byte[50 * 1024 * 1024];
        Thread.sleep(Integer.MAX_VALUE);
    }
}
