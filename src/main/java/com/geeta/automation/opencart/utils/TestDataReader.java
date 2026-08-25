package com.geeta.automation.opencart.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

	private static Properties properties = new Properties();
	
	
	static {
		
		try {
			
			FileInputStream file = new FileInputStream("src/test/resources/testdata.properties");
			properties.load(file);
			file.close();
		} catch (IOException e) { 
			
			throw new RuntimeException("Unable to load test data properties file", e);
		}
		
		
	}
	
	public static String getTestData(String key) {
		
		return properties.getProperty(key);
	}
}
