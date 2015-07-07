package ru.tec.api;
/**
 * 
 * @author White2Demon
 * 
 */
public interface PacketListener {
	/**
	 * Получаем пакет который прислали
	 * @return - класс {@link ru.tec.api.Packet}
	 */
	public Packet getPacket();
	/**
	 * Отправляем пакет 
	 * @param packet - что за пакет отправляем
	 */
	public void sendPacket(Packet packet);
	
}
