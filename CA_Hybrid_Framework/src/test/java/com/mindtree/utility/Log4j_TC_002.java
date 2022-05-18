package com.mindtree.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Log4j_TC_002 {
	private Logger logger;
	public WebDriver driver;

	@Test
	public void setUp() {
		logger = Logger.getLogger("Log4j_TC_002.class");
		PropertyConfigurator.configure("C:\\Users\\mindsdet143\\eclipse-workspace\\CA_Hybrid_Framework\\src\\main\\resources\\log4j.properties");
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		logger.info("Browser executable file running");
		driver = new ChromeDriver();
		logger.info("Browser launched");
		driver.get("https://www.marriott.com/default.mi");
		logger.info("Application opened");
		driver.manage().window().maximize();
		// Mouse hover on Sign in or Join
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/a[1]/span[2]")))
				.perform();
		System.out.println("Mouseover Completed");
		logger.info("Mousehover completed");

		// Click on join link
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/div[1]/div[1]/a[1]"))
				.click();

		// To scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		logger.info("Scrolldown completed");

		// To enter first name
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/input[1]"))
				.sendKeys("Rakesh");

		// To enter last name
		driver.findElement(By
				.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]"))
				.sendKeys("Pradhan");

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
		driver.findElement(By.xpath("//input[@id='field-email']")).sendKeys("bm88@gmail.com");

		// To enter password
		driver.findElement(By.xpath("//input[@id='field-password']")).sendKeys("BankLogin1356");

		// To enter confirm password
		driver.findElement(By.xpath("//input[@id='field-password-confirmation']")).sendKeys("BankLogin1356");

		// To click on Join button
		driver.findElement(By.xpath("//button[@id='enroll-join']")).click();
		System.out.println("Registration Successful");
		logger.info("Registration Successful");

		// To close the window
		driver.close();
	}
}
