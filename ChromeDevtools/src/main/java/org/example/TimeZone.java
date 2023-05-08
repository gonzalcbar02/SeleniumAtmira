package org.example;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class TimeZone {
    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://whatismytimezone.com/");

        Thread.sleep(5000);

        DevTools chromeDevTools = ((ChromeDriver) driver).getDevTools();

//        DevTools devTools = driver.getDevTools();
        chromeDevTools.createSession();
        chromeDevTools.send(Emulation.setTimezoneOverride("EST"));
        driver.get("https://whatismytimezone.com/");


    }
}
