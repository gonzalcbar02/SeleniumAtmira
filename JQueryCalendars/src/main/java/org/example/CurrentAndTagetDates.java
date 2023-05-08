package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Calendar;

public class CurrentAndTagetDates {

    static int targetDay = 0, targetMonth = 0, targetYear = 0;
    static int currentDay = 0,    currentMonth = 0, currentYear = 0;
    static int jumpMonthsBy = 0;
    static boolean increment = true;

    public static void main(String[] args) throws InterruptedException {


        /**
         *
         * target day, month, year
         * current day, month, year
         * jump to the month
         * increment or decrement
         *
         */

        String datetoSet = "16/08/2015";

        //get current date
        getCurrentDateMonthAndYear();
        System.out.println(currentDay+"    "+currentMonth+"    "+currentYear);

        // get target date
        getTargetDateMinthAndYear(datetoSet);
        System.out.println(targetDay+"     "+targetMonth+"     "+targetYear);

        // get jump month
        CalculateHowManyMonthsToJump();
        System.out.println(jumpMonthsBy);
        System.out.println(increment);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id='datepicker']")).click();

        for (int i = 0; i < jumpMonthsBy; i++){
            if(increment){
                driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
            }else{
                driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]")).click();
            }

            Thread.sleep(1000);

        }

        driver.findElement(By.linkText(Integer.toString(targetDay))).click();

    }

    public static  void getCurrentDateMonthAndYear(){

        Calendar calendar = Calendar.getInstance();

        currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentMonth = calendar.get(Calendar.MONTH)+1;
        currentYear = calendar.get(Calendar.YEAR);

    }

    public static void getTargetDateMinthAndYear(String dateString){

        int firstIndex = dateString.indexOf("/");
        int lastIndex = dateString.lastIndexOf("/");

        String day = dateString.substring(0, firstIndex);
        targetDay = Integer.parseInt(day);

        String month = dateString.substring(firstIndex+1, lastIndex);
        targetMonth = Integer.parseInt(month);

        String year = dateString.substring(lastIndex+1, dateString.length());
        targetYear = Integer.parseInt(year);
    }

    public static void CalculateHowManyMonthsToJump(){

        if((targetMonth-currentMonth) >0){
            jumpMonthsBy = (targetMonth-currentMonth);
        }else{
            jumpMonthsBy = (currentMonth-targetMonth);
            increment = false;
        }

    }

}
