package org.javaturk.oopj.ch17.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static String propertiesFile = "/Users/akin/Development/Java/Idea/Java SE WS/Object-Oriented Programming with Java/src/org/javaturk/oopj/ch17/properties/resources/captions.properties";

	static Properties properties;
	private static Properties systemProperties;

	static {
		// First get System properties and resource file.
		systemProperties = System.getProperties();
//		propertiesFile = systemProperties.getProperty("propertiesFile");

		properties = new Properties();
		FileReader in = null;
		try {
			in = new FileReader(propertiesFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
