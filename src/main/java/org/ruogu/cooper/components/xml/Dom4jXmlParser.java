package org.ruogu.cooper.components.xml;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Dom4jXmlParser
 *
 * @author xueyintao 2015年3月15日 上午12:08:09
 */
public class Dom4jXmlParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		parseServer();
	}
	
	@SuppressWarnings("unchecked")
	public static void parseServer() {
		String filePath = Dom4jXmlParser.class.getClassLoader().getResource("").getPath();
		System.out.println(filePath);
		Document document = load(filePath + "/server.xml");
		Element classElement = document.getRootElement();
		String name = classElement.getName();
		System.out.println("name:" + name);
		List<Element> servers = classElement.elements();
		for (Element server : servers) {
			String serverName = server.attribute("name").getStringValue();
			System.out.println(serverName);
			
			List<Element> cores = server.elements();
			for (Element core : cores) {
				String coreName = core.attributeValue("name");
				String config = core.attributeValue("config");
				String online = core.attributeValue("online");
				System.out.println(coreName + " " + config + " " + online);
			}
		}
		
	}

	public static Document load(String filename) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(new File(filename)); // 读取XML文件,获得document对象
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}

	public static Document load(URL url) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(url); // 读取XML文件,获得document对象
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}
}
