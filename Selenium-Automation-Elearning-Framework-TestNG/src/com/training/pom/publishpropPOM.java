package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class publishpropPOM {
	private WebDriver driver; 
	public publishpropPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
		//@FindBy(xpath="//div[@class='property-title']")
		public WebElement publishtitle; 
		
		//@FindBy(xpath="//h2[contains(text(),'testtest')]")
		public WebElement Title;
		
		@FindBy(xpath="//h3[@class='desc-headline']")
		public WebElement publishoverview; 
		
		@FindBy(xpath="//div[@class='property-description print-only']//p")
		public WebElement content;		
		

}
