package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SwitchingToTheParentFrame {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_frames2");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println(driver.findElements(By.tagName("iframe")).size());


        driver.findElement(By.id("accept-choices")).click();

        driver.switchTo().frame(1);
        //driver.findElement(By.xpath("//*[@id='nav_translate_btn']/i']")).click();

        /*driver.switchTo().defaultContent();
        driver.switchTo().frame("iframeResult");*/
        driver.switchTo().parentFrame();

    }
}