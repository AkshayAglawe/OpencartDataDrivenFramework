package com.opencart.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public String baseURL = "http://www.tutorialsninja.com/demo/";
	//public String baseURL = "https://demo.opencart.com/";
	public String userID = "ak7@gmail.com"; // We are going to use them throughout the framework
	public String password = "akshay";
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void launchApp(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(baseURL);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public static void captureScreenshot(String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
	    // Call getScreenshotAs method to create image file
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
		Date currentdate = new Date();// from java.util
	     //here we have to replace”:” and “space” because this thing is 
		//not supported in the file name.
		String name=String.valueOf(currentdate).replace(" ", "-").replace(":", "-");
		//String name = currentdate.toString().replace(" ", "-").replace(":", "-");
		//Once the screenshot is captured you need to move this file to particular location.
		//FileUtils.copyFile(screenshotFile, new File("C:\\akshay\\videos\\SDET\\GIT_Repo_OfOpencartDDF\\OpenCartDataDrivenFramework\\ScreenShots" + name + ".png"));
		FileUtils.copyFile(screenshotFile, new File(".//ScreenShots//" + name +testName+ ".png"));
	}

	

}
