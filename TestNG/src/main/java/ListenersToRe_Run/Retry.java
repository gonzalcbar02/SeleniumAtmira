package ListenersToRe_Run;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class Retry implements IRetryAnalyzer {

	private int retrycount = 0;
	private int maxretyrcount = 2;

	@Override
	public boolean retry(final ITestResult result) {
		if (retrycount < maxretyrcount){
				System.out.println("Retrying test " + result.getName() + " with status "
						+ getResultStatusName(result.getStatus()) + " for the " + (retrycount+1) + " time(s).");
				retrycount++;
				return true;
		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;

		if(status==1)
			resultName = "SUCCESS";

		if(status==2)
			resultName = "FAILURE";

		if(status==3)
			resultName = "SKIP";

		return resultName;
	}
}
