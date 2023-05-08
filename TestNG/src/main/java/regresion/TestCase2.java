package regresion;

import org.example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2  extends BaseTest {

    @Test
    public void validateTitles(){
        System.out.println("Beginning");

        String expected_title = "Yahoo.com"; //excel
        String actual_title = "Gmail.com"; //selenium

        /*if(expected_title.equalsIgnoreCase(actual_title)){System.out.println("Test case pass.");}
        else{System.out.println("Test case fail.");}*/

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Validating title");
        softAssert.assertEquals(expected_title, actual_title);
//        Assert.fail("Failing the test as the condition is not met");
//        Assert.assertTrue(false, "Element not found");

        System.out.println("Validating image");
        softAssert.assertEquals(true, false);

        System.out.println("Validating text box presence");
        softAssert.assertEquals(true, false ,"Text box not present");

        softAssert.assertAll();

        System.out.println("Ending");

    }

}
