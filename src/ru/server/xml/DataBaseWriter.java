package ru.server.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * 
 * @author White2Demon
 *
 */
public class DataBaseWriter {
	
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder = null;
	private Document document = null;
	
	public DataBaseWriter() 
	{
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public void addConfig(String port,String RAM , String jarfile)
	{
		Element rootEl = document.createElement("Config");
		document.appendChild(rootEl);
		Element chilEl1 = document.createElement("Port");
		rootEl.appendChild(chilEl1);
		Element chilEl2 = document.createElement("RAM");
		rootEl.appendChild(chilEl2);
		Element chilEl3 = document.createElement("JARFILE");
		rootEl.appendChild(chilEl3);
		
		chilEl2.appendChild(document.createTextNode(RAM));
		chilEl1.appendChild(document.createTextNode(port));
		chilEl3.appendChild(document.createTextNode(jarfile));
	}
	
	public void saveAll(String nameFile) throws TransformerException
	{
		TransformerFactory factoryTr = TransformerFactory.newInstance();
		try {
			Transformer transfo = factoryTr.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult sf = new StreamResult(new File(nameFile + ".xml"));
			transfo.transform(domSource, sf);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
	}

}