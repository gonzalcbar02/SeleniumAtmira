package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class TryIT {

    static WebDriver driver;
    public static void captureScreenshot() throws IOException {

        Date d = new Date();
        String file =  d.toString().replace(":","_").replace(" ","_")+".jpg";


        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./screenshot/"+file));

    }

    public static void main(String[] args) throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("accept-choices")).click();

        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("/html/body/button")).click();

        driver.switchTo().defaultContent();

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Numbers iframes are: "+frames.size());

        for (WebElement element: frames){
            System.out.println(element.getAttribute("id"));
        }

        captureScreenshot();


    }
}
