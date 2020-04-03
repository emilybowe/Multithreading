package com.Multithreading.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    // can see how non-atomic operations - getBalance() and deposit() - with multiple steps, not happening all at once,
    // changes are happening from other threads before the thread can finish it's operation
    // i.e. read in from memory, perform work, write back to memory

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);

        for(int i = 0; i < 10; i++) {
            Worker worker = new Worker(account);
            executorService.submit(worker);
        }

        try {
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS); //3
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
