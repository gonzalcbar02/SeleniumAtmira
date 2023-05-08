package org.example;

import org.testng.annotations.*;

public class TestCase1 {

    @BeforeTest
    public void creatingDBConn(){
        System.out.println("Creating DB conn");
    }

    @AfterTest
    public void closeDBConn(){
        System.out.println("Closing DB conn");
    }

    @BeforeMethod
    public void launchBrowser(){

        System.out.println("Launching browser");

    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Closing the browser");
    }

    @Test(priority = 2)
    public void doLogin(){

        System.out.println("Executing login test");

    }

    @Test(priority = 1)
    public void doUserReg(){

        System.out.println("Executing User Reg test");

    }

}