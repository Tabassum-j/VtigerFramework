package assignment;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.objectRepositoryUtility.CreateNewTroubleTicketPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.TroubleTicketInformationPage;
import com.comcast.crm.objectRepositoryUtility.TroubleTicketPage;
import com.crm.generic.baseUtility.BaseClassMain;

public class CreateTroubleTicket extends BaseClassMain {
	
	@Test
	public void createTicket() throws IOException {

		
		String TITLE = elib.getDataFromExcel("Sheet1", 1, 2);
		
			            
			    //Navigate to trouble ticket module   
			    HomePage hp = new HomePage(driver);
			    hp.getTroubleTicketLink().click();
			    //Click on add new trouble ticket
			   
			    TroubleTicketPage ttp = new TroubleTicketPage(driver);
			    ttp.getcreateTT().click();
			    
			    
			    //Enter the text in title 
			    CreateNewTroubleTicketPage cntp = new CreateNewTroubleTicketPage(driver);
			    cntp.getnewTT().sendKeys(TITLE);
			    
			    //Save
			    cntp.getsaveBtn().click();
			    
			    //Verify
			    TroubleTicketInformationPage ttip = new TroubleTicketInformationPage(driver);
			    String actTitle = ttip.getheaderInfo().getText();
			    
			   boolean status = actTitle.contains(TITLE);
			   Assert.assertEquals(status, true);
			   
	}
}