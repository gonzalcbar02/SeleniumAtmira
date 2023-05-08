package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CallingAndInjectingJavascriptFuntions {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("accept-choices")).click();

//        ((JavascriptExecutor) driver).executeScript("myFunction()");
        driver.switchTo().frame("iframeResult");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("myFunction()");
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));

        driver.switchTo().defaultContent();

    }
}
