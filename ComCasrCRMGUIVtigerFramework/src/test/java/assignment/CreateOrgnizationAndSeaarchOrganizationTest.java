package assignment;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPage;
import com.crm.generic.baseUtility.BaseClassMain;

public class CreateOrgnizationAndSeaarchOrganizationTest extends BaseClassMain{
	
	@Test
	public void createOrganizationAndSearch() throws EncryptedDocumentException, IOException {
		

		
		String orgName = elib.getDataFromExcel("Org", 1, 2) + jlib.getRandomNumber();
		
			    //Navigate to Organization page
			    HomePage hp = new HomePage(driver);
			    hp.getOrgLink().click();
			    
			    //Click on organization module
			    OrganizationsPage op = new OrganizationsPage(driver);
			    op.getcreateOrg().click();	
			   
			    //Enter Organization details
			    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			    cnop.orgNameEdt().sendKeys(orgName);
			    cnop.saveBtn().click();
			   
			    //Click on organization module link
			    hp.getOrgLink();
			    
			    //Select from drop down
			    WebElement we = op.getsearchDD();
			    Select sel = new Select(we);
			    sel.selectByVisibleText("Organization Name");
			    
			    //Enter the org name to be searched in text field
			    op.getsearchtxtfld().sendKeys(orgName);
			    
			    //Click on search now button
			    op.getsubmitBtn().click();
			    
			    //Verify 
			    String actOrgName = driver.findElement(By.linkText(""+orgName+"")).getText();
			    Assert.assertEquals(actOrgName, orgName);
			   
	}

}
