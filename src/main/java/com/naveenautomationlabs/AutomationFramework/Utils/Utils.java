package com.naveenautomationlabs.AutomationFramework.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Utils extends TestBase {

	public static void takeScreenShot(String testName) {
		//Time stamp
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

		//Take screenshot
		File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		
		//Save screenshot
		try {
		FileUtils.copyFile(screenshotFile, new File("./FailedTestsScreenShots\\" + "_" + testName + "_" + timeStamp + ".jpg"));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}