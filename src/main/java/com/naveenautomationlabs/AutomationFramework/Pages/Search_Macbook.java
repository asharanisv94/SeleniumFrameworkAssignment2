package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Search_Macbook extends TestBase {

	public Search_Macbook() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath= "//a[text()='MacBook']")
	
	WebElement productLink;

	

	public Macbook clickProductLink() {
		productLink.click();
		return new Macbook();
		}

	
	}
