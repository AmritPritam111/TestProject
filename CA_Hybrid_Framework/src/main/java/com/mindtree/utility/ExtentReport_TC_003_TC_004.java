package com.mindtree.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport_TC_003_TC_004 {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;

	@BeforeClass
	public void extentInit() {
		// to specify the location
		htmlReporter = new ExtentHtmlReporter("./TestData\\ExtentReporter.html");
		// Title of the report
		htmlReporter.config().setDocumentTitle("Automation Report");
		// Name of the report
		htmlReporter.config().setReportName("Functional Report");
		// To Specify Theme like STANDARD/DARK
		htmlReporter.config().setTheme(Theme.STANDARD);

		// create ExtentReports object and attach Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "AmritPritam");
		extent.setSystemInfo("Browser", "Chrome");

		// create ExtentTest object and specify Report Title
		test = extent.createTest("MarriotBonvoy");
	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		test.log(Status.INFO, "Chrome browser launched");
		driver.manage().window().maximize();
		driver.get("https://www.marriott.com/default.mi");
		test.log(Status.INFO, "Navigated MarriotBonvoy Application");
		// Mouse hover on Sign in or Join
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/a[1]/span[2]")))
				.perform();
		System.out.println("Mouseover Completed");

		// Click on join link
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/div[1]/div[1]/a[1]"))
				.click();

		// To scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

		// To enter first name
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/input[1]"))
				.sendKeys("Pritipriyanka");

		// To enter last name
		driver.findElement(By
				.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]"))
				.sendKeys("Purohit");

		// To click on country
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[2]"))
				.click();

		// To select United Arab Emirates
		driver.findElement(By.xpath("//li[@id='selectric-opt0226']")).click();

		// To scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,450)", "");

		// To enter email
		driver.findElement(By.xpath("//input[@id='field-email']")).sendKeys("priti108@gmail.com");

		// To enter password
		driver.findElement(By.xpath("//input[@id='field-password']")).sendKeys("JellyFish32");

		// To enter confirm password
		driver.findElement(By.xpath("//input[@id='field-password-confirmation']")).sendKeys("JellyFish32");

		// To click on Join button
		driver.findElement(By.xpath("//button[@id='enroll-join']")).click();
		System.out.println("Registration Successful");
	}
	@BeforeMethod
	public void setUpFail() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		test.log(Status.INFO, "Chrome browser launched");
		driver.manage().window().maximize();
		driver.get("https://www.marriott.com/default.mi");
		test.log(Status.INFO, "Navigated MarriotBonvoy Application");
		// Mouse hover on Sign in or Join
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/a[1]/span[2]")))
				.perform();
		System.out.println("Mouseover Completed");

		// Click on join link
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/div[1]/div[1]/a[1]"))
				.click();

		// To scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

		// To enter first name
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/input[1]"))
				.sendKeys("Amrit@w0dwjd");

		// To enter last name
		driver.findElement(By
				.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]"))
				.sendKeys("swsd*");

		// To click on country
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[2]"))
				.click();

		// To select United Arab Emirates
		driver.findElement(By.xpath("//li[@id='selectric-opt0226']")).click();

		// To scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,450)", "");

		// To enter email
		driver.findElement(By.xpath("//input[@id='field-email']")).sendKeys("aksa@com");

		// To enter password
		driver.findElement(By.xpath("//input[@id='field-password']")).sendKeys("JellyFish32");

		// To enter confirm password
		driver.findElement(By.xpath("//input[@id='field-password-confirmation']")).sendKeys("JellyFish32");

		// To click on Join button
		driver.findElement(By.xpath("//button[@id='enroll-join']")).click();
		System.out.println("Registration Unsuccessful");
		
		File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// to get Date stamping with file
		Date dt1 = new Date(); // it will return system date

		DateFormat df12 = new SimpleDateFormat("dd_MM_yyyy_HH_MM_ss");// to convert into required format

		// to save screenshot with date stamping
		FileHandler.copy(f1, new File("./Defects\\titleScreenshot" + df12.format(dt1) + ".png"));
		test.addScreenCaptureFromPath("./Defects\\titleScreenshot" + df12.format(dt1) + ".png");
	}
		
		
	

	@Test
	public void titleTest() throws IOException {

		String pgTitle = driver.getTitle();
		Assert.assertEquals("Discover Marriott Bonvoy | Join The Best Hotel Rewards Program", pgTitle);
		test.log(Status.PASS, "Expected title exist");
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// to get Date stamping with file
		Date dt = new Date(); // it will return system date

		DateFormat df1 = new SimpleDateFormat("dd_MM_yyyy_HH_MM_ss");// to convert into required format

		// to save screenshot with date stamping
		FileHandler.copy(f, new File("./Screenshots\\titleScreenshot" + df1.format(dt) + ".png"));
		test.addScreenCaptureFromPath("./Screenshots\\titleScreenshot" + df1.format(dt) + ".png");// adding screen shot
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterClass
	public void endReport() {
		extent.flush();
	}
}
