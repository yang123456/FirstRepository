package com.atguigu.interview.study.thread;

/**
 * Created by H on 2020/3/23.
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {

        Object obj1 = new Object();//这样定义的默认就是强引用
        Object obj2 = obj1;//obj2引用赋值
        obj1 = null;//置空
        System.gc();
        System.out.println(obj2);
    }
}
