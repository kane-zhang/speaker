package com.speaker.api.util;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationSettings {
	private static Properties settings = null;

	public static void initialize() {
		ApplicationSettings.settings = new Properties();
		try {
			InputStream in = ApplicationSettings.class.getClassLoader().getResourceAsStream("settings.properties");
			ApplicationSettings.settings.load(in);
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String get(String parameterName) {
		if (ApplicationSettings.settings == null){
			initialize();
		}
		return settings.getProperty(parameterName);
	}

}
