package parallelTest;

import org.testng.annotations.Test;

public class TestInvocation extends BaseTest{

    // invocationCount se usara para ver cuantas veces se va a repetir el test
    // threadPoolSize se usara para determinar cuantos test se pueden lanzar a la vez

    /***
     * Automation Architect Selenium with 7 Live Project
     */
    @Test(invocationCount = 5, threadPoolSize = 5)
    public void executeTest(){

        driver = getDriver("chrome");
        driver.get("http://google.com");

        System.out.println(driver.getTitle());

        driver.quit();
    }

}
