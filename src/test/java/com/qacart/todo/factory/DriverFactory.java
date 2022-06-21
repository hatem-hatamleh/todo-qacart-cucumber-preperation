package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser", "CHROME");
        switch (browser){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "SAFARI":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalStateException("BROWSER IS NOT SUPPORTED");

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        DriverFactory.driver.set(driver);
        return driver;

    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
