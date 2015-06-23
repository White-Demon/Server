package ru.server.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ru.server.core.Server;
/**
 * 
 * @author White2Demon
 * Не до конца реализовано
 * TODO: Реализовать до конца. Нужно добавить исполнение команды
 */
public class Command   {
	
	public Command(Server s)
	{ 
		
	}
	/**
	 * Читаем комманду и возращаем
	 * @return
	 */
	public String readCommand()
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String command = null;
		try {
			if(reader.readLine() != null || reader.readLine().equals(""))
			{
				return command;
			}else{
				command = reader.readLine();
				return command;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return command;
	}
	
	public void run()
	{
		if(readCommand() != null )
		{
			String[] command = readCommand().split(" ");
			// command[0] - комманда , а все остальное аргументы
			switch(command[0])
			{
				case "message":
				{
					
				}
			}
		}
	}
	
}
