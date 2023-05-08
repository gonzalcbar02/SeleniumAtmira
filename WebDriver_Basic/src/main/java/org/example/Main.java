package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://way2automation.com");

        // El metodo getTittle nos permite devolver el titutlo de la pag a la que nos hayamos conectado
        System.out.printf(driver.getTitle());

        // Ventana actual del navegador
        driver.close();

        // Ventana actual del navegador + todos los navegadores relacionados en la misma sesión
        driver.quit();

    }
}