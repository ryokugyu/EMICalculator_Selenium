package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {
	public static Properties readConfiguration() {

		Properties prop = null;

		if (prop == null) {
			prop = new Properties();

			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\resources\\config.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prop;

	}
}
