package ru.tec.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ru.server.xml.*;
import ru.tec.api.Packet;
import ru.tec.api.PacketListener;

/**
 * 
 * @author White2Demon
 *
 */
public class Confige {
	
	public static int PORT; // Порт сервера
	public static int RAM; // Память для сервера
	public static String JAR_FILE; // Имя jar file сервера
	/**
	 * Получаем Конфиг файл
	 */
	public static void getConfige()
	{
		DataBaseReader dbr = new DataBaseReader();
		File file = new File("confige.xml");
		if(file.isFile())
		{
			try {
				PORT = Integer.parseInt(dbr.parse("confige.xml", "Port"));
				RAM = Integer.parseInt(dbr.parse("confige.xml", "RAM"));
				JAR_FILE = dbr.parse("confige.xml", "JARFILE");
			} catch (NumberFormatException | ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
		}else{
			createConfig();
		}
	}
	/**
	 * Создаем новый файл конфигурации
	 */
	public static void createConfig()
	{
		DataBaseWriter dbw = new DataBaseWriter();
		dbw.addConfig(9090+"", 256+"","Server.jar");
		try {
			dbw.saveAll("confige");
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
