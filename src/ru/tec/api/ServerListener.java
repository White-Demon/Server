package ru.tec.api;

import ru.server.core.Server;

/**
 * 
 * @author White2Demon
 * ��������� ��� ���������� ������.
 * ��������! ��������� ����� ��������� ������ ����  ����� ����*�...
 */
public interface ServerListener {
	/**
	 * ��������� ������ ������������
	 * @param server - ������
	 */
	public void newUser(Server server);
	/**
	 * ��������� �������
	 */
	public void stop();
	/**
	 * ���������� �������
	 */
	public void restart();
	
}
