package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GettingElementsCoordinate {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://gmail.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement img = driver.findElement(By.xpath("//*[@id=\"logo\"]"));

        org.openqa.selenium.Rectangle rectangle = img.getRect();

        System.out.println("Height: "+rectangle.getHeight());
        System.out.println("Width: "+rectangle.getWidth());
        System.out.println("X Coord: "+rectangle.getX());
        System.out.println("Y Coord: "+rectangle.getY());

    }
}
