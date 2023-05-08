package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NewTabsAndWindows {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.way2automation.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://google.com");
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("Hello Selenium 4");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http:google.com");
        System.out.println(driver.getTitle());

        System.out.println(driver.getWindowHandles().size());

        Set<String>winids =  driver.getWindowHandles();
        Iterator<String> iterator =  winids.iterator();

        List<String> winIndex = new ArrayList<>();
        while (iterator.hasNext()){

            winIndex.add(iterator.next());
        }
        driver.switchTo().window(winIndex.get(0));
        System.out.println("First window title is: "+driver.getTitle());

        driver.close();

        driver.switchTo().window(winIndex.get(1));
        System.out.println("Second window title is: "+driver.getTitle());

        driver.close();

        driver.switchTo().window(winIndex.get(2));
        System.out.println("Three window title is: "+driver.getTitle());

        driver.quit();
    }
}
