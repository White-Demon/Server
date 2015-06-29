package ru.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

import ru.server.cmd.Command;
/**
 * 
 * @author White2Demon
 *
 */
public class Server extends ServerSocket{

	private Command cmd; 
	
	private HashMap<String,User> activeUser = new HashMap<>();
	
	/**
	 * Конструктор
	 * @param port - Порт
	 * @throws IOException - Порт закрыт (Или занят)
	 */
	public Server(int port) throws IOException 
	{
		super(port); // Вызов конструктора родителя
	}
	/**
	 * Метод старта сервера
	 */
	public void start()
	{
		User us;
		System.out.println("Запущен");
		System.out.println("Можете ввести команду");
		cmd = new Command(this);
		while(true)
		{
			try {
				us = new User(this.accept());
				us.start();
				activeUser.put(us.getNick(), us);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendMessage(String login,String message)
	{
		
	}
	
}
