package com.AutomationCICD.Project1;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

    public WebDriver driver;

    @BeforeMethod
    public void launchDriver() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Headless mode for Jenkins
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");

        // Use temporary directories for Jenkins
        options.addArguments("--user-data-dir=C:/Temp/ChromeData");
        options.addArguments("--disk-cache-dir=C:/Temp/ChromeCache");

        // Explicitly set Chrome binary location
        options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");

        // Initialize WebDriver
        driver = new ChromeDriver(options);

        // Implicit wait and window size
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    public void Test1() {
        driver.navigate().to("https://www.automationtalks.com");
        System.out.println("Test 1 title is " + driver.getTitle());
    }

    @Test
    public void Test2() {
        driver.navigate().to("https://www.automationtalks.com");
        System.out.println("Test 2 title is " + driver.getTitle());
    }

    @Test
    public void Test3() {
        driver.navigate().to("https://www.automationtalks.com");
        System.out.println("Test 3 title is " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
