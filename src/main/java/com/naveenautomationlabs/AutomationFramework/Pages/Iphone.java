package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Iphone extends TestBase {

	public Iphone() {
		PageFactory.initElements(wd, this);
	}

	

	@FindBy(css = "button[id=button-cart]")
	private WebElement addToCartButton  ;
	
	@FindBy(css="#product-product > div.alert.alert-success.alert-dismissible")
	private WebElement successBanner;

	

	public Iphone clickaddToCartButton() {
		addToCartButton.click();
		return new Iphone();
	}
		
		public String getSuccessMsg() {
			return successBanner.getText();
		
		}
	}