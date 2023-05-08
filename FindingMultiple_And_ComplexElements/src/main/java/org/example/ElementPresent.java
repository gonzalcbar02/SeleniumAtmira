package org.example;

import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ElementPresent {

    static WebDriver driver;

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println(isElementPresent(By.id("searchLanguage")));;

    }

    public static boolean isElementPresent(By by){
        /*try {
            driver.findElement(By.xpath(locator));
            return true;
        }catch (Throwable throwable){
            return false;
        }*/
       int size = driver.findElements(by).size();
       if(size == 0){
           return false;
       }else{
           return true;
       }
    }

    public static boolean isElementPresentCSS(String locator){
        /*try {
            driver.findElement(By.xpath(locator));
            return true;
        }catch (Throwable throwable){
            return false;
        }*/
        int size = driver.findElements(By.xpath(locator)).size();
        if(size == 0){
            return false;
        }else{
            return true;
        }
    }

}
