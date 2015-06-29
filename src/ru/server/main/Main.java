package ru.server.main;

import java.io.IOException;

import ru.server.core.Server;
import ru.server.xml.XMLGeneric;

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
		System.out.println(new XMLGeneric(200,"login:pass"));
		try {
			server = new Server(9090);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}