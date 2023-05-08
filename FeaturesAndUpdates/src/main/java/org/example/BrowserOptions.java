package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities.*;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BrowserOptions {
    public static void main(String[] args) {

        /*Map<String, String> mobileEm = new HashMap<>();
        mobileEm.put("deviceName", "iPhone X");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.LOGGING_PREFS, options);
        options.merge(capabilities);
        WebDriver driver = new ChromeDriver(options);
*/
    WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    //options.addArguments("--headless");
    //Map<String, Object> prefs = new HashMap<>();
    //options.setExperimentalOption("prefs", prefs);
    //prefs.put("intl.accept_languages", "es");
    //((ChromeOptions) options).setExperimentalOption("prefs", prefs);
    options.addArguments("--ignore-certificate-errors");
    options.addArguments("--allow-insecure-localhost");
    options.addArguments("--disable-print-preview");
    options.addArguments("--remote-allow-origins=*");
    //options.addArguments("--window-size=200,200");
    //options.addArguments("start-maximized");
        options.addArguments("--incognito");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    options.merge(capabilities);
    driver = new ChromeDriver(options);

        // Define el tamaño de la ventana
        // options.addArguments("window-size=1400,1000");

        // Define el tamaño de la ventana
        // options.addArguments("incognito");

        // Permite entrar a las paginas que no son de certificado seguro
        //options.setAcceptInsecureCerts(true);

        // Hacer que no aparezca la informacion de las bars
        //options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //options.setExperimentalOption("mobileEmulation", mobileEm);

        driver.get("https://expired.badssl.com//");
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
