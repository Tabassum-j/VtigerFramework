package assignment;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.objectRepositoryUtility.CreateNewProductPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.ProductInformationPage;
import com.comcast.crm.objectRepositoryUtility.ProductsPage;
import com.crm.generic.baseUtility.BaseClassMain;

public class CreateProduct extends BaseClassMain {
	
	@Test
	public void product() throws EncryptedDocumentException, IOException {


		
			    String productName = elib.getDataFromExcel("Products",1 ,2);
			   
			    HomePage hp = new HomePage(driver);
			    hp.getProductLink().click();
			    
			    ProductsPage pp = new ProductsPage(driver);
			    pp.getcreateProduct().click();
			    
			    CreateNewProductPage cnp = new CreateNewProductPage(driver);
			   cnp.getproductName().sendKeys(productName);
			   cnp.getsaveBtn().click();
			    
			   ProductInformationPage cip = new ProductInformationPage(driver);
			   String actProductName = cip.getheaderInfo().getText();
			   
			   boolean status = actProductName.contains(productName);
			   Assert.assertEquals(status, true);
			            
	}

}
