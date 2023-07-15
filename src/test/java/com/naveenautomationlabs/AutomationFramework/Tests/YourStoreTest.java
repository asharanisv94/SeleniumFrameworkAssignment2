package com.naveenautomationlabs.AutomationFramework.Tests;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogout;
import com.naveenautomationlabs.AutomationFramework.Pages.Iphone;
import com.naveenautomationlabs.AutomationFramework.Pages.Macbook;
import com.naveenautomationlabs.AutomationFramework.Pages.Monitors;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.MyWishList;
import com.naveenautomationlabs.AutomationFramework.Pages.MyWishList.MyWishListTableHeader;
import com.naveenautomationlabs.AutomationFramework.Pages.RegisterAccountPage;
import com.naveenautomationlabs.AutomationFramework.Pages.Search_Iphone;
import com.naveenautomationlabs.AutomationFramework.Pages.Search_Macbook;
import com.naveenautomationlabs.AutomationFramework.Pages.YourAccountCreatedPage;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.Utils.ExcelUtils;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStoreTest extends TestBase {

	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private Search_Iphone search_Iphone;
	private Iphone iphone;
	private Search_Macbook search_Macbook;
	private Macbook macbook;
	private Monitors monitors;
	private RegisterAccountPage registeraccount;
	private YourAccountCreatedPage yourAccountCreatedPage;
	private AccountLogout accountLogout;
	private MyWishList wishList;

//	@Parameters({ "browser" })
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
		Assert.assertEquals(myAccount.getMyAccountText(), "My Account", "Login failed");
	}

	// Verify if Monitors page is loaded
	
	@Test
	public void validateMonitorsPageIsLoaded() {
		yourStore.clickComponentBtn();
		monitors = yourStore.clickMonitorsBtn();
		Assert.assertEquals(monitors.getMonitorText(), "Monitors", "Incorrect page loaded");

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
				"Warning: No match for E-Mail Address and/or Password.", "invalid");
	}

	// search iphone and add to Cart
	@Test
	public void validateIPhoneAddedToCartSuccessfully() {
		yourStore.searchInput("iphone");
		search_Iphone = yourStore.clickiphoneSearchBtn();
		iphone = search_Iphone.clickProductLink();
		iphone.clickaddToCartButton();
		iphone.getSuccessMsg();

		boolean actual = iphone.getSuccessMsg().contains("Success: You have added iPhone to your shopping cart");

		Assert.assertEquals(actual, true, " Unable to add to shopping cart");
	}

	// search macbook and add to Wishlist
	
	@Test
	public void validateMacBookAddedToWishListSuccessfully() throws InterruptedException {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal();

		yourStore.searchInput("macbook");
		search_Macbook = yourStore.clickmacbookSearchBtn();

		macbook = search_Macbook.clickProductLink();
		macbook.clickaddToWishListButton();
		macbook.getSuccessMsg();

		Thread.sleep(1000);
		String actualCount = macbook.getwishTotalCount();

		Assert.assertEquals(actualCount, "1", "Wrong Count");

	}

	// Validate if user can register successfully
	@Test
	public void validateRegistrationSuccess() {
		yourStore.clickMyAccountBtn();
		registeraccount = yourStore.clickregisterButton();
		registeraccount.fillFirstName("Anu");
		registeraccount.filllastName("Manu");
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

	// Validate if an option in navigation List button is clicked
	@Test(priority = 1)
	public void validateNavigationInRegistrationPage() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal();
		accountLogout = myAccount.validateNavigativeSideBarClick("Logout");
		Assert.assertEquals(accountLogout.getAccountLogoutMsg(), "Account Logout", "Incorrect page loaded");
	}

	// Validate if correct product is clicked
	@Test
	public void validateIfCorrectProductIsClicked() {
		macbook = yourStore.clickAProduct("MacBook");
		Assert.assertEquals(macbook.getTitle(), "MacBook", "Incorrect page");
	}

	// Slider
	
	@Test
	public void validateSlider() {

		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("Sony");
		expectedSet.add("Harley Davidson");
		expectedSet.add("Dell");
		expectedSet.add("Canon");
		expectedSet.add("Nintendo");
		expectedSet.add("Disney");
		expectedSet.add("NFL");
		expectedSet.add("Coca Cola");
		expectedSet.add("RedBull");
		expectedSet.add("Starbucks");
		expectedSet.add("Burger King");

		Set<String> actualSet = new HashSet<String>();
		actualSet = yourStore.sliderSelection();
		System.out.println(actualSet);

		Assert.assertEquals(actualSet, expectedSet, "Slider values doesnot match with Expected values");

	}

	// Add 4 items in checklist and validate Wishlist count

	@Test
	public void validateWishListCount() throws InterruptedException {

		int numberofItemsforWishlist = 4;
		String actualTotalWishlistCount = yourStore.getwishTotal(numberofItemsforWishlist);
		Assert.assertEquals(actualTotalWishlistCount, String.valueOf(numberofItemsforWishlist), "Incorrect count");

	}

	@Test
	public void validateUnitPrice() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal();
		wishList = myAccount.clickWishListBtn();

		WebElement element = wishList.getCellElementFromTable(MyWishListTableHeader.UNIT_PRICE, "Product 3");
		System.out.println(element.getText());
	}
	
	
	@Test(dataProvider = "login_data")
	public void validateLogin(String username, String Password) {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		accountLogin.enterEmail(username);
		accountLogin.enterPassword(Password);
		accountLogin.clickLoginBtn();
		Assert.assertEquals(wd.getTitle(), "My Account", "wrong page");
	}

	@DataProvider(name = "login_data")
	public String[][] getDataFromExcelSheet() throws Exception {
		String filePath = "C:\\Users\\asha\\Desktop\\Datasheet.xlsx";
		int rowCnt = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCnt = ExcelUtils.getCellCount(filePath, "Sheet1", rowCnt);
		String[][] virtualSheet = new String[rowCnt][colCnt];
		for (int i = 1; i <= rowCnt; i++) {
			for (int j = 0; j < colCnt; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}
		return virtualSheet;
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
