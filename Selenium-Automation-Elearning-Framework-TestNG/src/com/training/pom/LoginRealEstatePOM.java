package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginRealEstatePOM {
	
	private WebDriver driver; 
	public LoginRealEstatePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="sign-in")
	public WebElement loginorRegister; 
	
	@FindBy(linkText="Log In")
	private WebElement login; 
	
	@FindBy(id="user_login")
	public WebElement userName; 
	
	@FindBy(id="user_pass")
	public WebElement password;
	
	@FindBy(name="login")
	public WebElement loginBtn; 
	
	public void clickLoginorregister() {
		this.loginorRegister.click();
	}
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	

}



