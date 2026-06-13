package com.automation.tests;

import com.automation.utils.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    public static WebDriver     driver;
    public static WebDriverWait wait;

    public static final String BASE_URL =
            "https://testautomationpractice.blogspot.com/";

    @BeforeSuite
    public void setUp() {

        ExtentReportManager.init();
        System.out.println("[BaseTest] Extent Report initialised.");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("[BaseTest] Chrome browser launched.");

        driver.get(BASE_URL);
        System.out.println("[BaseTest] Navigated to → " + BASE_URL);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("[BaseTest] Browser closed.");
        }
        ExtentReportManager.flush();
    }
}