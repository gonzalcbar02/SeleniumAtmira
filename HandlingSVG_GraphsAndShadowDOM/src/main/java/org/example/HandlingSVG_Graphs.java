package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingSVG_Graphs {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        driver.get("https://www.covid19india.org/");

        Thread.sleep(5000);



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[4]/div[2]/div/div[9]/div[1]"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]"))).click();

            List<WebElement> graphPoints = driver.findElements(By.xpath("(//*[name()=\"svg\" and @preserveAspectRatio=\"xMidYMid meet\"])[6]//*[local-name()=\"circle\"]"));

        System.out.println("graphPinst are: "+graphPoints.size());

        Actions action = new Actions(driver);
        for(WebElement point: graphPoints){
            action.moveToElement(point).perform();
            System.out.println(driver.findElement(By.xpath("//div[@class='stats is-confirmed']/div/h2")).getText());
        }

    }
}