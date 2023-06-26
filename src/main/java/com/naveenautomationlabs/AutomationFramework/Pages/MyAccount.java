package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccount extends TestBase {

	public MyAccount() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content>h2:first-of-type")
	WebElement myAccountText;

	@FindBy(xpath = "//div[@class='list-group']//a")
	List<WebElement> navigationListElements;

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public AccountLogout validateNavigativeSideBarClick(String navigationMenuName) {
		for (int i = 0; i < navigationListElements.size(); i++) {
			if (navigationListElements.get(i).getText().equals(navigationMenuName)) {
				navigationListElements.get(i).click();
			}
		}
		return new AccountLogout();
	}
}