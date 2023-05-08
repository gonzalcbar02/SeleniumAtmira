package org.example;

import io.qameta.allure.*;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestCase1 {


    @Test
    public void doLogin() throws FileNotFoundException {
        System.out.println("Test Case pass");

    }

    @Test
    @Description("Descripcion del test que aparecera en allure al ejecutar")
    @Severity(SeverityLevel.BLOCKER)
    @Story("In order to perform login")
    @Story("User entered username and password")
    public void doUserReg(){
        System.out.println("Test Case failed");
    }

    @Test
    public void isSkip(){
        throw new SkipException("Skipping the test case");
    }

    @Test
    @Description("Descripcion del test que aparecera en allure al ejecutar")
    @Severity(SeverityLevel.BLOCKER)
    public void doUserReg2(){
        System.out.println("Test Case failed");
    }
}