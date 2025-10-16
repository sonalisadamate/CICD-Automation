package com.AutomationCICD.Project1;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

    WebDriver driver;

    @BeforeMethod
    public void launchDriver() {
        try {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new"); // new headless mode (more stable)
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("✅ Chrome launched successfully in Jenkins.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to start ChromeDriver in Jenkins: " + e.getMessage());
        }
    }

    @Test
    public void Test1() {
        driver.navigate().to("https://www.automationtalks.com");
        System.out.println("Test 1 title is: " + driver.getTitle());
    }

    @Test
    public void Test2() {
        driver.navigate().to("https://www.automationtalks.com");
        System.out.println("Test 2 title is: " + driver.getTitle());
    }

    @Test
    public void Test3() {
        driver.navigate().to("https://www.automationtalks.com");
        System.out.println("Test 3 title is: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✅ Browser closed successfully.");
        }
    }
}
