package com.naveenautomationlabs.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.AutomationFramework.Listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	private FileInputStream fileInputStream;
	private Properties prop;
	public static Logger logger;
	private WebdriverEvents events;
	private EventFiringWebDriver eDriver;

	public TestBase() {
		prop = new Properties();
		try {
			fileInputStream = new FileInputStream(
					"C:\\Users\\asha\\eclipse-workspace\\FromClass\\Automation-Framework2\\src\\main\\java\\com\\naveenautomationlabs\\AutomationFramework\\Config\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);

	}

	public void intialisation() {
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
			wd = WebDriverManager.chromedriver().create();
			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefox":
			wd = WebDriverManager.firefoxdriver().create();
			break;
		default:
			System.out.println("Not a valid browser name");
			break;
		}
		
		events = new WebdriverEvents();

		eDriver = new EventFiringWebDriver(wd);
				
		eDriver.register(events);
		wd = eDriver;

		wd.get(prop.getProperty("URL"));
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT")), TimeUnit.SECONDS);
		wd.manage().window().maximize();
	}

	public void tearDown() {
		wd.quit();
	}
}