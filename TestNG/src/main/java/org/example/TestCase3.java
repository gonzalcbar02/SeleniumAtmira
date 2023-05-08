package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends  BaseTest{

    @Test(priority = 2, dependsOnMethods = {"doUserReg"}, alwaysRun = true, groups = ("smoke"))
    public void doLogin(){

        System.out.println("Executing login test");

    }

    @Test(priority = 1, groups = "functional")
    public void doUserReg(){

        System.out.println("Executing User Reg test");
        Assert.fail("User not registered successfully");

    }

}
