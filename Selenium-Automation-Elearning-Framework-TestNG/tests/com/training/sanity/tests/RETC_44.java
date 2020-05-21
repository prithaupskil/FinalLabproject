package com.training.sanity.tests;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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
import com.training.pom.AddFeaturePOM;
import com.training.pom.AddpropertyPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.EditpropertyPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.publishpropPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_44 {

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
		FeaturePOM=new AddFeaturePOM(driver);
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
		JavascriptExecutor js= (JavascriptExecutor) driver;
		loginPOM.clickLoginorregister();	
		loginPOM.userName.sendKeys("admin");		
		loginPOM.password.sendKeys("admin@123");
		Thread.sleep(5000);
		screenShot.captureScreenShot("TC44_Login");
		loginPOM.clickLoginBtn(); 
			
		Thread.sleep(3000);
	
		Actions Act=new Actions(driver);
				Act.moveToElement(dbPOM.propertylink).build().perform();
				Thread.sleep(3000);
			screenShot.captureScreenShot("TC44_adding new feature");
			dbPOM.Feature.click();
			Thread.sleep(3000);
			
	screenShot.captureScreenShot("TC44_Add feature screen");
		
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
	Assert.assertEquals(pageTitle,"Features ‹ Real Estate — WordPress");
	
	//Add feature
	
	FeaturePOM.featureName.sendKeys("Abaytest44");
	
	FeaturePOM.Slug.sendKeys("Slugtest44");
	
	FeaturePOM.Description.sendKeys("Abaydecription44");
	screenShot.captureScreenShot("TC44_Add Feature");
	FeaturePOM.addFeature.click();
	
	js.executeScript("arguments[0].scrollIntoView(true);",FeaturePOM.featureName);
	
	FeaturePOM.SearchIP.sendKeys("Abaytest44");
	
	screenShot.captureScreenShot("TC44_seacrh added feature");
	FeaturePOM.Sbutton.click();
	
	WebElement Tabledata11=FeaturePOM.Tabledata1;
	WebElement Tabledata2=FeaturePOM.Tabledata2;
	WebElement Tabledata3=FeaturePOM.Tabledata3;
	
	String Actualtest=Tabledata11.getText();
	String Actualdescription=Tabledata2.getText();
	String Actualslug=Tabledata3.getText();
	
	Assert.assertEquals(Actualtest,"Abaytest44");
	Assert.assertEquals(Actualdescription,"Abaydecription44");
	Assert.assertTrue(Actualslug.contains("slugtest44"));
	
	screenShot.captureScreenShot("TC44_feature added successfully");
	
	FeaturePOM.addproplink.click();
	
	String pageTitle1=driver.getTitle();
	
	Assert.assertEquals(pageTitle1,"Add Property ‹ Real Estate — WordPress");
	screenShot.captureScreenShot("TC44_Addpropertyscreen");
	
	
	//PropPOM.Title.click();
	PropPOM.Title.sendKeys("RETC44");
	
	PropPOM.Content.sendKeys("Content44");
	screenShot.captureScreenShot("TC44_adding prop details1");
	
	js.executeScript("arguments[0].scrollIntoView(true);",PropPOM.feature);
	
	Thread.sleep(5000);
	
	PropPOM.featurecheckbox.click();
	Thread.sleep(5000);
	
	screenShot.captureScreenShot("TC44_adding prop detailsfeature");
	
	js.executeScript("arguments[0].scrollIntoView(true);",PropPOM.Addproppagetitle);
	
	Actions Act1=new Actions(driver);
	Act1.moveToElement(PropPOM.Publish).click(PropPOM.Publish).build().perform();
	
	Thread.sleep(8000);
	
	screenShot.captureScreenShot("TC44_added property");
	
	String publishpostmessage=EditpropPOM.publishmessage.getText();
	
	
	Assert.assertEquals(publishpostmessage,"Post published. View post");
	
	

	
	
	}
}

    		   		
    		  
    		   
    		   		
       
            
	