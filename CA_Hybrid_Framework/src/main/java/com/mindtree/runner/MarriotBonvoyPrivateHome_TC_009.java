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

public class MarriotBonvoyPrivateHome_TC_009 {
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
		js.executeScript("window.scrollBy(0,2250)", "");

}
	@Test 
	public void getClick() throws IOException {
		//Mouse Hover on Private Home Rentals
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//a[@class='hide-mobile custom_click_track m-link-tertiary-button track-completed']//span[contains(text(),'Explore Homes')]"))).perform();
		driver.findElement(By.xpath("//a[@class='hide-mobile custom_click_track m-link-tertiary-button track-completed']//span[contains(text(),'Explore Homes')]")).click();
	    //To close the popup
		Actions ac1=new Actions(driver);
		ac1.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/section[2]/div[1]/section[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/span[1]/i[1]"))).perform();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/section[2]/div[1]/section[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/span[1]/i[1]")).click();
		//To highlight the Homes & Villas
		WebElement exploreTxt = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/section[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/picture[1]/img[1]"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", exploreTxt);
		//to take screenshot
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./Screenshots\\PrivateHome_explore_Home_screenshot01.png"));
		System.out.println("The Screenshot is captured.");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
