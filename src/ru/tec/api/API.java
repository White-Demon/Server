package ru.tec.api;
/**
 * 
 * @author White2Demon
 * ��� ��� ������ � �������� ��������/��������� (��� �� ���������)
 * TEMPLATE SINGLETON
 */
public class API {
	
	public static API newInstance()
	{
		return new API();
	}
	
	private API() {
		
	}
	
}
