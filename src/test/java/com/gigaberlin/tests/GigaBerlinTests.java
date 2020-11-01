package com.gigaberlin.tests;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.gigaberlin.base.TestBase;
import com.gigaberlin.pages.GigaBerlinPage;
import com.gigaberlin.pages.GoogleMapsPage;
import com.gigaberlin.pages.GooglePage;
import com.gigaberlin.pages.WikipediaPage;
import com.gigaberlin.utilities.Utilities;

public class GigaBerlinTests extends TestBase{
	
	private GooglePage googlePage;
	private WikipediaPage wikipediaPage;
	private GigaBerlinPage gigaBerlinPage;
	private Utilities utilities;
	private GoogleMapsPage googleMapsPage;


	public GigaBerlinTests() {
		super();
	}
	
	@BeforeSuite
	public void beforeSuite() {
		utilities=new Utilities();
		utilities.deleteScreesnhotFolder();
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
		
		
	    String testName=method.getName();
	    utilities.takeScreenshots(driver, testName);
	    driver.switchTo().frame(0);
	    
	    googlePage.clickContinue();
		googlePage.enterText(getGoogleSearchString());
		googlePage.clickSearchButton();
		utilities.takeScreenshots(driver, testName);
		
		googlePage.clickWikiLink();
		wikipediaPage.enterText(getWikiSearchString());
		utilities.takeScreenshots(driver, testName);
		
		wikipediaPage.clickSearchButton();
		utilities.takeScreenshots(driver, testName);
		
		String coordinates=gigaBerlinPage.getCoordinates();
		
		utilities.openNewTab(driver);
		driver.get(getGoogleMapsUrl());
		utilities.takeScreenshots(driver, testName);
		
		googleMapsPage.enterCoordinates(coordinates);
		utilities.takeScreenshots(driver, testName);
		
		googleMapsPage.clickSearchButton();
		utilities.takeScreenshots(driver, testName);
	    
	    String address=googleMapsPage.getAddress();
	    boolean addressCheckFlag=address.contains("15537");
	    Assert.assertTrue(addressCheckFlag, "Address Verfied Successfully");
	  
	}
	
	@AfterTest
	public void tearDown() {
	driver.quit();
		
	}
	
}
