package main.java.garinzhang.concurrency;

public class Singleton {
    private static volatile Singleton instance;
    
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            
        }
        return instance;
    }
}
