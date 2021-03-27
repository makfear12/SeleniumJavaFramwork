package org.automation.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {

	public static Object fetchPropertyValue(String key) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream File = new FileInputStream("./Config/Config.properties");
		Properties property = new Properties();
		property.load(File);
		return property.get(key);
	}
	

		public static String fetchLocatorValue(String key) throws IOException {
			// TODO Auto-generated method stub
			FileInputStream File = new FileInputStream("./Config/Element.properties");
			Properties property = new Properties();
			property.load(File);
			return property.get(key).toString();
		}
}
