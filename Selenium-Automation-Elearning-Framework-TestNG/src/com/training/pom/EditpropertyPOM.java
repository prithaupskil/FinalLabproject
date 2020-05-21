package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditpropertyPOM {
	private WebDriver driver; 
	public EditpropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//h1[@class='wp-heading-inline']")
	public WebElement editprop;
	
		@FindBy(linkText="View post")
		public WebElement viewPost; 
		
		@FindBy(xpath="//p[contains(text(),'Post published.')]")
		public WebElement postPublished; 
		
		@FindBy(xpath="//div[@class='updated notice notice-success is-dismissible']//p")
		public WebElement publishmessage;
		
		

}
