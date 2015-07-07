package ru.tec.api;

import ru.server.core.Server;

/**
 * 
 * @author White2Demon
 * Слушатель для серверного класса.
 * ВНИМАНИЕ! Изменения очень осторожны должны быть  иначе пизд*ц...
 */
public interface ServerListener {
	/**
	 * Появление нового пользователя
	 * @param server - Сервер
	 */
	public void newUser(Server server);
	/**
	 * Остановка сервера
	 */
	public void stop();
	/**
	 * Перезапуск сервера
	 */
	public void restart();
	
}
