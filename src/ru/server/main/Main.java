package ru.server.main;

import java.io.IOException;

import ru.server.core.Server;

/**
 * 
 * @author White2Demon	
 *
 */
public class Main {
	/**
	 * Главный класс
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Server server = null;
		try {
			server = new Server(9090);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}