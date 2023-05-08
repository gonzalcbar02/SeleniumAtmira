package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;


public class TestCase1 {


    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest
    public void setReport(){

        htmlReporter = new ExtentSparkReporter("./reports/extent.html");
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle("W2A Automation Reports");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Automation Tester","Rahul Arora");
        extent.setSystemInfo("Organization","Way2Automation");
        extent.setSystemInfo("Build No","W2A-1234");


    }

    @AfterTest
    public void endReport(){
        extent.flush();
    }

    /*
     * PASS, FAIL , SKIP
     */

    @Test
    public void doLogin(){
        test = extent.createTest("Login Test");
        System.out.println("Executing Login Test");
    }

    @Test
    public void doUserReg(){
        test = extent.createTest("User Reg Test");
        Assert.fail("User Reg Test Failed");
    }

    @Test
    public void isSkip(){
        test = extent.createTest("Skip Test");
        throw new SkipException("Skipping the test case");
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){

            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
            test.fail("<details>"+"<summary>"+"<b>"+"<font " +
                    "color="+"red>"+"Excepcion Ocurred: Click to see"
                    +"</font>"+"</b>"+"</summary>"+
                    exceptionMessage.replaceAll(",","<br>")+"\n");

            /*try {
                test.fail("<b>"+"<font color ="+"red>"+
                "Screenshot of failure"+"</font>"+"</b>"
                ,MediaEntityBuilder.createScreenCaptureFromPath());
            }catch (IOException e){}*/

            String logTest = "TEST CASE FAILED";
            Markup m = MarkupHelper.createLabel(logTest, ExtentColor.RED);
            test.log(Status.FAIL, m);

        } else if (result.getStatus() == ITestResult.SKIP) {


            String methoName = result.getMethod().getMethodName();

            String logTest = "<b>"+"TEST CASE: - "+methoName.toUpperCase()+"  SKIP"+"</b>";

            Markup m = MarkupHelper.createLabel(logTest, ExtentColor.YELLOW);
            test.skip(m);

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            String methoName = result.getMethod().getMethodName();

            String logTest = "<b>"+"TEST CASE: - "+methoName.toUpperCase()+"  PASSED"+"</b>";

            Markup m = MarkupHelper.createLabel(logTest, ExtentColor.GREEN);
            test.pass(m);
        }
    }

}