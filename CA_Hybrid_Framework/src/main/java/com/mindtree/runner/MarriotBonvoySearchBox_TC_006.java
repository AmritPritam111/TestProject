package com.mindtree.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarriotBonvoySearchBox_TC_006 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver=new ChromeDriver();		
		driver.get("https://www.marriott.com/default.mi");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//To click on Destination 
		driver.findElement(By.xpath("//div[@class='with-input hover-60']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Orlando, Florida']")).click();
		
		//To click on Night
		driver.findElement(By.xpath("//span[@class='search__calendar-label icon-nav---book t-label-xs']")).click();
		
	

}
	@Test
	public void userSet() throws InterruptedException {
		//Mousehover on 18
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[4]/span[1]/span[1]"))).perform();
		driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[4]/span[1]/span[1]")).click();
		//Mousehover on 12
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[3]/div[1]/span[1]/span[1]"))).perform();
		driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[3]/div[1]/span[1]/span[1]")).click();
		
		//Mousehover on Done
		Actions ac2 = new Actions(driver);
		ac2.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]"))).perform();
		driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
		
		//Click on FindHotels
		driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/span[2]/button[1]")).click();
		Thread.sleep(5000);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
