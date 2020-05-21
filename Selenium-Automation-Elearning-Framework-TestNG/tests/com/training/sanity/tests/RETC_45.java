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
import org.openqa.selenium.support.ui.Select;
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
import com.training.pom.RegionPOM;
import com.training.pom.publishpropPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_45 {

	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginPOM;
	private DashboardPOM dbPOM;
	private AddpropertyPOM PropPOM;
	private EditpropertyPOM EditpropPOM;
	private publishpropPOM PublishPOM;
	private RegionPOM AddRegionPOM;
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
		AddRegionPOM=new RegionPOM(driver);
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
		screenShot.captureScreenShot("TC45_Login");
		loginPOM.clickLoginBtn(); 
			
		Thread.sleep(3000);
	
		Actions Act=new Actions(driver);
				Act.moveToElement(dbPOM.propertylink).build().perform();
				Thread.sleep(3000);
			screenShot.captureScreenShot("TC45_adding new region");
			dbPOM.Regionlink.click();
			Thread.sleep(3000);
			
	screenShot.captureScreenShot("TC45_Add region screen");
		
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
	Assert.assertEquals(pageTitle,"Regions ‹ Real Estate — WordPress");
	
	//Add Region
	
	AddRegionPOM.regionName.sendKeys("AabayRETC45");
	AddRegionPOM.regionSlug.sendKeys("AabayRETC45pritha");
	AddRegionPOM.regionDes.sendKeys("AabayRETC45");
	
	screenShot.captureScreenShot("TC45_region detail1");
	

	
	 Select objSel=new Select(AddRegionPOM.regiondropdown);
	AddRegionPOM.regiondropdown.click();
	objSel.selectByValue("57");
		
	 
	List<WebElement> opt= driver.findElements(By.xpath("//option[@value='57']"));
	 for(WebElement We:opt){
	 System.out.println("Selected:"+ We.getText());
	 String selected=We.getText();
	 Assert.assertTrue(selected.contains("Central Bangalore"));
	}
	js.executeScript("arguments[0].scrollIntoView(true);",AddRegionPOM.addRegion);
	 
	Thread.sleep(5000);
	screenShot.captureScreenShot("TC45_adding region");
	
	 AddRegionPOM.addRegion.click();
	 screenShot.captureScreenShot("TC45_region selection");
	
	Thread.sleep(5000);
	js.executeScript("arguments[0].scrollIntoView(true);",AddRegionPOM.RegionHeading);
	AddRegionPOM.SearchIP.sendKeys("AabayRETC45");
	
	AddRegionPOM.Sbutton.click();
	screenShot.captureScreenShot("TC45_Region added");

	
	
	WebElement Tabledata1=AddRegionPOM.Tabledata1;
	WebElement Tabledata2=AddRegionPOM.Tabledata2;
	WebElement Tabledata3=AddRegionPOM.Tabledata3;
	
	String Actualtest=Tabledata1.getText();
	String Actualdescription=Tabledata2.getText();
	String Actualslug=Tabledata3.getText();
	System.out.println(Actualtest+":"+Actualdescription+":"+Actualslug);
	
	Assert.assertEquals(Actualtest,"AabayRETC45");
	Assert.assertEquals(Actualdescription,"AabayRETC45");
	Assert.assertTrue(Actualslug.contains("aabayretc45pritha"));
	
	RegionPOM.addproplink.click();
	
	String pageTitle1=driver.getTitle();
	
	Assert.assertEquals(pageTitle1,"Add Property ‹ Real Estate — WordPress");
	screenShot.captureScreenShot("TC45_Addpropertyscreen");
	
		
	PropPOM.Title.sendKeys("pritharetc45");
	PropPOM.Content.sendKeys("prithacontent45");
	screenShot.captureScreenShot("TC45_adding prop details1");
	

	Thread.sleep(5000);
	
	PropPOM.regioncheckbox.click();
	Thread.sleep(5000);
	
	screenShot.captureScreenShot("TC45_adding prop detailsregion");
	
	js.executeScript("arguments[0].scrollIntoView(true);",PropPOM.Addproppagetitle);
	
	Actions Act1=new Actions(driver);
	Act1.moveToElement(PropPOM.Publish).click(PropPOM.Publish).build().perform();
	
	Thread.sleep(8000);
	
	screenShot.captureScreenShot("TC45_added property");
	
	String publishpostmessage=EditpropPOM.publishmessage.getText();
	
	
	Assert.assertEquals(publishpostmessage,"Post published. View post");
	
	
	
	
	
	}
}

    		   		
    		  
    		   
    		   		
       
            
	