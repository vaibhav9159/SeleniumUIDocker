package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	
	int counter = 0;
	int retryAttempts = 2;
	
@Override
public boolean retry(ITestResult result) {
	
	while(counter<retryAttempts)
	{	counter ++;
		return true;
	}
	return false;
}

}