package com.gigaberlin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	
		//Page Factory
	
		@FindBy(xpath="//*[@class='gLFyf gsfi']")
		WebElement serachTextBox;
		
		@FindBy(xpath="//div[contains(@class,'FPdoLc')]/center/input[@name='btnK']")
		WebElement googleSearchButton;
		
		@FindBy(xpath="//a[@href='https://www.wikipedia.org/']")
		WebElement clickWikiLink;
		
		
		//Initializing the Page Objects:
		public GooglePage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		
		public void enterText(String searchString) {
			serachTextBox.sendKeys(searchString);
			 
		}
		public void clickSearchButton() {
			googleSearchButton.click();
			
			
		}
		public void clickWikiLink() {
			clickWikiLink.click();
		}

}
