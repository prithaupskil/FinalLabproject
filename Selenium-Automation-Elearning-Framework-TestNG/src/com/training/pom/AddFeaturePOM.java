package com.training.pom;

import java.awt.List;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddFeaturePOM {
	private WebDriver driver; 
	public AddFeaturePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//h1[contains(@class,'wp-heading-inline')]")
	public WebElement Pageheading;
	
	
	@FindBy(xpath="//input[@id='tag-name']")
		public WebElement featureName; 
		
		@FindBy(xpath="//input[@id='tag-slug']")
		public WebElement Slug; 
		
		@FindBy(xpath="//textarea[@id='tag-description']")
		public WebElement Description;
		
		@FindBy(id="parent")
		public WebElement featuredropdown; 
		
	
		@FindBy(xpath="//form[@class='validate']//input[@class='button button-primary']")
		public WebElement addFeature;
		
		//@FindBy(xpath="//input[@id='doaction2']")
		@FindBy(xpath="//div[@class='tablenav bottom']//input[@class='button action']")
		public WebElement Apply;
		
		@FindBy(xpath="/table[contains(@class,'wp-list-table widefat fixed striped tags')]")
		//@FindBy(id="the-list")
		public WebElement featureTable;
		
	//	@FindBy(xpath="//div[contains(@class,'wrap nosubsub')]//tbody//tr")
		//public List TableRow;
		
		@FindBy(xpath="//p[@class='search-box']//input[1]")
		public WebElement SearchIP;
		
		@FindBy(xpath="//p[contains(@class,'search-box')]//input[contains(@class,'button')]")
		public WebElement Sbutton; 
		
		@FindBy(xpath="//tbody//tr[1]//td[1]")
		public WebElement Tabledata1;
	@FindBy(xpath="//tbody//tr[1]//td[2]")
	public WebElement Tabledata2;
	@FindBy(xpath="//tbody//tr[1]//td[3]")
	public WebElement Tabledata3;
	@FindBy(xpath="//tbody//tr[2]//td[1]")
	public WebElement Tabledata21;
	@FindBy(xpath="//tbody//tr[2]//td[2]")
	public WebElement Tabledata22;
	@FindBy(xpath="//tbody//tr[2]//td[3]")
	public WebElement Tabledata23;
	@FindBy(xpath="//li[contains(@class,'wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-property')]//li[3]//a[1]")
	public WebElement addproplink;
	@FindBy(id="cb-select-1284")
	public WebElement checkboxfeature;
	@FindBy(id="bulk-action-selector-top")
	
	public WebElement deletedropdown;
	
	@FindBy(xpath="//input[@type='submit' and @id='doaction']")
	public WebElement Applydelete;
	
	

	
		
		

}
