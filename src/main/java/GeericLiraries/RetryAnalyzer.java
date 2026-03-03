package GeericLiraries;



	import org.testng.IRetryAnalyzer;
	import org.testng.ITestResult;

	public class RetryAnalyzer implements IRetryAnalyzer {

	    int Count = 0;
	    int maxRetryCount = 5;   // number of retries

	    @Override
	    public boolean retry(ITestResult result) {

	        if (Count < maxRetryCount) {
	            Count++;
	            return true;   // re-run the failed test
	        }
	        return false;      // stop retrying
	    }
	}

