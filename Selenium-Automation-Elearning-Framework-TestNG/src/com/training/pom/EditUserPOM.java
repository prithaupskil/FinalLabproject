package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EditUserPOM {
	
	private WebDriver driver; 
	public EditUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='message' and @class='updated notice is-dismissible']")public WebElement message;
	
	
	@FindBy(id="user-search-input")
	public WebElement searchuser;
	
	@FindBy(xpath="//input[@class='button' and @value='Search Users']")public WebElement searchbtn;
	
	@FindBy(xpath="//tbody//tr[1]//td[1]")public WebElement tabledata1;
	@FindBy(xpath="//tbody//tr[1]//td[2]")public WebElement tabledata2;
	@FindBy(xpath="//tbody//tr[1]//td[3]")public WebElement tabledata3;
	@FindBy(xpath="//tbody//tr[1]//td[4]")public WebElement tabledata4;
	
	@FindBy(xpath="//a[@class='page-title-action' and contains(text(),'Add New')]")public WebElement Addusercurrent;
	
	
		
}



