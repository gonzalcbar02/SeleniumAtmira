package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGListenerOnFailure extends TestBase{

 @Test(priority = 1)
 public void doLogin(){
  driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
  driver.findElement(By.xpath("(//*/span[@jsname='V67aGc'])[2]")).click();
 }

 /*@Test(priority = 2)
 public void composeEmail(){
  Assert.fail("Error in composing Email");
 }*/

}

class TestBase{

 public static WebDriver driver;

 @BeforeSuite
 public void setUp(){

  if (driver == null){
   driver = new FirefoxDriver();
   driver.get("http://gmail.com");
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

 }

 @AfterSuite
 public void tearDown(){
  driver.quit();
 }

}


