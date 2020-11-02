package com.gigaberlin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMapsPage {
	
	//Page Factory
	
			@FindBy(id="searchboxinput")
			private WebElement serachTextBox;
			
			@FindBy(id="searchbox-searchbutton")
			private WebElement searchButton;
			
			@FindBy(xpath="//span[contains(text(),'15537 Grünheide')]")
			private WebElement addressElement;
			
			@FindBy(xpath="//span[contains(text(),'CR22+22 Grünheide (Mark)')]")
			private WebElement plusCodeElement;
			
			private JavascriptExecutor jse;
			private  WebDriverWait wait;
			
			
			//Initializing the Page Objects:
			public GoogleMapsPage(WebDriver driver){
				PageFactory.initElements(driver, this);
				jse = (JavascriptExecutor)driver;
				wait = new WebDriverWait(driver,30);
				
			}
			
			public void enterCoordinates(String coordinates) {
				serachTextBox.sendKeys(coordinates);
				
			}
			public void clickSearchButton() {
				
				jse.executeScript("arguments[0].click()", searchButton);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'15537 Grünheide')]")));
			}
			public String getAddress() {
				String address=addressElement.getText();
				return address;
			}
			public String getPlusCode() {
				String plusCode=plusCodeElement.getText();
				return plusCode;
			}
			
			

}
