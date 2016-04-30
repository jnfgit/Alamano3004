package com.utilities;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Properties {
	
	public static String getParameter(String classKey, String valueKey) throws Exception{
		String value = null;
		SAXBuilder builder = new SAXBuilder();

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource("com/properties/db_properties.xml");
		
		try {
			File xmlFile = new File(url.toURI());
			Document document = (Document) builder.build(xmlFile);

			Element rootNode = document.getRootElement();

			List list = rootNode.getChildren(classKey);

			for (int i = 0; i < list.size(); i++) {
				Element elemento = (Element) list.get(i);
				if(elemento != null){
					Element ele = elemento.getChild(valueKey);
					if(ele != null){
						value = ele.getValue();
					}
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
			throw new Exception(io.getMessage());
		} catch (JDOMException jdomex) {
			jdomex.printStackTrace();
			throw new Exception(jdomex.getMessage());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return value;
	}
}
