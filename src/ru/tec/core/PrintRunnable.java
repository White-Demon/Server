package ru.tec.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Создано 23.06.15
 */
public class PrintRunnable implements Runnable {
    PrintWriter writer;
    BufferedReader reader;
    public PrintRunnable(PrintWriter writer){
        this.writer=writer;
    }
    @Override
    public void run() {
        try {
        while (true){
        reader=new BufferedReader(new InputStreamReader(System.in));
        writer.println(reader.readLine());
        writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
