package com.gigaberlin.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBase{
	
	private static Properties properties;
	protected String baseDir=System.getProperty("user.dir");
	protected static WebDriver driver;
	
	public TestBase() {
		
		try {
			properties=new Properties();
			FileInputStream fileInputStream=new FileInputStream(baseDir+"/src/main/java/com/gigaberlin/config/config.properties");
			System.setProperty("webdriver.chrome.driver", baseDir+"/driver/chromedriver.exe");	
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			properties.load(fileInputStream);
		}
		catch(IOException e) {
		e.printStackTrace();
		}
		
	}
	
	public String getBaseUri() {
		String baseUri=properties.getProperty("baseUri");
		return baseUri;
	}
	public String getGoogleSearchString() {
		String googleSearchString=properties.getProperty("googleSearchString");
		return googleSearchString;
	}
	public String getWikiSearchString() {
		String wikiSearchString=properties.getProperty("wikiSearchString");
		return wikiSearchString;
	}
	public String getGoogleMapsUrl() {
		String googleMapsUrl=properties.getProperty("googleMapsUrl");
		return googleMapsUrl;
	}
}