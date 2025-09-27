package com.AutomationCICD.Project1;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestClass1 {

	 public static WebDriver driver;
	@BeforeMethod
	public void launchDriver()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().fullscreen();
	}
	@Test
	public void Test1()
	{
		driver.navigate().to("https://www.automationtalks.com");
		System.out.println("Test 1 title is" + driver.getTitle());
	}
	@Test
	public void Test2()
	{
		driver.navigate().to("https://www.automationtalks.com");
		System.out.println("Test 2 title is" +driver.getTitle());
	}
	@Test
	public void Test3()
	{
		driver.navigate().to("https://www.automationtalks.com");
		System.out.println("Test 3 title is" +driver.getTitle());
	}
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
