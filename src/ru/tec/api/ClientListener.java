package ru.tec.api;
/**
 * 
 * @author White2Demon
 * Слушатель для событий с клиентом
 */
public interface ClientListener extends PacketListener{
	/**
	 * Выход клиента с сети
	 */
	public void logout();
	/**
	 * Обработка сообщений
	 * @param args - сообщение распарсенное
	 */
	public void handlingPacket(int type,String[] args);
	/**
	 * Приходит пакет
	 */
	public void enterPacket();
	
}
