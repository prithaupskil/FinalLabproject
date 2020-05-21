package com.training.sanity.tests;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

public class RETC_44_Table {

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
		
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat format=new SimpleDateFormat("MMM-DD-YYYY");
		
		String formatteddate=format.format(date);
		System.out.println(formatteddate);
		
		//login//
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();",loginPOM.loginorRegister);
		//System.out.println("selected");
		//js.executeScript("arguments[0].scrollIntoView(true);", loginPOM.loginBtn);
		//js.executeScript("Window.scrollBy(0,document.body.scrollHeight);");
		
		//WebElement usename= driver.findElement(By.name("log"));
	//js.executeScript("arguments[0].click();",usename);
		
		//js.executeScript("usename.value='admin';");
	
	//js.executeScript("document.getElementByName('pwd').value='admin@123';");
	//WebElement sysdate=
	
		//js.executeScript("(loginPOM.LoginBtn).click();");
	}
}
		//loginPOM.clickLoginorregister()
//		System.out.println("Username:");
//		
//		loginPOM.userName.sendKeys("admin");
//				
//		loginPOM.password.sendKeys("admin@123");
//		Thread.sleep(5000);
//		screenShot.captureScreenShot("TC43_Login");
//		loginPOM.clickLoginBtn(); 
//			
//		Thread.sleep(3000);
//	
//		Actions Act=new Actions(driver);
//				Act.moveToElement(dbPOM.propertylink).build().perform();
//				Thread.sleep(3000);
//			screenShot.captureScreenShot("TC44_adding new feature");
//			dbPOM.Feature.click();
//			Thread.sleep(3000);
//			
//	screenShot.captureScreenShot("TC44_Add feature screen");
//		
//		String pageTitle=driver.getTitle();
//		System.out.println(pageTitle);
//	Assert.assertEquals(pageTitle,"Features ‹ Real Estate — WordPress");
//	
//	//Add feature
//	
//	FeaturePOM.featureName.sendKeys("Abay44");
//	
//	FeaturePOM.Slug.sendKeys("Slug44");
//	
//	FeaturePOM.Description.sendKeys("decription44");
//	screenShot.captureScreenShot("TC44_Add Feature");
//	FeaturePOM.addFeature.click();
//	
//	//code to validate through table data//
//	FeaturePOM.Apply.click();
//	
//	Thread.sleep(5000);
//	
//List<WebElement>  Tablerow=driver.findElements(By.xpath("//tbody[@id='the-list']//tr/td"));
//	int Rowsize=Tablerow.size();
//
//
//	for (int iRow=2;iRow<Rowsize;iRow++) {
//		
//     String testdata = driver.findElement(By.xpath("//tr["+iRow+"]//td[1]")).getText();
//     System.out.println(testdata);
//     System.out.println("ipdata:");
//     
//        
//        
// 
//       
//    	   if (testdata.equals("Abay44"))
//    		   {System.out.println("validating");
//    		 
//    		   String Name= driver.findElement(By.xpath("//tr["+iRow+"]//td[1]")).getText();
//    		     String Slug=driver.findElement(By.xpath("//tr["+iRow+"]//td[2]")).getText();
//    		     String Description=driver.findElement(By.xpath("//tr["+iRow+"]//td[3]")).getText();
//    	            System.out.println("name:"+ Name+","+Slug+","+Description);
//    	            break;    
//    	          
//    	        
//    		   }
//	}
//	}
//}
//    	//code to search//  
////	js.executeScript("arguments[0].scrollIntoView(true);",FeaturePOM.Pageheading);
////	FeaturePOM.SearchIP.sendKeys(featurename);
////	
////	//FeaturePOM.Sbutton.click();
////	//screenShot.captureScreenShot("TC44_feature added");
////
////	
////	//feature table//
////	
////	
////	
////	//WebElement Tabledata1=driver.findElement(By.xpath("//td[contains(@class,'name column-name has-row-actions column-primary')]"));
////	//WebElement Tabledata2=driver.findElement(By.xpath("//td[@class='description column-description']"));
////	//WebElement Tabledata3=driver.findElement(By.xpath("//td[@class='slug column-slug']"));
////	WebElement Tabledata1=FeaturePOM.Tabledata1;
////	WebElement Tabledata2=FeaturePOM.Tabledata2;
////	WebElement Tabledata3=FeaturePOM.Tabledata3;
////	//System.out.println ("table found");
////	String Actualtest=Tabledata1.getText();
////	String Actualdescription=Tabledata2.getText();
////	String Actualslug=Tabledata3.getText();
////	System.out.println(Actualtest+":"+Actualdescription+":"+Actualslug);
////	
////	Assert.assertEquals(Actualtest,featurename);
////	Assert.assertEquals(Actualdescription,featuredes);
////	Assert.assertEquals(Actualslug,featureslug);
////	
////	FeaturePOM.addproplink.click();
////	
////	String pageTitle1=driver.getTitle();
////	
////	Assert.assertEquals(pageTitle1,"Add Property ‹ Real Estate — WordPress");
////	screenShot.captureScreenShot("TC44_Addpropertyscreen");
////	
////	System.out.println("Enter Title:");
////	Scanner scantest= new Scanner(System.in);
////	String titletest=scantest.nextLine();
////	//PropPOM.Title.click();
////	PropPOM.Title.sendKeys(titletest);
////	System.out.println("Enter content:");
////	Scanner scantest1= new Scanner(System.in);
////	String containtest=scantest1.nextLine();
////	PropPOM.Content.sendKeys(containtest);
////	screenShot.captureScreenShot("TC44_adding prop details1");
////	
////	js.executeScript("arguments[0].scrollIntoView(true);",PropPOM.feature);
////	
////	Thread.sleep(5000);
////	
////	PropPOM.featurecheckbox.click();
////	Thread.sleep(5000);
////	
////	screenShot.captureScreenShot("TC44_adding prop detailsfeature");
////	
////	js.executeScript("arguments[0].scrollIntoView(true);",PropPOM.Addproppagetitle);
////	
////	Actions Act1=new Actions(driver);
////	Act1.moveToElement(PropPOM.Publish).click(PropPOM.Publish).build().perform();
////	
////	Thread.sleep(8000);
////	
////	screenShot.captureScreenShot("TC44_added property");
////	
////	String publishpostmessage=EditpropPOM.publishmessage.getText();
////	
////	
////	Assert.assertEquals(publishpostmessage,"Post published. View post");
////	
////	
////	*/
////	
////	
////	}
////}
////
////    		   		
////    		  
//    		   
//    		   		
//       
//            
//	