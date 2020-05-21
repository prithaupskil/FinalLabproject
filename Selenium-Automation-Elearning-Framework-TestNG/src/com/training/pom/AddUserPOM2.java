package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddUserPOM2 {
	
	private WebDriver driver; 
	public AddUserPOM2(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="user_login")
	public WebElement userName; 
	
	@FindBy(id="email")
	public WebElement email; 
	
	@FindBy(id="first_name")
	public WebElement firstName; 
	
	@FindBy(id="last_name")
	public WebElement lastName;
	
	@FindBy(name="url")
	public WebElement Website; 
	
	@FindBy(xpath="//button[@type='button' and contains(text(),'Show password')]")
	public WebElement showPassword;
	
	@FindBy(xpath="//input[@type='text' and@id='pass1-text']")
	public WebElement randomPassword;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='pw_weak']")
	public WebElement confirmPWD;
	
	@FindBy(id="role")
	public WebElement RoleDropdown;
	
	@FindBy(xpath="//input[@type='submit' and @value='Add New User']")
	public WebElement AddUser;
	
	@FindBy(xpath="//div[@class='error']//p[contains(text(),'correct')]")
	public WebElement Errormessage;

		
}



