package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;


public class Search_Iphone extends TestBase {

	public Search_Iphone() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css= "#content > div:nth-child(8) > div > div > div:nth-child(2) > div.caption > h4 > a")
	private WebElement productLink  ;

	
	public Iphone clickProductLink() {
		productLink.click();
		return new Iphone();
		}

	
	}

	
	


