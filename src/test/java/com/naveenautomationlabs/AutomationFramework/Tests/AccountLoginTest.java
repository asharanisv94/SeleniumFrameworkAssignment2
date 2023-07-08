package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.ForgotYourPassword;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.Utils.Utils;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AccountLoginTest extends TestBase {

	YourStore yourStore;
	AccountLogin accountLogin;
	ForgotYourPassword forgotYourPassword;

////	@BeforeMethod
//	public void setUp() {
////		Utils.takeScreenShot();
////		intialisation();
//		yourStore = new YourStore();
//	}

	
//	public void validateLoginUsingValidCredentials() {
//		yourStore.clickMyAccountBtn();
//		accountLogin = yourStore.clickLoginBtn();
//		forgotYourPassword = accountLogin.clickForgotPassword();
//		forgotYourPassword.enterEmail();
//		forgotYourPassword.clickContinueBtn();
//		Assert.assertEquals(accountLogin.getPasswordResetLinkSuccessMessageText(),
//				"An email with a confirmation link has been sent your email address.");
//	}

//	@AfterMethod
//	public void quit() {
//		tearDown();
//	}
}
