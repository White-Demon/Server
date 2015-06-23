package ru.server.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author White2Demon
 *
 */
public class User extends Thread{
	
	private Socket soc;
    private BufferedReader data_in;
    private PrintWriter data_out;
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
    		if(soc.isConnected())
    		{
    			try {
					System.out.println("Message For User:" + data_in.readLine());
					data_out.append("YES MESSAGE");
					data_out.flush();
				} catch (IOException e) {
					// No message
				}
    		}
    	}
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
	
}
