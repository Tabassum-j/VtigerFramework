package com.comcast.crm.orgtest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPage;
import com.crm.generic.baseUtility.BaseClass;

public class CreateOrganizationWithIndustryTest extends BaseClass {

	@Test
	public void organizationWithIndustryTest() throws EncryptedDocumentException, IOException {
			    
			    String orgName = elib.getDataFromExcel("Org", 4, 2) + jlib.getRandomNumber();
			    String industry = elib.getDataFromExcel("Org", 4, 3);
			    String type = elib.getDataFromExcel("Org", 4, 4);
			    
			    
			    //Navigate to organization module
			   HomePage hp = new HomePage(driver);
			   hp.getOrgLink().click();
			    
			    //Click on create organization button
			   OrganizationsPage op = new OrganizationsPage(driver);
			   op.getcreateOrg().click();
			    
			    //Enter mandatory fields and create new organization
			    //Select value from drop down
			   
			   CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			   cnop.orgNameEdt().sendKeys(orgName);
			   wLib.select(cnop.industryDD(), industry);
				wLib.select(cnop.typeDD(), type);
				cnop.saveBtn().click();
				
			   
			    //Verify the industry drop down data
			    String actualIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
			    if(actualIndustries.equals(industry)) {
			    	System.out.println(industry+ " information is verified==>PASS");
			    }
			    else {
			    	System.out.println(industry+" information is not verified==>FAIL");
			    }
			    
			    //Verify the type drop down
			    String actualType = driver.findElement(By.id("dtlview_Type")).getText();
			    if(actualType.equals(type)) {
			    	System.out.println(type+ " information is verified==>PASS");
			    }
			    else {
			    	System.out.println(type+" information is not verified==>FAIL");
			    }
			       

	}

}
