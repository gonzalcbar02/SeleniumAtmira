package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class ResizableElements {

    public static void main(String[] args) {


        // EJERCICIO PARA AUMENTAR LA VENTANA DEL NAVEGADOR

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement resizable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(resizable, 400, 400).perform();





    }

}
