package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.training.pom.MyProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_14 {

	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginPOM;
	private DashboardPOM dbPOM;
	private MyProfilePOM profilePOM;
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
		profilePOM= new MyProfilePOM(driver);
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
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		//Login//
		loginPOM.clickLoginorregister();
		
		System.out.println("Username:");
		Scanner User = new Scanner(System.in);
		String Username = User.nextLine();
		loginPOM.userName.sendKeys(Username);
		System.out.println("Password:");
		Scanner PWD = new Scanner(System.in);
		String UserPWD = PWD.nextLine();
		loginPOM.password.sendKeys(UserPWD);
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC14_Login");
		loginPOM.clickLoginBtn(); 
			
		//Dashboard Display//
		String dashboardTitle=dbPOM.pageheading.getText();
		Assert.assertEquals(dashboardTitle,"Dashboard");
		Thread.sleep(5000);
		System.out.println("Logged in");
		Actions Act=new Actions(driver);
				Act.moveToElement(dbPOM.adminlink).build().perform();
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC14_Dashboard");
			
	//My Profile page display//
		dbPOM.editprofile.click();
		Thread.sleep(5000);
		
	
		String Pageelement2= profilePOM.pageheading.getText();
		Assert.assertEquals(Pageelement2, "Profile");
		screenShot.captureScreenShot("TC14_Profile page");
		
		//PWD Generation//
		js.executeScript("arguments[0].scrollIntoView(true);",profilePOM.profilepic);
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC14_geneartingpwd");
		profilePOM.GeneratePWD();
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC14_GenerateautoPWD");
		String PWDText=profilePOM.NewPWD.getAttribute("value");
		System.out.println("Autogenrated PWD:"+PWDText);
		profilePOM.NewPWD.clear();
	    profilePOM.NewPWD.sendKeys("d");
		profilePOM.ConfirmPWD.click();
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC14_confirmpwd");
		profilePOM.NewPWD.clear();
	System.out.println("New Password:");
		Scanner scan3 = new Scanner(System.in);
		String NewUserPWD = scan3.nextLine();
		profilePOM.NewPWD.sendKeys(NewUserPWD);
		Thread.sleep(5000);
	screenShot.captureScreenShot("TC14_providenewPWD");
		
		profilePOM.submit();
		System.out.println("submitted");
		Thread.sleep(3000);
		String message=profilePOM.updatemessage.getText();
		Assert.assertEquals(message, "Profile updated.");
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC14_Profile updated");
	}
}
		
		
	
