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
import com.training.pom.DashboardPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_15 {

	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginPOM;
	private DashboardPOM dbPOM;
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
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM= new LoginRealEstatePOM(driver); 
		dbPOM=new DashboardPOM(driver);
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
		screenShot.captureScreenShot("TC15_Login");
		loginPOM.clickLoginBtn(); 
			//dashboarddisplay//	
	screenShot.captureScreenShot("TC15_Dashboard");
		String dashboardTitle=dbPOM.pageheading.getText();
		Assert.assertEquals(dashboardTitle,"Dashboard");
		Thread.sleep(5000);
		Actions Act=new Actions(driver);
				Act.moveToElement(dbPOM.adminlink).build().perform();
				Thread.sleep(3000);
			screenShot.captureScreenShot("Tc15_loggingout");
			
	//Logout//
		dbPOM.logout.click();
		Thread.sleep(5000);
	screenShot.captureScreenShot("TC15_Logout");
		
		
	String Pageurl= driver.getCurrentUrl();
	String pageTitle=driver.getTitle();
		System.out.println("PageURL:"+Pageurl);
		System.out.println("PageTitle:"+pageTitle);
		Assert.assertEquals(Pageurl,"http://realty-real-estatem1.upskills.in/my-profile/");
		Assert.assertEquals(pageTitle, "My Profile – Real Estate");
		String Pageelement= logoutPOM.loginPage.getText();
		Assert.assertEquals(Pageelement, "Real Estate");
		String Pageelement2= logoutPOM.login.getText();
		Assert.assertEquals(Pageelement2, "LOG IN / REGISTER");
		
	}
	
	
	}
		
	
