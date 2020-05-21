package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePOM {
	
	public WebDriver driver; 
	
	public MyProfilePOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}

@FindBy(xpath= "//h1[contains(text(),'Profile')]")
public WebElement pageheading; 

@FindBy(xpath="//input[@id='first_name']")
public WebElement firstname;

@FindBy(xpath="//input[@id='last_name']")
public WebElement lastname;

@FindBy(xpath="//input[@id='phone']")
public WebElement phonenumber;

@FindBy(xpath="//tr[@id='password']//label[contains(text(),'New Password')]")
public WebElement Newpassword;
@FindBy(xpath="//th[contains(text(),'Profile Picture')]")
public WebElement profilepic;

@FindBy(xpath="//button[contains(text(),'Generate Password')]")
public WebElement GenPWD;

@FindBy(xpath="//input[@id='pass1-text']")
public WebElement NewPWD;

@FindBy(xpath="//input[contains(@name,'pw_weak')]")
public WebElement ConfirmPWD;

//@FindBy(xpath="//input[@id='pass1']")
//public WebElement HiddenPWD;

//@FindBy(xpath="//form[@id='your-profile']//button[1]//span[1]")
//public WebElement HidePWD;



@FindBy(xpath="//input[@id='submit']")
private WebElement submitbutton;

@FindBy(xpath="//strong[contains(text(),'Profile updated.')]")
public WebElement updatemessage;



public void updateprofile(String lastname) {
	this.lastname.clear();
	this.lastname.sendKeys(lastname);
}

public void updatephoneno(String phonenumber) {
	this.phonenumber.clear();
	this.phonenumber.sendKeys(phonenumber);
}

public void submit() {
	this.submitbutton.click(); 
}

public void GeneratePWD() {
	this.GenPWD.click();
}
}


