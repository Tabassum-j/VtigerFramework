package com.comcast.crm.contacttest;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.ContactsInformationPage;
import com.comcast.crm.objectRepositoryUtility.ContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws IOException {
		
		FileUtility flib = new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		
        String BROWSER = flib.getDataFromPropertiesFile("browser");
        String URL = flib.getDataFromPropertiesFile("url");
        String USERNAME =flib.getDataFromPropertiesFile("username");
        String PASSWORD = flib.getDataFromPropertiesFile("password");
        
 	  JavaUtility jlib = new JavaUtility();
 	    
 	   String lastName = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
        
        WebDriver driver = null;
         if(BROWSER.equalsIgnoreCase("chrome")) {
        	 driver = new ChromeDriver();
         }else if(BROWSER.equalsIgnoreCase("edge")) {
        	 driver = new EdgeDriver();
         }else {
        	 driver = new ChromeDriver();
         }
      
        WebDriverUtility wLib = new WebDriverUtility();
        wLib.maximizeWindow(driver);
        wLib.implicitWait(driver);
         
         //Login to the application using property file data
         driver.get(URL);
         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 	     driver.findElement(By.id("submitButton")).click();
 	     
		String startDate = jlib.getSystemDateYYYYMMDD();
		String endDate = jlib.getRequiredDateYYYYMMDD(30);
 	     
 	    //Navigating to the contacts module and click on create module and enter the last name
		
		 HomePage hp = new HomePage(driver);
	 	    hp.getContactLink().click();
	 	    ContactsPage cp = new ContactsPage(driver);
	 	    cp.createContact().click();
	 	    
	 	   CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
	 	   cncp.getlastNameEdt().sendKeys(lastName);
	 	   
	 	   cncp.getsprtStartDate().clear();
	 	   cncp.getsprtStartDate().sendKeys(startDate); 
	 	   
	 	   cncp.getsprtEndDate().clear();
	 	   cncp.getsprtEndDate().sendKeys(endDate);
	 	  cncp.getsaveBtn().click();
 	   
 	    //Verify start date
	 	 ContactsInformationPage cip = new ContactsInformationPage(driver);
	 	String actStartDate = cip.getreflectStrt().getText();
 	    if(actStartDate.equals(startDate)) {
 	    	System.out.println(startDate+" information is verified==>PASS");
 	    }
 	    else {
 	    	System.out.println(startDate+" information is not verified==>FAIL");
 	    }
 	   //Verify the end date
 	   String actLastDate = cip.getreflectEnd().getText();
 	    if(actLastDate.equals(endDate)) {
 	    	System.out.println(endDate+" information is verified==>PASS");
 	    }
 	    else {
 	    	System.out.println(endDate+" information is not verified==>FAIL");
 	    }
 	    driver.quit();


	}

}
