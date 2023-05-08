package org.ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Ejercicio1 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //Pagina parcialmente bloqueada para nuestra región
        // REALIZAR ACTIVIDAD CON IBERIA
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // RELLENO DE DATOS PARA SELECCION DE VUELOS
        driver.findElement(By.xpath("//form//select[@name='fromPort']")).sendKeys("San Diego");
        driver.findElement(By.xpath("//form//select[@name='toPort']")).sendKeys("Dublin");
        driver.findElement(By.xpath("//form//input[@value='Find Flights']")).click();

        // CLICK PARA ELEGIR VUELO AL CAMBIAR DE PAG
        driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[4]")).click();

        // RELLENO FORMULARIO PARA LOS DATOS DEL VUELO
        driver.findElement(By.id("inputName")).sendKeys("Gonzalo");
        driver.findElement(By.id("address")).sendKeys("Don Lopez De Sosa");
        driver.findElement(By.id("city")).sendKeys("Cordoba");
        driver.findElement(By.id("state")).sendKeys("España");
        driver.findElement(By.id("zipCode")).sendKeys("14200");
        driver.findElement(By.id("cardType")).sendKeys("Diner's Club");
        driver.findElement(By.id("creditCardNumber")).clear();
        driver.findElement(By.id("creditCardNumber")).sendKeys("100");
        driver.findElement(By.id("creditCardMonth")).clear();
        driver.findElement(By.id("creditCardMonth")).sendKeys("5");
        driver.findElement(By.id("creditCardYear")).clear();
        driver.findElement(By.id("creditCardYear")).sendKeys("2023");
        driver.findElement(By.id("nameOnCard")).sendKeys("GonzaloQA");
        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.xpath("//input[@type='submit'][@value='Purchase Flight']")).click();





    }
}
