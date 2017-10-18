package com.yanggy.springboot.thread;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/17 11:08
 * @Description:
 */
public class TestThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":1");
            System.out.println(Thread.currentThread().getName() + ":2");
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":1");
            System.out.println(Thread.currentThread().getName() + ":2");
        });

        t1.start();
        t2.start();



        System.out.println(Thread.currentThread().getName());
    }
}
