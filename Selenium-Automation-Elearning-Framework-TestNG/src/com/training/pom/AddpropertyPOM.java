package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddpropertyPOM {
	private WebDriver driver; 
	public AddpropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath="//h1[@class='wp-heading-inline']")
		public WebElement Addproppagetitle; 
		
		@FindBy(xpath="//input[@id='title']")
		public WebElement Title; 
		
		@FindBy(xpath="//textarea[@id='content']")
		public WebElement Content;
		
		//@FindBy(xpath="//input[@id='publish']")
		//public WebElement Publish;
		
		@FindBy(xpath="//input[@class='button button-primary button-large']")
		public WebElement Publish;
		
		@FindBy(xpath="//body[contains(@class,'post-new-php admin-bar post-type-property branch-4-9 version-4-9-5 admin-color-fresh locale-en-us customize-support browser-chrome major-4 sticky-menu svg')]//div//div//div//div[2]//div[1]//div[4]//h2[1]//span[1]")
public WebElement featureproperty;
		
		@FindBy(xpath="//body[contains(@class,'post-new-php admin-bar post-type-property branch-4-9 version-4-9-5 admin-color-fresh locale-en-us customize-support browser-chrome major-4 sticky-menu svg')]//div//div//div//div[2]//div[1]//div[3]//h2[1]//span[1]")
		public WebElement feature;
		
		@FindBy(xpath="//label[contains(text(),'Abaytest44')]/input[@type='checkbox']")
		public WebElement featurecheckbox;
		
		@FindBy(xpath="//input[@id='in-region-57' and @type='checkbox']")
		public WebElement regioncheckbox;
				
			
		//body[contains(@class,'post-new-php admin-bar post-type-property branch-4-9 version-4-9-5 admin-color-fresh locale-en-us customize-support browser-chrome major-4 sticky-menu svg')]/div/div/div/div/div[contains(@class,'wrap')]/form/div/div[contains(@class,'metabox-holder columns-2')]/div[contains(@class,'postbox-container')]/div[contains(@class,'meta-box-sortables ui-sortable')]/div[3]/div[1]/div[1]/div[2]/ul[1]/li[1]/label[1]
		//input[@id='in-property_feature-1151'] 
		//@FindBy(xpath="//input[@id='in-property_feature-1141']")
		
		//div[contains(@class,'postbox-container')]//div[3]//div[1]//div[1]//div[2]//ul[1]//li[27]//label[contains(text),'pritha44']
		//div[contains(@class,'postbox-container')]//div[3]//div[1]//div[1]//div[2]//ul[1]//li[27]//label[1]
				

}
