package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class WebTable {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> rowsNum = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr"));

        System.out.println("Total rows are: "+rowsNum.size());

        List<WebElement> colsNum = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr[1]/td"));

        System.out.println("Total cols are: "+colsNum.size());

        for(int rows = 1; rows <= rowsNum.size(); rows++){

            for(int cols = 1; cols <= colsNum.size(); cols++){

                System.out.print( driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+rows+"]/td["+cols+"]")).getText()+" | ");

            }
            System.out.println("");

        }

    }
}
