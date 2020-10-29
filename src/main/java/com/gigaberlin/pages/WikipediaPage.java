package com.gigaberlin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gigaberlin.base.TestBase;

public class WikipediaPage{
	
		//Page Factory
	
		@FindBy(id="searchInput")
		WebElement serachTextBox;
		
		@FindBy(xpath="//i[contains(text(),'Search')]")
		WebElement wikiSearchButton;
		
		
		//Initializing the Page Objects:
		public WikipediaPage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		
		public void enterText(String searchString) {
			serachTextBox.sendKeys(searchString);
		}
		public void clickSearchButton() {
			wikiSearchButton.click();
		}
		

}
