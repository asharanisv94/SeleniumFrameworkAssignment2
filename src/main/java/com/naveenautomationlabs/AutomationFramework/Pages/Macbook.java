package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Macbook extends TestBase {

	public Macbook() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content > div > div.col-sm-4 > div.btn-group > button:nth-child(1) > i")
	WebElement addToWishListButton  ;
	
	@FindBy(css="#product-product > div.alert.alert-success.alert-dismissible")
	WebElement successBanner;

	

	public Macbook clickaddToCartButton() {
		addToWishListButton.click();
		return new Macbook();
	}
		
		public String getSuccessMsg() {
			return successBanner.getText();
		
		}
		
		public String getTitle() {
			return wd.getTitle();
		
		}
	}
