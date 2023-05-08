package CustomListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Passed test -- "+result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // C:\Users\GONZALO.ALCAIDE\Desktop\Proyectos\CaptureElementScreenshot\screenshot.jpg
        System.setProperty("org.uncommons.reportng.escape-output","false");
        Reporter.log("<a href=\"C://Users//GONZALO.ALCAIDE//Desktop//Proyectos//CaptureElementScreenshot//screenshot//below.jpg\"> Screenshot link </a>");
        System.out.println("Capturing Screenshot for the failed test -- "+result.getTestName());
    }
}
