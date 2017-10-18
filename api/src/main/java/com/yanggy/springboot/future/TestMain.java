package com.yanggy.springboot.future;

import java.util.concurrent.*;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/16 17:03
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task());
        executorService.submit(futureTask);
        Callable<Integer> callable = () -> {
            int sum = 0;
            for(int i = 1; i < 100; i++) {
                sum += i;
            }

            return sum;
        };
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(callable);
        executorService.submit(futureTask1);

        System.out.println("task1:" + futureTask1.get());
        System.out.println(futureTask.get());
    }
}
