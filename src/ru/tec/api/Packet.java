package ru.tec.api;
/**
 * 
 * @author White2Demon
 * ��������������� ����� ���
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
