package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardEvents {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://gmail.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("identifierId")).sendKeys("alcaidebarberogonzalo@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div")).click();
        //driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.chord(Keys.CONTROL+"a")).build().perform();
        actions.sendKeys(Keys.chord(Keys.CONTROL+"c")).build().perform();

        driver.findElement(By.id("identifierId")).click();
        actions.sendKeys(Keys.chord(Keys.CONTROL+"v")).build().perform();
//        actions.sendKeys(Keys.ENTER).perform();

    }
}
