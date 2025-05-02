package practice.TestNg;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		
		//Step-1:Create object of EventFiring WebDriver
		//EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/test.png");
	    FileUtils.copyFile(src, dest);
	    driver.quit();
		
	}

}
