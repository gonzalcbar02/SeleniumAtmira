package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://gmail.com");
        driver.manage().window().maximize();

        // Asignacion de espera con IMPLICITLYWAIT
        //driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Asignacion de espera con FLUENTWAIT
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .withMessage("Time out as the condition is not met")
                .ignoring(NoSuchElementException.class);

        // Acciones para que el programa ejecute una funcion
        driver.findElement(By.id("identifierId")).sendKeys("alcaidebarberogonzalo@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();

        // Tenemos que esperar para que podamos coger el elemento de la siguiente pagina ya que si no no existira
        wait.until(ExpectedConditions.elementToBeClickable(By.id("")));



    }
}