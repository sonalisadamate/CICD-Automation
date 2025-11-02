package com.AutomationCICD.Project1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

    public WebDriver driver;

    @BeforeMethod
    public void launchDriver() throws MalformedURLException {
        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Important for Jenkins (no GUI)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
     // Optional, since your node is Windows
        options.setPlatformName("WINDOWS");
        // Connect to Selenium Grid Hub
        String hubURL = "http://192.168.1.9:4444"; // ✅ Use your current Hub IP (from console log)
        driver = new RemoteWebDriver(new URL(hubURL), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Test1() {
        driver.get("https://www.automationtalks.com");
        System.out.println("Test 1 Title: " + driver.getTitle());
    }

    @Test
    public void Test2() {
        driver.get("https://www.automationtalks.com");
        System.out.println("Test 2 Title: " + driver.getTitle());
    }

    @Test
    public void Test3() {
        driver.get("https://www.automationtalks.com");
        System.out.println("Test 3 Title: " + driver.getTitle());
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
