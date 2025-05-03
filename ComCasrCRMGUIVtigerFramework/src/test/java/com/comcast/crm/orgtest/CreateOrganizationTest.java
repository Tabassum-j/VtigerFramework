package com.comcast.crm.orgtest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfromationPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPage;
import com.crm.generic.baseUtility.BaseClassMain;

//@Listeners(com.comcast.crm.listnerutility.ListnerImplClass.class)
public class CreateOrganizationTest extends BaseClassMain {

	@Test(groups = "SmokeTest")
	public void OrganizationTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
		// Read testScript data from excel
		String orgName = elib.getDataFromExcel("Org", 1, 2) + jlib.getRandomNumber();

		// Navigate to Organization page
		HomePage hp = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization Page");
		hp.getOrgLink().click();

		// Click on organization module
		OrganizationsPage op = new OrganizationsPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Organization Page");
		op.getcreateOrg().click();

		// Enter Organization details
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Create new Organization");
		cnop.orgNameEdt().sendKeys(orgName);
		cnop.saveBtn().click();

		// Verify header message expected message
		OrganizationInfromationPage oip = new OrganizationInfromationPage(driver);
		String actOrgName = oip.getheaderMsg().getText();

		boolean status = actOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		
	}

	@Test(groups = "RegressionTest")
	public void OrganizationWithIndustryTest() throws EncryptedDocumentException, IOException {
		String orgName = elib.getDataFromExcel("Org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("Org", 4, 3);
		String type = elib.getDataFromExcel("Org", 4, 4);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Click on create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getcreateOrg().click();

		// Enter mandatory fields and create new organization
		// Select value from drop down

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.orgNameEdt().sendKeys(orgName);
		wLib.select(cnop.industryDD(), industry);
		wLib.select(cnop.typeDD(), type);
		cnop.saveBtn().click();
	
		// Verify the industry drop down data
		String actualIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		
		Assert.assertEquals(actualIndustries, industry);

		// Verify the type drop down
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualType, type);
		

	}

	@Test(groups = "RegressionTest")
	public void OrganizationWithPhoneNumberTest() throws EncryptedDocumentException, IOException {
		String orgName = elib.getDataFromExcel("Org", 7, 2) + jlib.getRandomNumber();
		String phoneNumber = elib.getDataFromExcel("Org", 7, 3);

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Click on create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getcreateOrg().click();

		// Enter mandatory fields and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.orgNameEdt().sendKeys(orgName);
		cnop.phoneEdt().sendKeys(phoneNumber);
		cnop.saveBtn().click();

		// Verify the phone number
		String actualPhNo = driver.findElement(By.id("dtlview_Phone")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualPhNo, phoneNumber);
	}
}
