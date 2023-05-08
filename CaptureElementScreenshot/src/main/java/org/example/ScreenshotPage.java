package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotPage {
    public static void main(String[] args) throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://way2automation.com");
        driver.manage().window().maximize();

        if(driver instanceof FirefoxDriver){
            File fullpage = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(fullpage, new File("./screenshot/fullpage.jpg"));


        } else if (driver instanceof  ChromeDriver) {
            File pageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(pageScreenshot, new File("./screenshot/page.jpg"));

        }

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
}
