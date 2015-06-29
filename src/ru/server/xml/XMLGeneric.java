package ru.server.xml;

import java.util.Calendar;

/**
 * 
 * @author White2Demon
 * 
 */
public class XMLGeneric {
	
	private int type;
	private String message;
	private Calendar c = Calendar.getInstance(); 
	
	public XMLGeneric(int type,String message)
	{
		this.type = type;
		this.message = message;
	}
	/**
	 * Делаем ручками XML
	 */
	@Override
	public String toString()
	{
		return "<Server> <type>"+type+"</type><message>"+message+"</message><time>"+(c.get(Calendar.HOUR) + 1 ) + ":" + c.get(Calendar.MINUTE)+"</time></Server>";
	}
	
}
