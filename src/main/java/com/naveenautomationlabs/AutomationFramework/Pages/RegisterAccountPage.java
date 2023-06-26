package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class RegisterAccountPage extends TestBase {
	public RegisterAccountPage() {

		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-firstname")
	private WebElement firstNameField;

	@FindBy(css = "#input-lastname")
	private WebElement lastNameField;

	@FindBy(css = "#input-email")
	private WebElement emailField;

	@FindBy(css = "#input-telephone")
	private WebElement telephoneField;

	@FindBy(css = "#input-password")
	private WebElement passwordField;

	@FindBy(css = "#input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(css = "div.pull-right >input:first-of-type")
	private WebElement policyField;

	@FindBy(css = "div.pull-right:nth-of-type(1) input:last-of-type")
	private WebElement submitButton;



	public void fillFirstName(String name) {
		firstNameField.sendKeys(name);

	}

	public void filllastName(String name) {
		lastNameField.sendKeys(name);

	}

	public void fillemail(String name) {
		emailField.sendKeys(name);

	}

	public void fillPassword(String password) {
		passwordField.sendKeys(password);

	}

	public void filltelephone(String password) {
		telephoneField.sendKeys(password);

	}

	public void fillConfirmPassword(String password) {
		confirmPasswordField.sendKeys(password);

	}

	public void clickPolicy() {

		policyField.click();
	}

	public YourAccountCreatedPage submitButton() {

		submitButton.submit();
		return new YourAccountCreatedPage();
	}



}
