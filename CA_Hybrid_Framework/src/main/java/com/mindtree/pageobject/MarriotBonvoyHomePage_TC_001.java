package com.mindtree.pageobject;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MarriotBonvoyHomePage_TC_001 {

	public static void main(String[] args) throws IOException {
		//to specify Properties file location
		FileInputStream fi= new FileInputStream("./Properties\\inputdata.properties");
		//create Object for properties class
		Properties prop=new Properties();
		prop.load(fi);
		//to read key values from properties file
		String autURL=prop.getProperty("baseURL");
		String FN=prop.getProperty("FirstName");
		String LN=prop.getProperty("LastName");
		String email=prop.getProperty("Email");
		String password=prop.getProperty("Password");
		String cp=prop.getProperty("ConfirmPassword");
		
		//To launch the browser
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(autURL);
		driver.manage().window().maximize();
		
		//Mouse hover on Sign in or Join
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/a[1]/span[2]"))).perform();
		System.out.println("Mouseover Completed");
		
		//Click on join link
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/div[1]/div[1]/a[1]")).click();
		
		//To scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		
		//To enter first name
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys(FN);
		
		//To enter last name
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[3]/div[1]/input[1]")).sendKeys(LN);
		
		//To click on country
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/section[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[2]")).click();
		
		//To select United Arab Emirates
		driver.findElement(By.xpath("//li[@id='selectric-opt0226']")).click();
		
		//To scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,450)", "");
		
		//To enter email
		driver.findElement(By.xpath("//input[@id='field-email']")).sendKeys(email);
		
		//To enter password
		driver.findElement(By.xpath("//input[@id='field-password']")).sendKeys(password);
		
		//To enter confirm password
		driver.findElement(By.xpath("//input[@id='field-password-confirmation']")).sendKeys(cp);
		
		//To click on Join button
		driver.findElement(By.xpath("//button[@id='enroll-join']")).click();
		System.out.println("Registration Successful");
		
		//To close the window
		driver.close();
		
		
		
	}

}
