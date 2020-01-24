package com.test.IHTC.testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

public class SignUp {

	public WebDriver driver;
	
	//@Test
	public void upload() throws InterruptedException {

	
		WebDriver driver = new SafariDriver();
		//Actions builder = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.get("https://hemp-trader-dev.appspot.com/signup");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prabuihtc@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("welcome@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[contains(text(),'Listings')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(.//span[.='Create'])[2]")).click();
		Thread.sleep(8000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		
		WebElement uploadElement = driver.findElement(By.xpath("//input[@name='file']"));
        uploadElement.sendKeys("/Users/tringapps/Downloads/TestPDF.pdf");
        
	}
	
	@Test
	public void login() {
		
		
		
	}
	
	//@AfterClass
	public void quitBrowser() {
		
		driver.quit();
	}
	
}
