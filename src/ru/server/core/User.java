package ru.server.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ru.server.xml.Message;
import ru.server.xml.XMLGeneric;
import ru.server.xml.XMLParser;
import ru.tec.api.ClientListener;
import ru.tec.api.Packet;
import ru.tec.api.PacketListener;

/**
 * 
 * @author White2Demon
 * @TODO Нужно оптимизировать работу , а так же добавить работу с БД
 */
public class User extends Thread{
	
	private Socket soc;
    private BufferedReader data_in;
    private PrintWriter data_out;
    
    private Server server;
    
    
    private String nick = "";
    private String pass = ""; 
    
    private User us = this;
    /**
     * События отправки и принятия пакетов
     */
    private ClientListener listener = new ClientListener(){
    	
		@Override
		public Packet getPacket() {
			try {
				return new Packet(data_in.readLine());
			} catch (IOException e) {
				return null;
			}
		}

		@Override
		public void sendPacket(Packet packet) {
			data_out.append(packet.toString());
			data_out.flush();
		}

		@Override
		public void logout() {
			
			
		}

		@Override
		public void handlingPacket(int type,String[] args) {
			switch(type)
	    	{
	    		case 10:
	    			String login=args[0],pass=args[1];
	    			if(isAuth(login,pass))
	    			{
	    				// Вернем XML с Token'ом
	    			}else{
	    				// Вернем ошибку авторизации
	    			}
	    			break;
	    		case 12:
	    			// send message to chat
	    			break;
	    		case 14:
	    			// register new user
	    			break;
	    		case 16:
	    			// a test code
	    			sendMessage( new XMLGeneric(17,"Удачная передача данных").toString());
	    			break;
	    			
	    	}
		}

		@Override
		public void enterPacket() {
			if(getSocket().isConnected())
    		{
    			Message msg =XMLParser.getMessageFromXML(this.getPacket().toString());
				getMessage(Integer.parseInt(msg.get("type")),msg); // Парсим тип сообщения и передаем его дальше
    		}
		}
    	
    };
    
    /**
     * Конструктор
     * @param soc - Сокет пользователя
     * @throws IOException - Не существует
     */
    public User(Socket soc,Server server) throws IOException
    {
    	this.setSocket(soc);
    	this.setServer(server);
        setData_in(new BufferedReader(new InputStreamReader(soc.getInputStream())));
        setData_out(new PrintWriter(soc.getOutputStream()));
    }
    
    @Override
    public void run()
    {
    	while(true)
    	{
    		this.listener.enterPacket();
    	}
    }
   /**
    * Загрузка пользователя из БД
    */
    public void loadFromDB()
    {
    	
    }
    
    public void logout()
    {
    	this.listener.logout();
    }
    
    /**
     * Отправляем данному пользователю определенное сообщение
     * @param message - сообщение
     */
    public void sendMessage(String message)
    {
    	this.listener.sendPacket(new Packet(message));
    }
    /**
     * Обрабатываем сообщения
     * @param type - тип сообщения	
     * @param msg - сообщение
     */
    public void getMessage(int type,Message msg)
    {
    	String[] arr = msg.get("message").split(":");
    	this.listener.handlingPacket(type, arr);
    }
    /**
     * 
     * @param login
     * @param pass
     * @return
     */
     public boolean isAuth(String login , String pass)
     {
		return false;
     }
    
    // Геттеры и сеттеры
	public Socket getSocket() 
	{
		return soc;
	}

	public void setSocket(Socket soc)
	{
		this.soc = soc;
	}

	public PrintWriter getData_out() 
	{
		return data_out;
	}

	public void setData_out(PrintWriter data_out)
	{
		this.data_out = data_out;
	}

	public BufferedReader getData_in() 
	{
		return data_in;
	}

	public void setData_in(BufferedReader data_in) 
	{
		this.data_in = data_in;
	}

	public String getNick() {return nick;}

	public void setNick(String nick) {this.nick = nick;}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}
}
