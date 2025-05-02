package practice.TestNg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class AmazonDataProviderTest {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung", Keys.ENTER);
		String price=driver.findElement(By.xpath("//span[contains (text(), '"+productName+"')]/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span/span[2]")).getText();
		//Capture Product info
		System.out.println(price);
		driver.quit();
	}
		
 @DataProvider
 public Object[][] getData() throws IllegalStateException, IOException{
 ExcelUtility eLib = new ExcelUtility();
 int rowCount = eLib.getRowCount("ProductData");
 int cellCount = eLib.getCellCount("ProductData",rowCount);
 
 Object[][] objArr = new Object[rowCount-1][cellCount];
 
 for(int i=0; i<rowCount-1; i++) {
	 for(int j=0;j<cellCount; j++) {
	 objArr[i][j] = eLib.getDataFromExcel("ProductData",(i+1), j);
	 objArr[i][j] = eLib.getDataFromExcel("ProductData",(i+1), j);
 }
 }
 return objArr;
 }
}

