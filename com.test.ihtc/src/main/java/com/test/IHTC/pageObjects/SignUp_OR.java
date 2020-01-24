package com.test.IHTC.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.test.IHTC.utilities.BaseClass;

public class SignUp_OR extends BaseClass{

	public SignUp_OR(WebDriver driver, ExtentTest test) {
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Upload PDF or Image'])[1]/following::a[1]")
	public WebElement uploadEINCert;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Upload PDF or Image'])[3]/following::a[1]")
	public WebElement uploadCertFormation;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Upload PDF or Image'])[4]/following::a[1]")
	public WebElement uploadBussLicen;

}
