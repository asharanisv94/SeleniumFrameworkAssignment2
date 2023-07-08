package com.naveenautomationlabs.AutomationFramework.Utils;

public enum Browsers {
	CHROME ("Chrome"),
	EDGE("Edge"),
	FIREFOX("Firefox"),
	SAFARI("Safari");
	
	
	String browserName;
	
	Browsers(String nameOfBrowser){
		browserName=  nameOfBrowser;
	}

	public String getBrowserName() {
		return browserName;
	}

	
	}


