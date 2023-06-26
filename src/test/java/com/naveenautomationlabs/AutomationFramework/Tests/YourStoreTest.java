package com.naveenautomationlabs.AutomationFramework.Tests;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogout;
import com.naveenautomationlabs.AutomationFramework.Pages.Iphone;
import com.naveenautomationlabs.AutomationFramework.Pages.Macbook;
import com.naveenautomationlabs.AutomationFramework.Pages.Monitors;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.RegisterAccountPage;
import com.naveenautomationlabs.AutomationFramework.Pages.Search_Iphone;
import com.naveenautomationlabs.AutomationFramework.Pages.Search_Macbook;
import com.naveenautomationlabs.AutomationFramework.Pages.YourAccountCreatedPage;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStoreTest extends TestBase {

	YourStore yourStore;
	AccountLogin accountLogin;
	MyAccount myAccount;
	Search_Iphone search_Iphone;
	Iphone iphone;
	Search_Macbook search_Macbook;
	Macbook macbook;
	Monitors monitors;
	RegisterAccountPage registeraccount;
	YourAccountCreatedPage yourAccountCreatedPage;
	AccountLogout accountLogout;

	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();

	}

	// Validate Login Using Valid Credentials
	@Test
	public void validateLoginUsingValidCredentials() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal();
		Assert.assertEquals(myAccount.getMyAccountText(), "My Account");
	}

	// Verify if Monitors page is loaded
	@Test
	public void validateMonitorsPageIsLoaded() {
		yourStore.clickComponentBtn();
		monitors = yourStore.clickMonitorsBtn();
		Assert.assertEquals(monitors.getMonitorText(), "Monitors");

	}

	// Validate Login Using InValid Credentials
	@Test
	public void validateLoginUsingInValidCredentials() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		accountLogin.enterEmail();
		accountLogin.enterPassword("incorrectpassword");
		accountLogin.loginToPortal();
		Assert.assertEquals(accountLogin.getAccountLoginWarningText(),
				"Warning: No match for E-Mail Address and/or Password.");
	}

	// search iphone and add to Cart
	@Test
	public void validateIPhoneAddedToCartSuccessfully() {
		yourStore.searchInput("iphone");
		search_Iphone = yourStore.clickiphoneSearchBtn();
		iphone = search_Iphone.clickProductLink();
		iphone.clickaddToCartButton();
		iphone.getSuccessMsg();
		Assert.assertEquals(iphone.getSuccessMsg().contains("Success: You have added iPhone to your shopping cart"),
				true);
	}

	// search macbook and add to Wishlist
	@Test
	public void validateMacBookAddedToWishListSuccessfully() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal();

		yourStore.searchInput("macbook");
		yourStore.clickmacbookSearchBtn();

		search_Macbook.clickProductLink();
		macbook.clickaddToCartButton();
		macbook.getSuccessMsg();
		Assert.assertEquals(iphone.getSuccessMsg(), "Success: You have added MacBook to your !");
	}

	
	//Validate if user can register successfully
	@Test
	public void validateRegistrationSuccess() {
		yourStore.clickMyAccountBtn();
		registeraccount = yourStore.clickregisterButton();
		registeraccount.fillFirstName("Sherin");
		registeraccount.filllastName("Arun");
		Random r = new Random();
		registeraccount.fillemail("testid" + r.nextInt(5000) + "@gmail.com");
		registeraccount.filltelephone("485785465");
		registeraccount.fillPassword("password2");
		registeraccount.fillConfirmPassword("password2");
		registeraccount.clickPolicy();
		yourAccountCreatedPage = registeraccount.submitButton();

		Assert.assertEquals(yourAccountCreatedPage.getText(),
				"Congratulations! Your new account has been successfully created!", "Texts  match");

	}
	@Test(priority=1)
	public void validateNavigationInRegistrationPage() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal();
		accountLogout=myAccount.validateNavigativeSideBarClick("Logout");			
		Assert.assertEquals(accountLogout.getAccountLogoutMsg(), "Account Logout");
	}
	
	@Test
	public void validateIfCorrectProductIsClicked() {
		macbook=yourStore.clickAProduct("MacBook");			
		Assert.assertEquals(macbook.getTitle(), "MacBook");
	}

	@Test
	public void validateSlider() {
		Set<String> actualSet = new HashSet<String>();
		actualSet=yourStore.sliderSelection();
		System.out.println(actualSet.toString());	

	}

	
	
	@AfterMethod
	public void quit() {
		tearDown();
	}

}
