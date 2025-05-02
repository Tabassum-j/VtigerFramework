package assignment;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.objectRepositoryUtility.CreatingNewLeadPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LeadInformationPage;
import com.comcast.crm.objectRepositoryUtility.LeadsPage;
import com.crm.generic.baseUtility.BaseClassMain;

public class CreateLead extends BaseClassMain {
	
	@Test
	public void lead() throws EncryptedDocumentException, IOException {
	
			    
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
			    
	}

}
