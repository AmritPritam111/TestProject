package com.mindtree.runner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarriotBonvoyWhereWGN_TC_008 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.marriott.com/default.mi");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//To scrolldown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1350)", "");

	}
	@Test 
	public void getClick() throws IOException {
		//Mouse hover on Where will you go next
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//a[@class='d-none d-md-block custom_click_track m-link-tertiary-button track-completed']//span[contains(text(),'Explore')]"))).perform();
		driver.findElement(By.xpath("//a[@class='d-none d-md-block custom_click_track m-link-tertiary-button track-completed']//span[contains(text(),'Explore')]")).click();
		//highlight the Bonvoy traveller part
		WebElement exploreTxt = driver
				.findElement(By.xpath("//img[@alt='Marriott Bonvoy Traveler']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", exploreTxt);
		//to take screenshot
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./Screenshots\\Wherewillyougo_explore_screenshot01.png"));
		System.out.println("The Screenshot is captured.");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
