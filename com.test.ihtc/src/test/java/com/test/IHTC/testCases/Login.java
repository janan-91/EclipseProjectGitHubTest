package com.test.IHTC.testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.IHTC.pageObjects.Login_OR;
import com.test.IHTC.utilities.BaseClass;

public class Login extends BaseClass{

	@BeforeTest()
	public void setValues() {

		testCaseName = "IHTC Login";
		testDescription = "Login Successful";
		testNodes = "WEB";
		category = "Regression";
		authors = "Janani";	
	}
	
	@Test
	public void Login001() {
		
		Login_OR log = new Login_OR(driver, test);
		
		driver.get(loginUrl);
		
		log.maximizeBrowser();
		log.username("prabuihtc@gmail.com");
		log.password("welcome@123");
		log.clickLogin();
	}
	
}
