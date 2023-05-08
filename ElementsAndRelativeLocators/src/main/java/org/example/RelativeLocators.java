package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class RelativeLocators {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://way2automation.com/way2auto_jquery/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       WebElement element = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select")));
       element.sendKeys("trainer@way2automation.com");

        WebElement element2 = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select")));
        element2.sendKeys("New Delhi");

        //WebElement element3 = driver.findElement(RelativeLocator.with(By.partialLinkText("THE")).near(By.linkText("Signin")));
        //element3.click();

        WebElement element4 = driver.findElement(RelativeLocator.with(By.xpath("//input[@type= 'password']")).toRightOf(By.tagName("label")));
        element4.sendKeys("adsdadad");

        WebElement element5 = driver.findElement(RelativeLocator.with(By.linkText("Signin")).toLeftOf(By.xpath("(//*[@id=\"load_form\"]/div[1]/div[2]/input)[2]")));
        element5.click();


    }
}
