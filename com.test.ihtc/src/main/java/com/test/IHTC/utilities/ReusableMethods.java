package com.test.IHTC.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ReusableMethods extends Reporting {

	public static WebDriver driver;
	public static Logger logger;

	ReadConfig readConfig = new ReadConfig();
	public String loginUrl = readConfig.BaseUrl();
	public String signupUrl = readConfig.SignpUrl();

	@Parameters("browser")

	@BeforeMethod
	public void browserSetup(String browser) {

		logger = logger.getLogger("Selenium");
		PropertyConfigurator.configure("Log4j.properties");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver 3");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
			driver = new InternetExplorerDriver();
		}

		else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			Actions builder = new Actions(driver);
		}
	}

	public void click(WebElement element) {

		String text = "";

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			text = element.getText();
			element.click();

			reportStep("The element : " + text + " is clicked Successfully", "PASS");
			logger.info("The element : " + text + " is clicked Successfully");
		} catch (InvalidElementStateException e) {

			reportStep("The element: " + text + " is not clicked", "FAIL");
			logger.info("The element : " + text + " is not clicked Successfully");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
			logger.info("WebDriverException" + e.getMessage());
		}
	}

	public void setValue(WebElement element, String data) {

		String text = "";
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));

			element.sendKeys(data);
			text = element.getText();

			reportStep("The word : " + data + " is entered Successfully", "PASS");
			logger.info("The word : " + data + " is entered Successfully");

		} catch (InvalidElementStateException e) {
			reportStep("The word: " + data + " is not entered successfully", "FAIL");
			logger.info("The word : " + data + " is not entered Successfully");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
			logger.info("WebDriverException" + e.getMessage());
		}
	}

	public void clickUsingJavaScript(WebElement element) {

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", element);
	}

	public boolean verifyIsDisplayed(WebElement element) {

		try {
			if (element.isDisplayed()) {
				reportStep("The element " + element + " is displayed", "PASS");
			} else {
				reportStep("The element " + element + " is not displayed", "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : " + e.getMessage(), "FAIL");
		}
		return true;
	}

	public void verifyIsEnabled(WebElement element) {
		try {
			if (element.isEnabled()) {
				reportStep("The element " + element + " is selected", "PASS");
			} else {
				reportStep("The element " + element + " is not selected", "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : " + e.getMessage(), "FAIL");
		}
	}

	public boolean verifyChecked(WebElement element) {
		try {
			if (element.isSelected()) {

				reportStep("The element " + element + " is selected", "PASS");
				System.out.println("Live Radar is checked");
			} else {
				reportStep("The element " + element + " is not selected", "FAIL");
				System.out.println("Live Radar is not checked");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : " + e.getMessage(), "FAIL");
		}
		return true;
	}

	// Select by index
	public void selectByIndex(int index, WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// Select by visible text
	public void selectByVisibleText(String text, WebElement element) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// Select by value
	public void selectByValue(String value, WebElement element) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	// Scroll by pixel

	public void scrollbyPixels() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		// Scroll vertically down by 1000 pixel
	}

	// Scroll till the visiblity of the element and Scroll horizontally

	public void scrollToElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// Scroll till the bottom of the page

	public void scrollToBottom() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void maximizeBrowser() {

		driver.manage().window().maximize();
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed", "PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser: \n Error: " + e.getMessage(), "FAIL", false);
		}
	}

	public void sleep(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void windowsHandle(WebElement element) {

		String parentWindow = driver.getWindowHandle();// gets the current window
		element.click(); // click some link that opens a new window

		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
// switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
	}

	public void navigateBack() {
		try {
			driver.navigate().back();
			// logger.info("Navigated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateForward() {
		try {
			driver.navigate().forward();
			// logger.info("Navigated Forward");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public void mouseAction(WebElement element) throws InterruptedException {

		Actions actions = new Actions(driver);
		/*
		 * actions.moveToElement(ele1).perform(); actions.moveToElement(ele2).perform();
		 * 
		 * ele2.click();
		 */

		actions.moveToElement(element).perform();
		Thread.sleep(500);

	}

	public Actions getAction(WebDriver driver) {
		Actions action = null;

		if (action == null) {
			action = new Actions(driver);
		}
		return action;
	}

	public void upload(WebElement element, String path) {

		// WebElement uploadElement =
		// driver.findElement(By.xpath("//input[@name='file']"));
		// element.sendKeys(".TestInputData/TestPDF.pdf");
		element.sendKeys(path);
		// element.sendKeys("/Users/tringapps/Downloads/TestPDF.pdf");
	}

	@Override
	public long takeScreenShot() {
		System.out.println("Screenshot called.....s");
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFiler,
					new File(System.getProperty("user.dir") + "/reports/images/" + number + ".png"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}
}
