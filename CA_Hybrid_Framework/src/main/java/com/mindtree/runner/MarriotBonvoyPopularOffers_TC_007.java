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

public class MarriotBonvoyPopularOffers_TC_007 {
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
		js.executeScript("window.scrollBy(0,750)", "");

	}

	
	@Test 
	public void getClick() throws IOException  {
		// Mousehover on ExploreBrand
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/section[1]/div[1]/div[2]/a[1]/span[1]")))
				.perform();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/section[1]/div[1]/div[2]/a[1]/span[1]"))
				.click();
		//To scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		
		
		// To highlight the ExploreBrand Part
		WebElement popularOffersTxt = driver
				.findElement(By.xpath("//h2[normalize-space()='Get Inspired: Marriott Picks for You']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", popularOffersTxt);
		// To take screenshot
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./Screenshots\\PopularOffers_seemore_screenshot01.png"));
		System.out.println("The Screenshot is captured.");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
