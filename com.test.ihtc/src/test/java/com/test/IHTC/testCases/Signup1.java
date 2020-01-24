package com.test.IHTC.testCases;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.IHTC.pageObjects.SignUp_OR;
import com.test.IHTC.utilities.BaseClass;

public class Signup1 extends BaseClass {

	@BeforeTest()
	public void setValues() {

		testCaseName = "IHTC SignUP";
		testDescription = "Signup Successful";
		testNodes = "WEB";
		category = "Regression";
		authors = "Janani";
	}

	// @Test
	public void Signup001() throws InterruptedException, FindFailed {

		SignUp_OR sign = new SignUp_OR(driver, test);

		sign.maximizeBrowser();

		String filepath = System.getProperty("user.dir") + "/TestInputData/";
		String inputFilePath = System.getProperty("user.dir") + "/TestInputData/";
		Screen s = new Screen();

		driver.get("http://hemp-trader-dev.appspot.com/signup");
		// driver.get(signupUrl);
		sign.scrollToElement(sign.uploadEINCert);

		sign.clickUsingJavaScript(sign.uploadEINCert);

		// sign.click(sign.uploadEINCert);
		System.out.println("Browse clicked");

		Pattern fileInputTextBox = new Pattern(filepath + "Search.PNG");
		Pattern openButton = new Pattern(filepath + "Open.PNG");
		Pattern cancelButton = new Pattern(filepath + "Cancel.PNG");
		Pattern Downloads = new Pattern(filepath + "Downloads.PNG");
		Pattern pdfFileSelect = new Pattern(filepath + "TestPDF.PNG");

		s.wait(fileInputTextBox, 20);
		s.click(Downloads);
		System.out.println("Downloads clicked");

		s.type(fileInputTextBox, "TestPDF.pdf");
		System.out.println("Typing in Search ");

		s.click(pdfFileSelect);
		System.out.println("TestPdf is selected");

		s.click(openButton);
		System.out.println("Open clicked");
		// s.click(cancelButton);
		// System.out.println("Cancel clicked");

		/*
		 * JavascriptExecutor executor= (JavascriptExecutor)driver;
		 * 
		 * executor.executeScript(
		 * "document.getElementById('5de8fab5eead6d198acbb414').style.visibility='visible';"
		 * ); Select select = new Select(driver.findElement(By.id("ID")));
		 * select.selectByVisibleText("value"); Thread.sleep(6000);
		 * 
		 * System.out.println("Element clicked----->");
		 * 
		 * /*
		 * 
		 * sign.scrollToElement(sign.uploadBussLicen);
		 * //sign.uploadCertFormation.click(); sign.uploadBussLicen.sendKeys(
		 * "/Users/tringapps/Downloads/workspace/com.Test.IHTC/TestInputData/TestPDF.pdf"
		 * );
		 * 
		 * /*WebElement elem = sign.uploadEINCert; String js =
		 * "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		 * 
		 * ((JavascriptExecutor) driver).executeScript(js, elem);
		 * 
		 */

		// driver.findElement(By.xpath("(.//*[normalize-space(text()) and
		// normalize-space(.)='Upload PDF or Image'])[1]/following::a[1]")).click();
		// System.out.println("CLICKED");

		// driver.findElement(By.xpath("(.//*[normalize-space(text()) and
		// normalize-space(.)='Upload PDF or
		// Image'])[1]/following::a[1]")).sendKeys("/Users/tringapps/Downloads/workspace/com.Test.IHTC/TestInputData/TestPDF.pdf");;

		/*
		 * WebElement elem = sign.uploadBussLicen; String js =
		 * "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		 * 
		 * ((JavascriptExecutor) driver).executeScript(js, elem);
		 */

	}

	@Test
	public void testSikuli() throws FindFailed, InterruptedException {

		SignUp_OR sign = new SignUp_OR(driver, test);
		sign.maximizeBrowser();

		String filepath = System.getProperty("user.dir") + "/TestInputData/";
		String inputFilePath = System.getProperty("user.dir") + "/TestInputData/";
		Screen s = new Screen();

		Pattern fileInputTextBox = new Pattern(filepath + "Search.PNG");
		Pattern openButton = new Pattern(filepath + "Open.PNG");
		Pattern cancelButton = new Pattern(filepath + "Cancel.PNG");
		Pattern Downloads = new Pattern(filepath + "Downloads.PNG");
		Pattern pdfFileSelect = new Pattern(filepath + "TestPDF.PNG");

		driver.get("http://hemp-trader-dev.appspot.com/signup");
		sign.scrollToElement(sign.uploadEINCert);
		Thread.sleep(5000);
		sign.click(sign.uploadEINCert);
		Thread.sleep(5000);

		s.wait(fileInputTextBox, 20);
		s.click(Downloads);
		System.out.println("Downloads clicked");

		s.type(fileInputTextBox, "TestPDF.pdf");
		System.out.println("Typing in Search ");

		s.click(pdfFileSelect);
		System.out.println("TestPdf is selected");

		s.click(openButton);
		System.out.println("Open clicked");

	}
}
