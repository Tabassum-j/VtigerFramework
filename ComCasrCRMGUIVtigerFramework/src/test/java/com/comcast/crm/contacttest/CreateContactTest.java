package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectRepositoryUtility.ContactSearchOrgPage;
import com.comcast.crm.objectRepositoryUtility.ContactsInformationPage;
import com.comcast.crm.objectRepositoryUtility.ContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfromationPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPage;
import com.crm.generic.baseUtility.BaseClassMain;

public class CreateContactTest extends BaseClassMain {

	@Test(groups = {"SmokeTest", "RegressionTest"})
	public void createContactTest() throws IOException {
		// Read data from Excel file
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		// Navigating to the contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on create module
		ContactsPage cp = new ContactsPage(driver);
		cp.createContact().click();

		// enter the last name
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getlastNameEdt().sendKeys(lastName);
		cncp.getsaveBtn().click();

		// Verify the last name
		
		
		  ContactsInformationPage cip = new ContactsInformationPage(driver); String
		  actLastName = cip.getheaderInfo().getText();
		 
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName,lastName);
	}

	@Test(groups = "RegressionTest")
	public void CreateContactWithOrgTest() throws EncryptedDocumentException, IOException {
		// Read testScript data from excel
		String orgName = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		String contactLastName = elib.getDataFromExcel("contact", 7, 3);

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Click on organization module
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getcreateOrg().click();

		// Click on create organization button
		// Enter mandatory fields and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.orgNameEdt().sendKeys(orgName);
		cnop.saveBtn().click();

		// Verify header expected result
		
		OrganizationInfromationPage oip = new OrganizationInfromationPage(driver);
		String headerInfo = oip.getheaderMsg().getText();
		boolean status = headerInfo.contains(orgName);
		Assert.assertEquals(status, true);

		String actualOrgName = oip.getorgMsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualOrgName, orgName);
		
		// Navigate to Contact module
		// Navigating to the contacts module and click on create module and enter the
		// last name

		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.createContact().click();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getlastNameEdt().sendKeys(contactLastName);
		cncp.getorgNameWidget().click();

		wLib.switchToTabOnUrl(driver, "Accounts");

		ContactSearchOrgPage csp = new ContactSearchOrgPage(driver);
		csp.getsearchEdt().sendKeys(orgName);
		csp.getsearchBtn().click();

		driver.findElement(By.linkText("" + orgName + "")).click();

		wLib.switchToTabOnUrl(driver, "Contacts&action");

		String cOrgName = cncp.getorgNameEdt().getText();

		soft.assertEquals(cOrgName, orgName);
	
		cncp.getsaveBtn().click();
		
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		String contact = cip.getheaderInfo().getText();
		boolean res = contact.contains(contactLastName);
		soft.assertEquals(res, true);
		
	}

	@Test(groups = "RegressionTest")
	public void CreateContactWithSupportDateTest() throws IOException {

		String lastName = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
		String startDate = jlib.getSystemDateYYYYMMDD();
		String endDate = jlib.getRequiredDateYYYYMMDD(30);

		// Navigating to the contacts module and click on create module and enter the
		// last name

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

		// Verify start date
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		String actStartDate = cip.getreflectStrt().getText();
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actStartDate, startDate);
		
		// Verify the end date
		
		 String actLastDate = cip.getreflectEnd().getText();
		 soft.assertEquals(actLastDate, endDate);
		
	}

}
