package practice.TestNg;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.generic.baseUtility.BaseClass;

public class ListnerInvoiceTest extends BaseClass{
	@Test
	public void createInvoiceTest() {
		System.out.println("Execute createInvoiceTest");
		@Nullable
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
@Test
public void createInvoicewithContactTest() {
	System.out.println("Execute createInvoicewithContactTest");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
}
//@Test(retryAnalyzer = com.comcast.crm.listnerutility.RetryListnerImp.class)
public void activateSim() {
	String actTitle = driver.getTitle();
	System.out.println(actTitle);
	Assert.assertEquals("", "Login");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
}
	
}
