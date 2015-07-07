package ru.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

import ru.tec.api.ServerListener;
/**
 * 
 * @author White2Demon
 * Ядро сервера
 */
public class Server extends ServerSocket{
	
	private HashMap<String,User> activeUser = new HashMap<>();
	
	private ServerListener listener = new ServerListener()
	{
		@Override
		public void newUser(Server server) {
			User us;
			System.out.println("Ждем нового пользователя");
			try {
				us = new User(server.accept(),server);
				us.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Данные методы пока что не нужны ...
		@Override
		public void stop() {
			
		}

		@Override
		public void restart() {
			
		}
		
	};
	
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
		System.out.println("Сервер запущен");
		while(true)
		{
			this.listener.newUser(this);
		}
	}
	/**
	 * Отправляем определенному пользователю сообщение 
	 * @param login - логин 
	 * @param message - сообщение
	 */
	public void sendMessage(String login,String message)
	{
		activeUser.get(login).sendMessage(message); 
	}
	
	public HashMap<String,User> getUsers()
	{
		return activeUser;
	}
	
	public void setServerListener(ServerListener sl)
	{
		this.listener = sl;
	}
}
