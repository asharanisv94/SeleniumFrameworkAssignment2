package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import com.naveenautomationlabs.AutomationFramework.Utils.Utils;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;
import java.util.*;

public class YourStore extends TestBase {

	public YourStore() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(3) > a")
	private WebElement componentBtn;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li.dropdown.open > div > div > ul > li:nth-child(2) > a")
	private WebElement monitorsBtn;

	public YourStore clickComponentBtn() {

		componentBtn.click();
		return new YourStore();
	}

	public Monitors clickMonitorsBtn() {

		monitorsBtn.click();
		return new Monitors();
	}

	@FindBy(css = "ul.list-inline>li:nth-of-type(2) a")
	private WebElement myAccountBtn;

	@FindBy(css = "ul.dropdown-menu li:nth-of-type(2) a")
	private WebElement loginBtn;

	public RegisterAccountPage clickMyAccountBtn() {
		myAccountBtn.click();
		return new RegisterAccountPage();
	}

	public AccountLogin clickLoginBtn() {
		loginBtn.click();
		return new AccountLogin();
	}

	// To search for iphone and macbook

	@FindBy(css = "#search > input")
	WebElement searchInput;

	@FindBy(css = "#search > span > button")
	WebElement searchButton;

	public void searchInput(String productName) {
		searchInput.sendKeys(productName);
	}

	public Search_Iphone clickiphoneSearchBtn() {
		searchButton.click();
		return new Search_Iphone();
	}

	public Search_Macbook clickmacbookSearchBtn() {
		searchButton.click();
		return new Search_Macbook();
	}

	@FindBy(css = "#carousel0 > div > div:nth-child(10) > img")
	private WebElement BurgerKing;

	@FindBy(css = "#top-links ul:first-of-type ul >li:first-of-type a")
	private WebElement registerButton;

	public RegisterAccountPage clickregisterButton() {
		registerButton.click();
		return new RegisterAccountPage();
	}

	@FindBy(xpath = "//*[@id='content']//h4/a")
	List<WebElement> products;

	public Macbook clickAProduct(String productName) {

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equals(productName)) {
				products.get(i).click();
			}
		}

		return new Macbook();
	}

	@FindBy(xpath = "//*[@id=\"carousel0\"]//div[@class='swiper-slide text-center swiper-slide-next' or @class='swiper-slide text-center swiper-slide-prev' or @class='swiper-slide text-center swiper-slide-active' or @class=\"swiper-slide text-center\"]/img")
	List<WebElement> slides;

	public Set<String> sliderSelection() {
		Set<String> set = new HashSet<String>();
		Actions actions = new Actions(wd);
		System.out.println(slides.size());
		for (int i = 0; i < slides.size(); i++) {
			actions.moveToElement(slides.get(i)).perform();
			System.out.println(slides.get(i).getAttribute("alt"));
			set.add(slides.get(i).getAttribute("alt"));
		}
		return set;
	}
}
