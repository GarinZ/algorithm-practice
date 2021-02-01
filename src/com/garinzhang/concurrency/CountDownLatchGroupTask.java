package com.garinzhang.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchGroupTask {

    static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

    public static final BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(100);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            taskQueue.offer(i);
        }
        for (int i = 0; i < 20; i++) {
            final CountDownLatch countDownLatch = new CountDownLatch(5);
            for (int j = 0; j < 5; j++) {
                fixedThreadPool.execute(() -> {
                    int index = taskQueue.poll();
                    System.out.println(index);
                    countDownLatch.countDown();
                });
            }
            try {
                countDownLatch.await(1L, TimeUnit.SECONDS);
                System.out.println("Group execute finished " + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fixedThreadPool.shutdown();
        System.out.println("Finished");
    }
}
