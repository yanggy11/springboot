package com.yanggy.springboot.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/17 11:08
 * @Description:
 */
public class TestThread {
    public static void main(String[] args) {

        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            return  sum(1,2);
        });
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

        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        t3.start();

        System.out.println(Thread.currentThread().getName());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static int sum(int a, int b) {
        return  a + b;
    }
}
