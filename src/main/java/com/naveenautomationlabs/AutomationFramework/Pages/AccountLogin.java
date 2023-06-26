package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AccountLogin extends TestBase {

	public AccountLogin() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(id = "input-password")
	private WebElement passwordInputField;

	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;

	@FindBy(css = "div.form-group a")
	private WebElement forgotPasswordLink;

	@FindBy(css = "div.alert")
	private WebElement passwordResetLinkText;
	
	@FindBy(css = "#account-login > div.alert.alert-danger.alert-dismissible")
	private WebElement accountLoginWarningText;


	
	public void enterEmail() {
		emailInputField.sendKeys("tony@gmail.com");
	}

	public void enterEmail(String email) {
		emailInputField.sendKeys(email);
	}

	public void enterPassword() {
		passwordInputField.sendKeys("Password2");
	}
	
	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	private MyAccount clickLoginBtn() {
		loginBtn.click();
		return new MyAccount();
	}
	
	

	public MyAccount loginToPortal() {
		enterEmail();
		enterPassword();
		return clickLoginBtn();
	}

	public ForgotYourPassword clickForgotPassword() {
		forgotPasswordLink.click();
		return new ForgotYourPassword();
	}

	public String getPasswordResetLinkSuccessMessageText() {
		return passwordResetLinkText.getText();
	}
	public String getAccountLoginWarningText(){
		return accountLoginWarningText.getText();
		
		
	}
	



}
