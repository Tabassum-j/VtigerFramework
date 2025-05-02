package assignment;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.objectRepositoryUtility.CreatingNewDocumentPage;
import com.comcast.crm.objectRepositoryUtility.DocumentInformationPage;
import com.comcast.crm.objectRepositoryUtility.DocumentsPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.crm.generic.baseUtility.BaseClassMain;

public class CreateNewDocumentTest extends BaseClassMain {
	@Test
	public void createDocument() {

		String title = null;
	
			    try {
			    	title=elib.getDataFromExcel("Products", 3, 2);
			    } catch(Exception e) { 
			    	
			    }
			  
			    HomePage hp = new HomePage(driver);
			    hp.getDocumentsLink().click();
			    
			    DocumentsPage dp = new DocumentsPage(driver);
			    dp.getcreateDocument().click();
			    CreatingNewDocumentPage cnd = new CreatingNewDocumentPage(driver);
			    
			    cnd.gettitle().sendKeys(title);
			    cnd.getsaveBtn().click();
			  
			    DocumentInformationPage dip = new DocumentInformationPage(driver);
			    String actTitle = dip.getheaderInfo().getText();
			    
			    boolean status = actTitle.contains(title);
			    Assert.assertEquals(status, true);
				
	}

}
