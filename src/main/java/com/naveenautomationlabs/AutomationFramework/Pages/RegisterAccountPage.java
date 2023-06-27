package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
		wait.until(ExpectedConditions.visibilityOf(firstNameField));
		firstNameField.sendKeys(name);

	}

	public void filllastName(String name) {
		wait.until(ExpectedConditions.visibilityOf(lastNameField));
		lastNameField.sendKeys(name);

	}

	public void fillemail(String name) {
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.sendKeys(name);

	}

	public void fillPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(password);

	}

	public void filltelephone(String password) {
		wait.until(ExpectedConditions.visibilityOf(telephoneField));
		telephoneField.sendKeys(password);

	}

	public void fillConfirmPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
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
