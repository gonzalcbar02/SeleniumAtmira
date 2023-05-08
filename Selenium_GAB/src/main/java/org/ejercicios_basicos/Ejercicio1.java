package org.ejercicios_basicos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {

        // EJERCICIO 1

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.google.es/");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Way2Automation");
        driver.findElement(By.xpath("(//input[@value='Buscar con Google'])[2]")).click();
//        driver.findElement(By.xpath("")).click();
//        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.partialLinkText("Way2Automation")).click();

        List<WebElement> list = driver.findElements(By.xpath("//div/ul[@class='elementor-icon-list-items elementor-inline-items']/li"));

        System.out.println("Links and text from the page are: "+list.size());
        System.out.println("----------------------------------------------");
        System.out.println("Content links and text from the page are:");
        for (WebElement elemento: list) {
            System.out.println("\t"+elemento.getText());
        }




    }
}