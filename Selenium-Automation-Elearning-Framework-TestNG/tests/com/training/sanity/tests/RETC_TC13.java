package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class RETC_TC13 {

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
		//Login//
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		loginPOM.clickLoginorregister();
		
		System.out.println("Username:");
		Scanner User = new Scanner(System.in);
		String Username = User.nextLine();
		loginPOM.userName.sendKeys(Username);
		//loginPOM.sendUserName("admin");
		//loginPOM.sendPassword("admin@123");
		
		System.out.println("Password:");
		Scanner PWD = new Scanner(System.in);
		String UserPWD = PWD.nextLine();
		loginPOM.password.sendKeys(UserPWD);
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC13_Login");
		loginPOM.clickLoginBtn(); 
			//Dashboard//	
		String dashboardTitle=dbPOM.pageheading.getText();
		Assert.assertEquals(dashboardTitle,"Dashboard");
				Actions Act=new Actions(driver);
				Act.moveToElement(dbPOM.adminlink).build().perform();
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC13_Dashboard admin links");
		
		//edit admin profile- last name and Phone#//
		dbPOM.editprofile.click();
		//Thread.sleep(5000);
		String Pageelement2= profilePOM.pageheading.getText();
		Assert.assertEquals(Pageelement2, "Profile");
		screenShot.captureScreenShot("TC13_Profile page");
		//WebElement ln=driver.findElement(By.xpath("//input[@id='last_name']"));
		js.executeScript("arguments[0].scrollIntoView(true);",profilePOM.firstname);
	    screenShot.captureScreenShot("TC13_update_lastnamephoneno_before");
		System.out.println("New Lastname:");
		Scanner scan1 = new Scanner(System.in);
		String LastName = scan1.nextLine();
			profilePOM.lastname.clear();
		profilePOM.lastname.sendKeys(LastName);
		
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC13_update lastname_after");
	//	js.executeScript("arguments[0].scrollIntoView(true);",profilePOM.lastname);
		  //screenShot.captureScreenShot("TC13_update_lastname_before");
		System.out.println("New Phone#:");
		Scanner scan2 = new Scanner(System.in);
		String Phoneno = scan2.nextLine();

		profilePOM.phonenumber.clear();
		profilePOM.phonenumber.sendKeys(Phoneno);
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC13_update Phoneno after");
		profilePOM.submit();
		Thread.sleep(3000);
		String message=profilePOM.updatemessage.getText();
		Assert.assertEquals(message, "Profile updated.");
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC13_Profile updated");
		
		
		
	}

	private Object xpath(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	}
		
	
