package com.gigaberlin.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots{
	
	private File scrFile; 
	private String baseDir=System.getProperty("user.dir");
	
	
	public void takeScreenshots(WebDriver driver,String testName) {
	
		  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          long timestamp=  new Date().getTime();
     
		try {
		
			FileUtils.copyFile(scrFile, new File(baseDir + "/screenshots/" + testName + "/" +  timestamp + ".png"));
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	
	}
	
	public void deleteScreesnhotFolder() {
		
		try {
			FileUtils.deleteDirectory(new File(baseDir + "/screenshots"));
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
