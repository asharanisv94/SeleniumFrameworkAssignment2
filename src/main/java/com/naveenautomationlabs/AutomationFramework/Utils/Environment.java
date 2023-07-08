package com.naveenautomationlabs.AutomationFramework.Utils;

public enum Environment {
	DEV("Dev","://naveenautomationlabs.com/opencart/index.php?route=common/home"),
	STAGE("Stage","https://naveenautomationlabs.com/opencart/index.php?route=common/home"),
	QA("qa","https://naveenautomationlabs.com/opencart/index.php?route=common/home"),
	PROD("Production","https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	
	String env;
	String url;

	private Environment(String env,String URL) {
		this.env = env;
		this.url= URL;
	}

	public String getEnv() {
		return env;
	}

	public String getUrl() {
		
		return url;
	}

	


}
