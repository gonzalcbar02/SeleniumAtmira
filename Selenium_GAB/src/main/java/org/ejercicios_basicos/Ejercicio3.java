package org.ejercicios_basicos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Ejercicio3 {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://timesofindia.indiatimes.com/poll.cms");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//*[@value='1']")).click();
        String datos = driver.findElement(By.id("mathq2")).getText();
        String[] valores = datos.split(" ");
        String suma = String.valueOf((Integer.parseInt(valores[0])+Integer.parseInt(valores[2])));

        driver.findElement(By.id("mathuserans2")).sendKeys(suma);
        driver.findElement(By.xpath("//div[@pg='Vote']")).click();

    }
}
