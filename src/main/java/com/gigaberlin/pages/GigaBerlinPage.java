package com.gigaberlin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GigaBerlinPage {
	
	@FindBy(xpath="//*[@class='geo-dec']")
	WebElement coordinates;
	
	//Initializing the Page Objects:
			public GigaBerlinPage(WebDriver driver){
				PageFactory.initElements(driver, this);
			}
			
			public String getCoordinates() {
				return coordinates.getText();
			}
}
