package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AccountLogout extends TestBase {

	public AccountLogout() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css="#content > h1")
	WebElement accountLogoutMsg;

	

	public String getAccountLogoutMsg() {
		return accountLogoutMsg.getText();
	}
	
	
}
