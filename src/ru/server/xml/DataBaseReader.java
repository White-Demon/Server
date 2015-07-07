package ru.server.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 * 
 * @author White2Demon
 *
 */
public class DataBaseReader {
	
	private Handler handler = new Handler();
	
	public DataBaseReader(){}
	
	public String parse(String file,String tag) throws ParserConfigurationException, SAXException, IOException
	{
		File f = new File(file + ".xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(f);
        Element root = document.getDocumentElement();
        // äëÿ ïðîñòîòû ñðàçó áåðåì message
        Element message = (Element) root.getElementsByTagName(tag).item(0);
        String textContent = message.getTextContent(); // òîæå äëÿ óïðîùåíèÿ
        return textContent;
	}
	
	public Handler getHandler()
	{
		return handler;
	}
}