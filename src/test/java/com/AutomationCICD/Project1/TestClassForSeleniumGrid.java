package com.AutomationCICD.Project1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClassForSeleniumGrid {

    public WebDriver driver;
    private final String hubURL = "http://192.168.1.3:4444/wd/hub"; // Selenium Grid Hub URL

    @BeforeClass
    public void launchDriver() throws MalformedURLException {
        // Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // optional: run without opening browser window
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Optional: specify platform/browser version
        options.setPlatformName("WINDOWS");

        // Connect to Selenium Grid
        driver = new RemoteWebDriver(new URL(hubURL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        driver.get("https://www.automationtalks.com");
        System.out.println("Test 1 title is: " + driver.getTitle());
    }

    @Test
    public void test2() {
        driver.get("https://www.automationtalks.com");
        System.out.println("Test 2 title is: " + driver.getTitle());
    }

    @Test
    public void test3() {
        driver.get("https://www.automationtalks.com");
        System.out.println("Test 3 title is: " + driver.getTitle());
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
