package ru.tec.core;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Создано 23.06.15
 */
public class ReaderRunnable implements Runnable {
    BufferedReader reader;

    public ReaderRunnable(BufferedReader reader){
        this.reader=reader;
    }
    @Override
    public void run() {
        String message;
        try {
            while ((message=reader.readLine())!=null){
                System.out.println(message+"\n");

            }
        } catch (IOException e) {
           System.out.println("Соединение разорвано!");
        }
    }
}
