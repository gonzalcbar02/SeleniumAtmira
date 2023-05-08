package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://wikipedia.org");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //driver.findElement(By.name("country")).sendKeys("Germany");

        WebElement dropdown = driver.findElement(By.id("searchLanguage"));
        Select select = new Select(dropdown);

        //select.selectByVisibleText("Eesti");
        select.selectByValue("hi");

        List<WebElement> values = driver.findElements(By.tagName("option"));

        System.out.println(values.size());

        for (int i = 0; i < values.size(); i++)
            System.out.println(values.get(i).getAttribute("lang"));

        /*for(WebElement val : values){
            System.out.println(val.getText());
        }*/

        System.out.println("----PRINTING LINKS----");

        // "//*[@id='www-wikipedia.org']/div[11]/div[3]"
        WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));


        List<WebElement> links = block.findElements(By.tagName("a"));

        System.out.println("Total links are: "+links.size());

        for (WebElement link : links){
            System.out.println(link.getText()+" -- URL IS --- "+link.getAttribute("href"));
        }

        WebElement secondBlock  = driver.findElement(By.id("blockid"));

        secondBlock.findElements(By.id("abc")).get(2).click();


    }
}