package parameterization;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dp1")
    public void testLogin(String user, String pass){
        System.out.println(user+"-----------"+pass );
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dp1")
    public void testUserReg(String fname, String lname, String email){
        System.out.println(fname+"-----------"+lname+"---------"+email );
    }

}
