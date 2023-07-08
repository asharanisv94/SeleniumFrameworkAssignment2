package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccount extends TestBase {

	public MyAccount() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content>h2:first-of-type")
	private WebElement myAccountText;

	@FindBy(xpath = "//div[@class='list-group']//a")
	private List<WebElement> navigationListElements;
	

	@FindBy(css = "ul.list-inline>li:nth-of-type(3)")
	private WebElement wishListBtn;

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public AccountLogout validateNavigativeSideBarClick(String navigationMenuName) {
		if (navigationListElements.size() != 0) {
			for (int i = 0; i < navigationListElements.size(); i++) {
				if (navigationListElements.get(i).getText().equals(navigationMenuName)) {
					navigationListElements.get(i).click();
				}
			}
		} else {
			throw new NoSuchElementException();
		}
		return new AccountLogout();
	}

	public MyWishList clickWishListBtn() {
		wishListBtn.click();
		return  new MyWishList();
	}
}
