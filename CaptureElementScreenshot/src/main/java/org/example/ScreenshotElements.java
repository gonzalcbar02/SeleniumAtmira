package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotElements {
    public static void main(String[] args) throws IOException {

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://way2automation.com/way2auto_jquery/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        WebElement element = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select")));
        element.sendKeys("trainer@way2automation.com");
        File foto = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File("./screenshot/above.jpg"));


        WebElement element1 = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select")));
        element1.sendKeys("New Delhi");
        File foto2 = element1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto2, new File("./screenshot/below.jpg"));

    }
}