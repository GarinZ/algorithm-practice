package main.java.garinzhang.concurrency;

public class ThreadCreate implements Runnable {
    @Override
    public void run() {
        System.out.println("yes");
    }


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("yes");
            }
        };
        for (int i = 0; i < 10; i ++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}