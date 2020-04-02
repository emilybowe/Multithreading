package com.Multithreading;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    // opening, reading, writing to files reply on IO, rather than CPU
    // the thread is therefore not taking advantage of CPU resources
    // a case for multithreading

    // Threading Foundation: Runnable interface & Thread class - Direct management more labour intensive

    // Thread pools - take some of that work managing threads from us:
    // can use ExecutorService interface or Executors class

    // 1) implement thread pool, any tasks will remain in a queue if threads already in use
    // 2) submit instances of our adder class into the thread pool, thread pool will assign work
    // 3) main thread will block, waiting for the work to get done
    
    public static void main(String[] args) throws InterruptedException {

        String[] inFiles = {"./file1.txt", "./file2.txt", "./file3.txt", "./file4.txt", "./file5.txt", "./file6.txt"};
        String[] outFiles = {"./file1.out.txt", "./file2.out.txt", "./file3.out.txt", "./file4.out.txt", "./file5.out.txt", "./file6.out.txt"};

        ExecutorService es = Executors.newFixedThreadPool(3); //1)


        for(int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            es.submit(adder); //2)
        }

        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS); //3
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
