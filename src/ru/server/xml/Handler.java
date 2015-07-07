package ru.server.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 
 * @author White2Demon
 *
 */
public class Handler extends DefaultHandler{
	
	private List<String> getAnswer = new ArrayList<String>();
	
	@Override
	public void startDocument() 
			throws SAXException
	{
		System.out.println("START parsing");
	}
	
	@Override
	public void endDocument()
		throws SAXException
	{
		System.out.println("END parsing");
	}
	
	@Override
	public void startElement(String namespace,String localName,String qName,Attributes attr)
	{
		
	}
	
	@Override
	public void endElement(String namespace,String localName,String qName)
	{
		
	}
	
	@Override
	public void characters(char[] ch,int start,int end)
	{
		String str = new String(ch,start,end);
		getAnswer.add(str);
	}
	
	public List<String> getAnswer()
	{
		return getAnswer;
	}
}