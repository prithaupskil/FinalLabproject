package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOM {
	
	public WebDriver driver; 
	
	public DashboardPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}

@FindBy(xpath= "//h1[contains(text(),'Dashboard')]")
public WebElement pageheading; 

@FindBy(xpath="//div[@id='vc_license-activation-notice']")
private WebElement pagemessage;

@FindBy(xpath="//img[@class='avatar avatar-26 photo']")
public WebElement adminlink;


@FindBy(xpath="//a[contains(text(),'Edit My Profile')]")
public WebElement editprofile;

@FindBy(xpath="//a[contains(@class,'ab-item')][contains(text(),'Log Out')]")
public WebElement logout;

@FindBy(xpath="//div[@class='wp-menu-image dashicons-before dashicons-admin-multisite']")
public WebElement propertylink;

@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
public WebElement Addnewprop;

@FindBy(xpath="//a[contains(text(),'Features')]")
public WebElement Feature;
@FindBy(xpath="//a[contains(text(),'Region')]")
public WebElement Regionlink;
@FindBy(xpath="//a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-users']")
public WebElement Userlink;
@FindBy(xpath="//a[@href='user-new.php']")
public WebElement Adduser;



public void hoveradmin() {
	new Actions (this.driver).moveToElement(this.adminlink).perform();
	
}

public void Logout() {
	new Actions (this.driver).moveToElement(this.logout).click();
}
}
