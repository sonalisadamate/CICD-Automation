package com.AutomationCICD.Project1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Run in headless mode
        options.addArguments("--headless=new"); // "new" headless mode for Chrome 109+

        // Disable GPU, extensions, notifications
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");

        // Use dedicated temp folder for Jenkins (SYSTEM-friendly)
        options.addArguments("--user-data-dir=C:/Temp/JenkinsChrome");
        options.addArguments("--disk-cache-dir=C:/Temp/JenkinsChrome/Cache");

        // Optional: Prevent sandbox issues for SYSTEM account
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Initialize driver
        driver = new ChromeDriver(options);

        // Maximize or set window size (optional)
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Page title: " + driver.getTitle());
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
