package ru.tec.api;
/**
 * 
 * @author White2Demon
 * АПИ для работы с сервером отдельно/отдаленно (Так же внутренне)
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
