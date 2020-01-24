package com.test.IHTC.utilities;



	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.MediaEntityModelProvider;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Protocol;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public abstract class Reporting {

		public ExtentHtmlReporter html;
		static ExtentReports extent;
		public ExtentTest test, suiteTest;
		public String testCaseName, testNodes, testDescription, category, authors,imagePath;
		//public WebDriver driver;

		public void startResult() {

			html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/result.html");
			html.config().setDocumentTitle("Selenium");
			html.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");	
			extent = new ExtentReports();
			extent.attachReporter(html);
			html.config().setTheme(Theme.DARK);
		}

		public ExtentTest startTestModule(String testCaseName, String testDescription) {
			suiteTest = extent.createTest(testCaseName, testDescription);
			return suiteTest;
		}

		public ExtentTest startTestCase(String testNodes) {
			test = suiteTest.createNode(testNodes);
			return test;
		}

		public abstract long takeScreenShot();
		

		public void reportStep(String desc, String status, boolean bSnap) {

			
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Configurations/config.properties")));

				imagePath = prop.getProperty("Imagepath");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			MediaEntityModelProvider img = null;
			if (bSnap && !status.equalsIgnoreCase("INFO")) {

				long snapNumber = 1000000L;
				snapNumber = takeScreenShot();
				//takeScreenShot();
				try {
					if (imagePath == null) {
						img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".png")
								.build();
						System.out.println("if");
					} else {
						img = MediaEntityBuilder.createScreenCaptureFromPath(imagePath + "/" + snapNumber + ".png").build();
						System.out.println("else");
					}
				} catch (IOException e) {

				}
			}
			if (status.equalsIgnoreCase("PASS")) {
				test.pass(desc, img);
				test.log(Status.PASS, MarkupHelper.createLabel(" PASSED ", ExtentColor.GREEN));
			} 
			else if (status.equalsIgnoreCase("FAIL")) {
				test.fail(desc, img);
	            test.log(Status.FAIL, MarkupHelper.createLabel(" FAILED ", ExtentColor.RED));
				throw new RuntimeException();
			} 
			else if (status.equalsIgnoreCase("WARNING")) {
				test.warning(desc, img);
				test.log(Status.SKIP, MarkupHelper.createLabel(" WARNING ", ExtentColor.YELLOW)); 
			} 
			else if (status.equalsIgnoreCase("INFO")) {
				test.info(desc);
				test.log(Status.INFO, MarkupHelper.createLabel(" INFO ", ExtentColor.PINK));
			}
		}

			

		public void reportStep(String desc, String status) {
			System.out.println("Actions --> " + desc + " " + status + " ");
			reportStep(desc, status, true);
		} 

		public void endResult() {
			extent.flush();
		}
		public void endTestcase(){
			extent.removeTest(test);
		}
	}

