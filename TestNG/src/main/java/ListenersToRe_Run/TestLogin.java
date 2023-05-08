package ListenersToRe_Run;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {

    @Test(priority = 1)
    public void doLogin(){
        System.out.println("Executing Login Test");
    }

    static int count = 0;
    @Test(priority = 2, retryAnalyzer = Retry.class)
    public void registerUsers(){
        count++;
        System.out.println(count);
        Assert.fail("Executing failed while Registering a user");
    }

}
