package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
//import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
//import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.LoginDataProviders2;
import com.training.generics.ScreenShot;
import com.training.pom.AddFeaturePOM;
import com.training.pom.AddUserPOM2;
import com.training.pom.EditUserPOM;
import com.training.pom.AddpropertyPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.EditpropertyPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginRealEstatePOM;
import com.training.pom.LogoutPOM;
import com.training.pom.publishpropPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC74 {
	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginPOM;
	private DashboardPOM dbPOM;
	private AddpropertyPOM PropPOM;
	private EditpropertyPOM EditpropPOM;
	private publishpropPOM PublishPOM;
	private AddFeaturePOM FeaturePOM;
	private LogoutPOM logoutPOM;
	private AddUserPOM2 AddUserPOM ;
	private EditUserPOM EditUserPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM= new LoginRealEstatePOM(driver); 
		dbPOM=new DashboardPOM(driver);
		PropPOM=new AddpropertyPOM(driver);
		EditpropPOM= new EditpropertyPOM(driver);
		PublishPOM=new publishpropPOM(driver);
		FeaturePOM=new AddFeaturePOM(driver);
		logoutPOM= new LogoutPOM(driver);
		AddUserPOM=new AddUserPOM2(driver);
		EditUserPOM=new EditUserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		
		//open the browser
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test(priority=1)
	public void validLoginTest() throws Exception {
		//login//
		driver.get(baseUrl);
		loginPOM.clickLoginorregister();	
		loginPOM.userName.sendKeys("admin");		
		loginPOM.password.sendKeys("admin@123");
		Thread.sleep(5000);
	screenShot.captureScreenShot("TC74_Login");
		loginPOM.clickLoginBtn(); 
			
		Thread.sleep(3000);
	
		Actions Act=new Actions(driver);
				Act.moveToElement(dbPOM.Userlink).build().perform();
				Thread.sleep(3000);
			screenShot.captureScreenShot("TC74_adding new user");
			dbPOM.Adduser.click();
			Thread.sleep(3000);
			screenShot.captureScreenShot("TC74_Add new user screen");
	}
	
		@Test(priority=2, dataProvider = "excel-inputs for mytest2", dataProviderClass = LoginDataProviders2.class)
	public void Usercreationtest(String Username, String Email, String Firstname, String Website, String Password, String Role, String Lastname, String Expectederror)
	throws Exception{
		AddUserPOM.userName.sendKeys(Username);
	
	
	AddUserPOM.email.sendKeys(Email);
	AddUserPOM.firstName.sendKeys(Firstname);

	AddUserPOM.Website.sendKeys(Website);
	screenShot.captureScreenShot("TC74_adding new userdetail1");
	AddUserPOM.showPassword.click();
	AddUserPOM.randomPassword.clear();
	AddUserPOM.randomPassword.sendKeys("d");
	AddUserPOM.confirmPWD.click();
		Thread.sleep(3000);
			AddUserPOM.randomPassword.clear();
		AddUserPOM.randomPassword.sendKeys(Password);
	
Select objSel=new Select(AddUserPOM.RoleDropdown);
AddUserPOM.RoleDropdown.click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//option[contains(text(),'"+Role+"')]")).click();
		AddUserPOM.lastName.sendKeys(Lastname);

		 Thread.sleep(8000);
		screenShot.captureScreenShot("TC74_adding new userdetail2");
	AddUserPOM.AddUser.click();
	Thread.sleep(8000);
	String Actualerror= AddUserPOM.Errormessage.getText();
	System.out.println("ActualError:"+ Actualerror);
	Assert.assertEquals(Actualerror,Expectederror);
	
	screenShot.captureScreenShot("TC74_error");
	
		}
}