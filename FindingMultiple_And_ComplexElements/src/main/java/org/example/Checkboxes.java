package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Checkboxes {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /*driver.findElement(By.xpath("//*[@value='soccer']")).click();
        driver.findElement(By.xpath("//*[@value='football']")).click();
        driver.findElement(By.xpath("//*[@value='baseball']")).click();
        driver.findElement(By.xpath("//*[@value='basketball']")).click();*/

        /*for (int i = 1; i <= 4 ; i++){
                driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
        }*/

        // ERROR AL EJECUTAR (VER FALLO)
        /*int i = 1, count = 0;
        while (ElementPresent.isElementPresent(By.xpath("//div[4]/input["+i+"]"))) {
            driver.findElement(By.xpath("//div[4]/input[" + i + "]")).click();
            i++;
            count++;
        }
        System.out.println("Total checkBoxes are: "+count);*/

        WebElement block  = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
        List<WebElement> checkBoxes = block.findElements(By.name("sports"));

        System.out.println("Total checkboxes are: "+checkBoxes.size());

        for (WebElement checkbox: checkBoxes ) {
            checkbox.click();
        }


    }


}
