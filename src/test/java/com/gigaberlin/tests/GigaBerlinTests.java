package com.gigaberlin.tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.gigaberlin.base.TestBase;
import com.gigaberlin.pages.GigaBerlinPage;
import com.gigaberlin.pages.GoogleMapsPage;
import com.gigaberlin.pages.GooglePage;
import com.gigaberlin.pages.WikipediaPage;
import com.gigaberlin.utilities.Screenshots;

public class GigaBerlinTests extends TestBase{
	
	private GooglePage googlePage;
	private WikipediaPage wikipediaPage;
	private GigaBerlinPage gigaBerlinPage;
	private Screenshots screenshots;
	private GoogleMapsPage googleMapsPage;

	public GigaBerlinTests() {
		super();
	}
	
	@BeforeSuite
	public void beforeSuite() {
		screenshots=new Screenshots();
		screenshots.deleteScreesnhotFolder();
	}
	@BeforeTest
	public void setUp() {
		googlePage=new GooglePage(driver);
		wikipediaPage=new WikipediaPage(driver);
		gigaBerlinPage=new GigaBerlinPage(driver);
		googleMapsPage=new GoogleMapsPage(driver);
		driver.get(getBaseUri());
		
	}
	
	@Test
	public void gigaBerlinLocationTest(Method method) throws Exception{
		
		Thread.sleep(10000);
	    String testName=method.getName();
	    screenshots.takeScreenshots(driver, testName);
	    
		googlePage.enterText(getGoogleSearchString());
		googlePage.clickSearchButton();
	    screenshots.takeScreenshots(driver, testName);
		
		googlePage.clickWikiLink();
		wikipediaPage.enterText(getWikiSearchString());
	    screenshots.takeScreenshots(driver, testName);
		
		wikipediaPage.clickSearchButton();
	    screenshots.takeScreenshots(driver, testName);
		
		String coordinates=gigaBerlinPage.getCoordinates();
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(getGoogleMapsUrl());
	    screenshots.takeScreenshots(driver, testName);
		
		googleMapsPage.enterCoordinates(coordinates);
	    screenshots.takeScreenshots(driver, testName);
		
		googleMapsPage.clickSearchButton();
	    screenshots.takeScreenshots(driver, testName);
		
	}
	
	@AfterTest
	public void tearDown() {

	driver.quit();
		
	}
	
}
