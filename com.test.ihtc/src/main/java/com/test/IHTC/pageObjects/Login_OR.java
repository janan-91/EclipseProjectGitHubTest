package com.test.IHTC.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.test.IHTC.utilities.BaseClass;

public class Login_OR extends BaseClass{

	public Login_OR(WebDriver driver, ExtentTest test) {
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement userName;
	
	public void username(String username) {
		setValue(userName, username);
	}
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	public void password(String password) {
		setValue(Password, password);
	}
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement login;
	
	public void clickLogin() {
		click(login);
	}
	
}
