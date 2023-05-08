package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ElementScreenshot {

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
//        driver.get("https://google.com");
        driver.get("http://www.way2automation.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/i")).click();
        WebElement ele = driver.findElement(By.id("MzUwOjY5OQ==-1"));

        captureEleScreenshot(ele);

    }

    private static void captureEleScreenshot(WebElement ele) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        BufferedImage fullImg = ImageIO.read(screenshot);

        Point point = ele.getLocation();

        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(),point.getY(),eleWidth,eleHeight);
        ImageIO.write(eleScreenshot,"jpg",screenshot);

        File screenshotLocation = new File("./screenshot/googlelogo.jpg");
        FileUtils.copyFile(screenshot, screenshotLocation);

    }
}
