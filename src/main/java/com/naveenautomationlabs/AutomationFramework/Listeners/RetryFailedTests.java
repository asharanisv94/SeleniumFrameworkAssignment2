package com.naveenautomationlabs.AutomationFramework.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer{

	int maxCounter = 2;
	int counter = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test !!!!! " + result.getMethod().getMethodName() + " for " + counter + " times");
		if(counter < maxCounter) {
			counter++;
			return true;
		}
		return false;
	}
}