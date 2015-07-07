package ru.tec.api;
/**
 * 
 * @author White2Demon
 * 
 */
public interface PacketListener {
	/**
	 * �������� ����� ������� ��������
	 * @return - ����� {@link ru.tec.api.Packet}
	 */
	public Packet getPacket();
	/**
	 * ���������� ����� 
	 * @param packet - ��� �� ����� ����������
	 */
	public void sendPacket(Packet packet);
	
}
