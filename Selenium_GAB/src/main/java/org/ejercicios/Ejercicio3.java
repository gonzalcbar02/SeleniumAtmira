package org.ejercicios;

import com.github.dockerjava.api.model.WaitResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class Ejercicio3 {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14 pro max");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(ENTER);

        driver.findElement(RelativeLocator.with(By.tagName("div")).below(By.xpath("//*/span[contains(text(), 'Result')]"))).click();

        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.xpath("//*//form[@id='attach-view-cart-button-form']//span[@id='attach-sidesheet-view-cart-button']")).click();

        System.out.println("Your product is: "+driver.findElement(By.xpath("//form[@id='activeCartViewForm']//li//span[@class='a-truncate-cut']")).getText());

    }
}
