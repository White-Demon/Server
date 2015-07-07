package ru.tec.api;
/**
 * 
 * @author White2Demon
 * ��������� ��� ������� � ��������
 */
public interface ClientListener extends PacketListener{
	/**
	 * ����� ������� � ����
	 */
	public void logout();
	/**
	 * ��������� ���������
	 * @param args - ��������� ������������
	 */
	public void handlingPacket(int type,String[] args);
	/**
	 * �������� �����
	 */
	public void enterPacket();
	
}
