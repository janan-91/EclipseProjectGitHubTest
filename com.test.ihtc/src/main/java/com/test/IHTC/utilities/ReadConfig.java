package com.test.IHTC.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e);
		}	
	}
	
	public String BaseUrl() {
		
		String url = prop.getProperty("baseURL");
		return url;
	}
	
public String SignpUrl() {
		
		String url = prop.getProperty("SignupURL");
		return url; 
	}
	
	public String getUserName() {
		String userName = prop.getProperty("userName");
		return userName;
	}
	
	public String getChromePath() {
		String chromePath = prop.getProperty("ChromePath");
		return chromePath;	
	}
	
	public String getSwitchTourl() {
		String switchtoURL=prop.getProperty("switchTourl");
		return switchtoURL;
	}
}
