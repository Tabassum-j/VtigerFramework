package mock_01;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HotStar {
	@Test
	public void hoststarSS() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hotstar.com/in/home?ref=%2Fin");
		
		//driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//span[text()='Start Watching']")).click();
		
		Actions action = new Actions(driver);
		
		WebElement searchIcon = driver.findElement(By.xpath("//i[@class='icon-search-line soul-icon NAV_ICON_FONT_SIZE']"));
	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		action.moveToElement(searchIcon).perform();
		String links = driver.findElements(By.tagName("a")).toString();
		System.out.println(links);
		
		WebElement searchtxt = driver.findElement(By.xpath("//p[text()='Search']"));
		wait.until(ExpectedConditions.elementToBeClickable(searchtxt));

		WebDriverUtility wutil = new WebDriverUtility();
		wutil.javaScriptclickOnWE(driver, searchtxt);
		searchtxt.click();
		
		driver.findElement(By.id("searchBar")).sendKeys("Doraemon");
		driver.findElement(By.xpath("//img[@class='_4ItEW8qSnz_RP7nGOYW8j']")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/ScreenShot2.png");
		FileUtils.copyFile(src, dest);
		
		
		
		
		
		driver.quit();
	}

}
