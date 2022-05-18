package com.mindtree.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MarriotBonvoyLoginPage_TC_005 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver=new ChromeDriver();		
		driver.get("https://www.marriott.com/default.mi");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Mousehover on Signup or join
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/a[1]/span[2]"))).perform();
		//To click on sign in link
		driver.findElement(By.xpath("//button[@class='signin-btn t-subtitle-l custom_click_track track-completed']")).click();
		
		
	}
	
	@DataProvider (name="TestData")
	public Object[][] getData(){
		Object[][] data= new Object[3][2];
		data[0][0]="ab99@gmail.com";
		data[0][1]="BankLogin13";
		
		data[1][0]="bm88@gmail.com";
		data[1][1]="BankLogin1356";
		
		data[2][0]="priti108@gmail.com";
		data[2][1]="JellyFish32";
		
		return data;
	}
	
	@Test (dataProvider="TestData")
	public void userLogin(String email, String pwd) throws InterruptedException  {
		driver.findElement(By.xpath("//input[@id='signin-userid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='signin-user-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit'][normalize-space()='Sign In']")).click();
		Thread.sleep(5000);
		
	//TestNg Assert class to validate page title
		Assert.assertEquals(driver.getTitle(), "Sign In");
		//to send user msg into XML reports and log section
		Reporter.log("Successful Login operation", true);
		

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}



