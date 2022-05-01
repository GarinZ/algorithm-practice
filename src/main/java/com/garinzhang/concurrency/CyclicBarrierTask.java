package main.java.garinzhang.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTask {

    static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
    static ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            queue.offer(i);
        }

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("Group execute finished"));
        for (int i = 0; i < 5; i ++) {
            threadPool.execute(() -> {
                while (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
