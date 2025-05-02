package assignment;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectRepositoryUtility.CreatingNewLeadPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LeadInformationPage;
import com.comcast.crm.objectRepositoryUtility.LeadsPage;
import com.crm.generic.baseUtility.BaseClassMain;


public class CreateLeadAndSearchTheCreatedLeadTest extends BaseClassMain {
	
	@Test
	public void createLead() throws EncryptedDocumentException, IOException {

			    String lastName = elib.getDataFromExcel("Lead",1 ,2 );
			    String company = elib.getDataFromExcel("Lead", 1, 3);
			    
			    //Navigate to leads module
			    HomePage hp = new HomePage(driver);
			    hp.getLeadsLink().click();
			    //Click on new lead +
			    LeadsPage lp = new LeadsPage(driver);
			    lp.getaddLead().click();
			    
			    //Enter last name and company
			    CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
			    cnlp.getleadLastNameEdt().sendKeys(lastName);
			    cnlp.getcompanyEdt().sendKeys(company);
			  
			    //Click on save button
			    cnlp.getsaveBtn().click();
			    //Verify
			    LeadInformationPage lip = new LeadInformationPage(driver);
			    String actLead = lip.getheaderInfo().getText();
			    
			   boolean status = actLead.contains(lastName);
			   Assert.assertEquals(status, true);
			   
				
			   //Clicks on leads module
			   hp.getLeadsLink().click();
			 
			 
			WebElement dd	= lp.getsearchDD();
			Select sel = new Select(dd);
				    sel.selectByVisibleText("Last Name");
				    lp.getsearchEdt().sendKeys(lastName);
				    lp.getsearchBtn().click();
				    //driver.findElement(By.name("submit")).click();
				   
			   driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();
			 
			   
			   String actLastName = driver.findElement(By.linkText(""+lastName+"")).getText();
			   SoftAssert soft = new SoftAssert();
			   soft.assertEquals(actLastName, lastName);    
			driver.quit();    


	}

}
