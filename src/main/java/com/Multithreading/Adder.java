package com.Multithreading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
//with the addition of Callable and call(), Adder can be run on a background thread, but return any results including exceptions

public class Adder implements Callable<Integer> {
    private String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public int doAdd() throws IOException {
        int total = 0;
        String line = null;

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while((line = reader.readLine()) != null)
                total += Integer.parseInt(line);
        }
        return total;
    }

    public Integer call() throws IOException {
            return doAdd();
        }
    }



