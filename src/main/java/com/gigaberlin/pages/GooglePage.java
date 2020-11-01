package com.gigaberlin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	
		//Page Factory
	
		@FindBy(xpath="//*[@class='gLFyf gsfi']")
		private WebElement serachTextBox;
		
		@FindBy(xpath="//div[contains(@class,'FPdoLc')]/center/input[@name='btnK']")
		private WebElement googleSearchButton;
		
		@FindBy(xpath="//a[@href='https://www.wikipedia.org/']")
		private WebElement clickWikiLink;
		
		@FindBy(xpath="//span[contains(text(),'Ich stimme zu')]")
		private WebElement clickAgreeButton;
		
		private  WebDriverWait wait;
		
		
		//Initializing the Page Objects:
		public GooglePage(WebDriver driver){
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver,30);
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
		
		public void clickContinue() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Ich stimme zu')]")));
			clickAgreeButton.click();
		}
}
