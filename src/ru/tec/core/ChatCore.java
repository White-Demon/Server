package ru.tec.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Создано 23.06.15
 */
public class ChatCore {
    private Socket socket;
    private BufferedReader netReader;
    private PrintWriter netWriter;
    private Thread netThread;
    private Thread printThread;

    public String inputAddress(){
        System.out.println("Введите адрес:");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String address=null;
        try {
            address=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(address.equals("Exit")){
            System.exit(0);
        }
        return address;
    }
    public void connect(){
        String netAddress = "localhost:9090";
        String ip = "localhost";
        int port = 9090;
        if((netAddress=inputAddress()).equals("")){
            System.out.println("Вы ввели пустой адрес!");
            connect();
        }else {
            try {

                ip=netAddress.split(":")[0];
                port=Integer.parseInt(netAddress.split(":")[1]);
                socket=new Socket(ip,port);

                netReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));//Принять сообщение
                netWriter=new PrintWriter(socket.getOutputStream());//Отправить сообщение

                netThread=new Thread(new ReaderRunnable(netReader));
                printThread=new Thread(new PrintRunnable(netWriter));
                netThread.start();
                printThread.start();
                System.out.println("Соединение установлено!");
            }catch (IOException ue){
                System.out.println("Ошибка соединения!");
                connect();

            }catch (Exception e){
                System.out.println("Вы ввели неправильный адрес!");
                connect();

            }

        }
    }
}
