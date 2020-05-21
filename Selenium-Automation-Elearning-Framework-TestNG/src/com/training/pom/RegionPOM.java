package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegionPOM {
	private WebDriver driver; 
	
	public RegionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="tag-name")
	public WebElement regionName; 
	
	@FindBy(id="tag-slug")
	public WebElement regionSlug;
	
	@FindBy(id="tag-description")
	public WebElement regionDes;
	
	@FindBy(id="parent")
	public WebElement regiondropdown; 
	
	@FindBy(xpath="//tr[13]//td[1]")
	public WebElement table;
	
	//@FindBy(xpath="//form[contains(@class,'validate')]//input[contains(@class,'button button-primary')]")
	
	@FindBy(xpath="//input[@type='submit'][@value='Add New Region']")
	//@FindBy(css="#submit")
	
	public WebElement addRegion;
			
	@FindBy(xpath="//h1[contains(@class,'wp-heading-inline')]")
	public WebElement RegionHeading;
	
	@FindBy(xpath="//p[@class='search-box']//input[1]")
	public WebElement SearchIP;
	
	@FindBy(xpath="//p[contains(@class,'search-box')]//input[contains(@class,'button')]")
	public WebElement Sbutton; 
	
	@FindBy(xpath="//a[@class='row-title']")
	public WebElement Tabledata1;
	
	@FindBy(xpath="//td[contains(@class,'description column-description')]")
	public
	WebElement Tabledata2;
	
	@FindBy(xpath="//td[contains(@class,'slug column-slug')]")
	public WebElement Tabledata3;
	
	@FindBy(xpath="//li[contains(@class,'wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-property')]//li[3]//a[1]")
	public static WebElement addproplink;
}
