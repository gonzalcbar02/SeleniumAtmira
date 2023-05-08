package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.console.Console;
import org.openqa.selenium.devtools.v85.log.Log;



public class ConsoleLog {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Log.enable());
        devTools.send(Console.enable());

        devTools.addListener(Log.entryAdded(), entry ->{

            System.out.println("Text is: "+entry.getText());
            System.out.println("TimeStamp is: "+entry.getTimestamp());
            System.out.println("Source is: "+entry.getSource());
            System.out.println("Level is: "+entry.getLevel());

        });

        devTools.addListener(Console.messageAdded(), message ->{

            System.out.println("Console Text is: "+message.getText());
        });

        driver.get("http://flipkart.com");

        ((JavascriptExecutor) driver).executeScript("console.log('This is a sample log')");

    }
}
