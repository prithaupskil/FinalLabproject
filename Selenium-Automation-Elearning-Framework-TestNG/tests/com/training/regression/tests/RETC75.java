package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

import com.training.dataproviders.LoginDataProviders2;
import com.training.generics.ScreenShot;
import com.training.pom.AddFeaturePOM;
import com.training.pom.AddpropertyPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.EditpropertyPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginRealEstatePOM;
import com.training.pom.LogoutPOM;
import com.training.pom.publishpropPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC75 {
	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginPOM;
	private DashboardPOM dbPOM;
	private AddpropertyPOM PropPOM;
	private EditpropertyPOM EditpropPOM;
	private publishpropPOM PublishPOM;
	private AddFeaturePOM FeaturePOM;
	private LogoutPOM logoutPOM;
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
		screenShot.captureScreenShot("TC75_Login");
		loginPOM.clickLoginBtn(); 
			
		Thread.sleep(3000);
	
		Actions Act=new Actions(driver);
				Act.moveToElement(dbPOM.propertylink).build().perform();
				Thread.sleep(3000);
			screenShot.captureScreenShot("TC75_adding new feature");
			dbPOM.Feature.click();
			Thread.sleep(3000);
			
	screenShot.captureScreenShot("TC75_Add feature screen");
	}

	@Test(priority=2, dataProvider = "excel-inputs for mytest", dataProviderClass = LoginDataProviders2.class)
	public void loginDBTest(String FeatureName, String Slug, String Feature, String Description) throws Exception  
	{
		
	
	FeaturePOM.featureName.sendKeys(FeatureName);
	
	
	FeaturePOM.Slug.sendKeys(Slug);
	
Select objSel=new Select(FeaturePOM.featuredropdown);
	FeaturePOM.featuredropdown.click();
	Thread.sleep(3000);
	objSel.selectByVisibleText(Feature);
		FeaturePOM.Description.sendKeys(Description);
	
	screenShot.captureScreenShot("TC75_Add Feature");
	FeaturePOM.addFeature.click();
	FeaturePOM.featureName.clear();
	FeaturePOM.Slug.clear();
	FeaturePOM.Description.clear();
	}
	
	@Test(priority=3)
	public void searchfeature() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",FeaturePOM.featureName);
	FeaturePOM.SearchIP.clear();
	FeaturePOM.SearchIP.sendKeys("retc");
	
	screenShot.captureScreenShot("TC75_seacrh added feature");
	FeaturePOM.Sbutton.click();
	
	String Actualtest1=FeaturePOM.Tabledata1.getText();
	System.out.println("actualtestfirstrow"+ Actualtest1);
	String Actualdescription1=FeaturePOM.Tabledata2.getText();
	String Actualslug1=FeaturePOM.Tabledata3.getText();
	String Actualtest2=FeaturePOM.Tabledata21.getText();
	System.out.println("actualtest2ndrow"+ Actualtest2);
	String Actualdescription2=FeaturePOM.Tabledata22.getText();
	String Actualslug2=FeaturePOM.Tabledata23.getText();
	

	Assert.assertEquals(Actualtest2,"RETC2");
	Assert.assertEquals(Actualdescription2,"Description2");
	
	screenShot.captureScreenShot("TC75_feature added successfully");
	
		

	}

}