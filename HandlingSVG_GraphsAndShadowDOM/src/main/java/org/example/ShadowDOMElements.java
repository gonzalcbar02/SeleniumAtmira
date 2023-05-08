package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ShadowDOMElements {
    public static void main(String[] args) {

        // Para sacar el shadowRoot necesitaremos ir sacando desde el padre hasta el hijo los shadow root que tenga
        // Tambien tendremos que usar la clas SearchContext para ir guardando el contenido que sacaremos del JavascriptExecutor

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("chrome://downloads/");

        WebElement root = driver.findElement(By.cssSelector("downloads-manager"));
        SearchContext shodowRoot1 = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", root);

        WebElement root2 =  shodowRoot1.findElement(By.cssSelector("downloads-toolbar"));
        SearchContext shodowRoot2 = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", root2);

        WebElement root3 =  shodowRoot2.findElement(By.cssSelector("cr-toolbar"));
        SearchContext shodowRoot3 = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", root3);

        WebElement root4 =  shodowRoot3.findElement(By.cssSelector("cr-toolbar-search-field"));
        SearchContext shodowRoot4 = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", root4);



        shodowRoot4.findElement(By.cssSelector("#searchInput")).sendKeys("Hello");

    }
}
