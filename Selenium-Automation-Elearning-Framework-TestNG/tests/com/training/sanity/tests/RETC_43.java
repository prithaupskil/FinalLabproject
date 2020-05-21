package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginRealEstatePOM;
import com.training.pom.AddpropertyPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.EditpropertyPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.publishpropPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_43 {

	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginPOM;
	private DashboardPOM dbPOM;
	private AddpropertyPOM PropPOM;
	private EditpropertyPOM EditpropPOM;
	private publishpropPOM PublishPOM;
	private LogoutPOM logoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM= new LoginRealEstatePOM(driver); 
		dbPOM=new DashboardPOM(driver);
		PropPOM=new AddpropertyPOM(driver);
		EditpropPOM= new EditpropertyPOM(driver);
		PublishPOM=new publishpropPOM(driver);
		logoutPOM= new LogoutPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws Exception {
		//login//
		loginPOM.clickLoginorregister();
		
		loginPOM.userName.sendKeys("admin");
			
		loginPOM.password.sendKeys("admin@123");
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC43_Login");
		loginPOM.clickLoginBtn(); 
			
		Thread.sleep(3000);
	
		Actions Act=new Actions(driver);
				Act.moveToElement(dbPOM.propertylink).build().perform();
				Thread.sleep(3000);
			screenShot.captureScreenShot("TC43_adding new property");
			dbPOM.Addnewprop.click();
			Thread.sleep(3000);
			
	screenShot.captureScreenShot("TC43_Add property screen");
		
		String pageTitle=driver.getTitle();
	Assert.assertEquals(pageTitle,"Add Property ‹ Real Estate — WordPress");
	
	
	//PropPOM.Title.click();
	PropPOM.Title.sendKeys("Title_RETC_43");
	
	PropPOM.Content.sendKeys("Content_RETC_43");
	screenShot.captureScreenShot("TC43_add details");
	Actions Act1=new Actions(driver);
	Act1.moveToElement(PropPOM.Publish).click(PropPOM.Publish).build().perform();
	
	Thread.sleep(8000);
	
	String Editproppage=EditpropPOM.editprop.getText();
	
	Assert.assertEquals(Editproppage, "Edit Property");
	
	screenShot.captureScreenShot("TC43_Publishing");
	
String publishpostmessage=EditpropPOM.publishmessage.getText();
	
	
	Assert.assertEquals(publishpostmessage,"Post published. View post");
	
	EditpropPOM.viewPost.click();
	Thread.sleep(5000);
	
	String Pagetitle= driver.getTitle();
	String Expectedtitle= "Title_RETC_43"+" – Real Estate";
	
	
			Assert.assertEquals(Pagetitle,Expectedtitle);
			String Pageoverview=PublishPOM.publishoverview.getText();
			System.out.println (Pageoverview);
			String Expectedoverview="Title_RETC_43"+" - Overview";
			Assert.assertEquals(Pageoverview, Expectedoverview);
	
			String Pagecontent=PublishPOM.content.getText();
			//String Expectedcontent=containtest;
			Assert.assertEquals(Pagecontent, "Content_RETC_43");
			screenShot.captureScreenShot("TC43_Published");
			
			
		/*Assert.assertEquals(pageTitle, "");
		String Pageelement= logoutPOM.loginPage.getText();
		Assert.assertEquals(Pageelement, "Real Estate");
		String Pageelement2= logoutPOM.login.getText();
		Assert.assertEquals(Pageelement2, "LOG IN / REGISTER");
		*/
	}
	
	
	}
		
	
