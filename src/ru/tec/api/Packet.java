package ru.tec.api;
/**
 * 
 * @author White2Demon
 * Вспомогательный класс АПИ
 */
public class Packet {
	
	private String xml;
	
	public Packet(String xml)
	{
		this.xml = xml;
	}
	
	@Override
	public String toString()
	{
		return xml;
	}
}
