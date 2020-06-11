package com.atguigu.interview.study.thread;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by H on 2020/3/23.
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("================================");
        myWeakHashMap();

    }

    private static  void myHashMap(){

        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void myWeakHashMap(){

        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        System.gc();
        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}
