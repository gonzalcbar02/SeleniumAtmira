package org.ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Ejercicio2 {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://tizag.com/htmlT/htmlcheckboxes.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        int numRandom = (int) (Math.random()*4+1);
        String[] name = {"soccer","football","baseball","basketball"};

        for (int i = 0; i < numRandom; i++){
            int numPulsed = (int) (Math.random()*name.length);
            driver.findElement(By.xpath("(//*/input[@value='"+name[numPulsed]+"'])[1]")).click();

        }


    }
}
