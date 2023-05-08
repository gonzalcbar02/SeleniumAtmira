package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HandlingTabsAndPopups {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.hdfcbank.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("loginsubmit")).click();

        // 2º Windows
        driver.findElement(By.xpath("xpath de la segunda ventana")).click();
        driver.findElement(By.xpath("xpath de la segunda ventana")).click();

        // 3º Windows
        System.out.println(driver.getTitle().contains("JetPrivileges"));
    }
}
