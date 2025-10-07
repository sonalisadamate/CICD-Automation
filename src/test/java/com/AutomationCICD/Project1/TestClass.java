package com.AutomationCICD.Project1;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestClass {

    public WebDriver driver;

    @BeforeMethod
    public void launchDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // new headless mode for recent Chrome
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
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
