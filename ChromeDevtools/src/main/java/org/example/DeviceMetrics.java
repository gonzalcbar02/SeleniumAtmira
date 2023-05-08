package org.example;

import io.cucumber.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class DeviceMetrics {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        /*devTools.send(Emulation.setDeviceMetricsOverride(375,
                812,
                50,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));*/

        Map<String, Object> deviceMetrics = new HashMap<>(){

            {
                put("width",375);
                put("height",812);
                put("mobile",true);
                put("deviceScaleFactor",50);
            }

        };

        ((ChromeDriver)driver).executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

        driver.get("https://selenium.dev/");


    }
}
