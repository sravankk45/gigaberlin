package com.gigaberlin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMapsPage {
	
	//Page Factory
	
			@FindBy(id="searchboxinput")
			WebElement serachTextBox;
			
			@FindBy(id="searchbox-searchbutton")
			WebElement searchButton;
			
			//Initializing the Page Objects:
			public GoogleMapsPage(WebDriver driver){
				PageFactory.initElements(driver, this);
			}
			
			public void enterCoordinates(String coordinates) {
				serachTextBox.sendKeys(coordinates);
				
			}
			public void clickSearchButton() {
				searchButton.click();
			}
			

}
