package practice.TestNg;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.generic.baseUtility.BaseClassMain;

public class SampleReportTest extends BaseClassMain {
	@Test
	public void demoSampleReportTest() {
		
		ExtentTest test = report.createTest("demoSampleReportTest");
		
		test.log(Status.INFO,"Launch the browser");
		test.log(Status.INFO,"Enter the URL");
		test.log(Status.INFO,"Login to the application");
		test.log(Status.INFO,"Navigate to contact page");
		test.log(Status.INFO,"Create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"Contact created");
		}else {
			test.log(Status.FAIL,"Contact not created");
		}
		
		test.log(Status.INFO,"Logout of the application");
	}
	
	@Test
	public void createContactWithOrg() {
		
    ExtentTest test = report.createTest("demoSampleReportTest");
		
		
		test.log(Status.INFO,"Launch the browser");
		test.log(Status.INFO,"Enter the URL");
		test.log(Status.INFO,"Login to the application");
		test.log(Status.INFO,"Navigate to contact page");
		test.log(Status.INFO,"Create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"Contact created");
		}else {
			test.log(Status.FAIL,"Contact not created");
		}
	
		test.log(Status.INFO,"Logout of the application");
	}

@Test
public void createContactWithPhoneNumber() {
	
	TakesScreenshot ts =  (TakesScreenshot)driver;
	String src=ts.getScreenshotAs(OutputType.BASE64);
		
	ExtentTest test = report.createTest("demoSampleReportTest");
		
	test.log(Status.INFO,"Launch the browser");
	test.log(Status.INFO,"Enter the URL");
	test.log(Status.INFO,"Login to the application");
	test.log(Status.INFO,"Navigate to contact page");
	test.log(Status.INFO,"Create contact");
	
	if("HDFC".equals("HDFC1")) {
		test.log(Status.PASS,"Contact created");
	}else {
		test.log(Status.FAIL,"Contact not created");
		test.addScreenCaptureFromBase64String(src, "ErrorFile");
	}
	test.log(Status.INFO,"Logout of the application");
}
}


