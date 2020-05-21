package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPOM {
	private WebDriver driver; 
	public LogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath="//a[contains(text(),'Real Estate')]")
		public WebElement loginPage; 
		
		@FindBy(xpath="//a[@class='sign-in']")
		public WebElement login; 

}
