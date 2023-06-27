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
	private WebElement addToWishListButton  ;
	
	@FindBy(css="#product-product > div.alert.alert-success.alert-dismissible")
	private WebElement successBanner;

	

	public Macbook clickaddToWishListButton() {
		addToWishListButton.click();
		return new Macbook();
	}
		
		public String getSuccessMsg() {
			return successBanner.getText();
		}
		
		
		public String getTitle() {
			return wd.getTitle();
		
		}
		
		
		@FindBy(xpath = "//*[@id=\"wishlist-total\"]/span")
		private WebElement wishList;

		
		public String getwishTotalCount() throws InterruptedException {

			String itemText = wishList.getText();
			String itemsInArray[] = itemText.split("\\(");
			String[] total = itemsInArray[1].split("\\)");
			return total[0];
		}

		
	}
