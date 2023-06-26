package com.naveenautomationlabs.AutomationFramework.Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;



public class YourAccountCreatedPage extends TestBase {
	 public YourAccountCreatedPage() {
		
		PageFactory.initElements(wd, this);
	}
	 @FindBy(css="#content p:first-of-type")
	 private WebElement header;
	 
	 public String getText() {
		
		return header.getText();
	 }
}
