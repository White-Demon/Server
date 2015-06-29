package ru.server.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ru.server.xml.Message;
import ru.server.xml.XMLGeneric;
import ru.server.xml.XMLParser;

/**
 * 
 * @author White2Demon
 *
 */
public class User extends Thread{
	
	private Socket soc;
    private BufferedReader data_in;
    private PrintWriter data_out;
    
    private String nick = "";
    private String pass = ""; 
    
    /**
     * Конструктор
     * @param soc - Сокет пользователя
     * @throws IOException - Не существует
     */
    public User(Socket soc) throws IOException
    {
    	this.setSocket(soc);
        setData_in(new BufferedReader(new InputStreamReader(soc.getInputStream())));
        setData_out(new PrintWriter(soc.getOutputStream()));
        
        
    }
    
    @Override
    public void run()
    {
    	while(true)
    	{
    		if(getSocket().isConnected())
    		{
    			try {
    				Message msg =XMLParser.getMessageFromXML(data_in.readLine());
					getMessage(Integer.parseInt(msg.get("type")),msg); // Парсим тип сообщения и передаем его дальше
				} catch (IOException e) {
					// No message
				}
    		}
    	}
    }
    
    public void sendMessage(String message)
    {
    	data_out.append(message);
    	data_out.flush();
    }
    
    public void getMessage(int type,Message msg)
    {
    	String[] arr = msg.get("message").split(":");
    	switch(type)
    	{
    		case 10:
    			String login=arr[0],pass=arr[1];
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
    			
    			data_out.append( new XMLGeneric(17,"Удачная передача данных").toString());
    			data_out.flush();
    			break;
    			
    	}
    }
    
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
	
	public void authorize()
	{
		
	}
}
