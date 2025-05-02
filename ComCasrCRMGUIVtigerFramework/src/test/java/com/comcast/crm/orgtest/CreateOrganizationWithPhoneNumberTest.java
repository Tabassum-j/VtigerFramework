package com.comcast.crm.orgtest;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPage;
import com.crm.generic.baseUtility.BaseClass;

public class CreateOrganizationWithPhoneNumberTest extends BaseClass {
	@Test

	public void organizationWithPhoneNumberTest() throws IOException {
		
			    
			    String orgName = elib.getDataFromExcel("Org", 7, 2) + jlib.getRandomNumber();
			    String phoneNumber = elib.getDataFromExcel("Org", 7, 3);
			    
			    
			    //Navigate to organization module
			    HomePage hp = new HomePage(driver);
			    hp.getOrgLink().click();
			    
			    //Click on create organization button
			    OrganizationsPage op = new OrganizationsPage(driver);
			    op.getcreateOrg().click();	
			    
			    //Enter mandatory fields and create new organization
			    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			    cnop.orgNameEdt().sendKeys(orgName);
			    cnop.phoneEdt().sendKeys(phoneNumber);
			    cnop.saveBtn().click();
			    
			    //Verify the phone number
			    String actualPhNo = driver.findElement(By.id("dtlview_Phone")).getText();
			   if(actualPhNo.equals(phoneNumber))
			   {
			    	System.out.println(phoneNumber+" information is created==>PASS");
			    }
			    else {
			    	System.out.println(phoneNumber+" information is not created==>FAIL");
			    }
	}

}
