package com.comcast.crm.contacttest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.objectRepositoryUtility.ContactSearchOrgPage;
import com.comcast.crm.objectRepositoryUtility.ContactsInformationPage;
import com.comcast.crm.objectRepositoryUtility.ContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfromationPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPage;
import com.crm.generic.baseUtility.BaseClass;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void ContactWithOrgTest() throws EncryptedDocumentException, IOException {

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

		// Verify header expected result
		// String headerInfo =
		// driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		OrganizationInfromationPage oip = new OrganizationInfromationPage(driver);
		String headerInfo = oip.getheaderMsg().getText();

		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " is created==>PASS");
		} else {
			System.out.println(orgName + " is not created==>FAIL");
		}

		String actualOrgName = oip.getorgMsg().getText();

		if (actualOrgName.equals(orgName)) {
			System.out.println(orgName + "information is created==>PASS");
		} else {
			System.out.println(orgName + "information is not created==>FAIL");
		}

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

		// String cOrgName =
		// driver.findElement(By.xpath("//input[@name='account_name']")).getText();
		String cOrgName = cncp.getorgNameEdt().getText();

		if (cOrgName.equals(orgName)) {
			System.out.println(orgName + " information is copied");
		} else {
			System.out.println(orgName + " information is not copied");
		}

		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		cncp.getsaveBtn().click();
		// String contact =
		// driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		ContactsInformationPage cip = new ContactsInformationPage(driver);
		String contact = cip.getheaderInfo().getText();
		if (contact.contains(contactLastName)) {
			System.out.println(contactLastName + " is created");
		} else {
			System.out.println(contactLastName + " is not created");
		}
	}
}