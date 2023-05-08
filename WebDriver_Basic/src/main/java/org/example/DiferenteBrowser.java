package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


/***
 * Clase que realiza el arranque de diferentes navegadores dependiendo del que se le indique
 */

public class DiferenteBrowser {
    public static String browser = "Chrome";
    public  static WebDriver driver;

    public static void main(String[] args) {

        // Ejecución dependiendo de los diferentes navegadores

        if(browser.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }else if (browser.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }

        driver.get("http://way2automation.com");
        driver.close();

    }
}
