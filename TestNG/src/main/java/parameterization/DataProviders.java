package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviders {

    @DataProvider(name = "dp1")
    public static Object[][] getData(Method m){

        Object[][] data = null;

        if(m.getName().equals("testLogin")){

            data = new Object[2][2];
            data[0][0] = "Raman";
            data[0][1] = "djgkdgajdas";

            data[1][0] = "Rahul";
            data[1][1] = "asdadasdsad";

        }else if(m.getName().equals("testUserReg")){

            data = new Object[2][3];
            data[0][0] = "Raman";
            data[0][1] = "djgkdgajdas";
            data[0][2] = "djgkdgajdas@gmail.com";

            data[1][0] = "Rahul";
            data[1][1] = "asdadasdsad";
            data[1][2] = "asdadasdsad@gmail.com";

        }


        return data;
    }

    /*@DataProvider(name = "dp2")
    public static Object[][] getData2(){

        Object[][] data = new Object[2][3];

        data[0][0] = "Raman";
        data[0][1] = "djgkdgajdas";
        data[0][2] = "djgkdgajdas@gmail.com";

        data[1][0] = "Rahul";
        data[1][1] = "asdadasdsad";
        data[1][2] = "asdadasdsad@gmail.com";

        return data;
    }*/

}
