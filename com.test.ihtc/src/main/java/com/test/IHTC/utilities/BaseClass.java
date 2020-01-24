package com.test.IHTC.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


public class BaseClass extends ReusableMethods {

	public String testCaseName;
	public String testDescription;
	public String testNodes;
	public String authors;
	public String category;
	
	/*ReadConfig readconfig=new ReadConfig();
	
	//Log4j class
	public static Logger logger;
	
	public String baseURL=readconfig.getUrl();	
	public String switchToURL=readconfig.getSwitchTourl();
	
	*/
	@BeforeSuite()
	public void beforeSuite() {
		startResult();
	}

	@BeforeMethod()
	public void beforeMethod() throws MalformedURLException { 
		test = startTestModule(testCaseName 
				, testDescription);
		test = startTestCase(testNodes);
		test.assignCategory(category);
		test.assignAuthor(authors); 
		//driver.get(baseURL);
	}
	
	@AfterMethod
	public void afterMethod() throws FileNotFoundException, IOException {
		endResult();
	}

	@AfterSuite()
	public void afterSuite() {
		endResult();
		driver.quit();
	}
	
}
