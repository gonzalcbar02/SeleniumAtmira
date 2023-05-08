package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class JquerySliders {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://jqueryui.com/resources/demos/slider/default.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement mainSlider = driver.findElement(By.id("slider"));
        int width = mainSlider.getSize().width/2;


        WebElement slider = driver.findElement(By.tagName("span"));

        new Actions(driver).dragAndDropBy(slider,width,0).perform();

    }
}
