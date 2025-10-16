package com.AutomationCICD.Project1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

    private static WebDriver driver;

    @BeforeMethod
    public void launchDriver() {
        try {
            // ✅ Setup ChromeDriver automatically
            WebDriverManager.chromedriver().setup();

            // ✅ Chrome options (tuned for Jenkins and local)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new"); // More stable than --headless
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");

            // ✅ Explicit ChromeDriverService for CI
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingAnyFreePort()
                    .withSilent(true)
                    .build();

            service.start();
            driver = new ChromeDriver(service, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("✅ Chrome launched successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to start ChromeDriver: " + e.getMessage());
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
