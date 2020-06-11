package com.atguigu.interview.study.thread;

import java.lang.ref.WeakReference;

/**
 * Created by H on 2020/3/23.
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<Object>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("============================");
        System.out.println(o1);
        System.out.println(weakReference.get());

    }
}
