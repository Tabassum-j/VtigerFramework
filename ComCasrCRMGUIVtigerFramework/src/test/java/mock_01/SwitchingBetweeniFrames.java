package mock_01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingBetweeniFrames {
	@Test
	public void iFrames() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
		List<WebElement> iframeEles = driver.findElements(By.tagName("iframes"));
		System.out.println(iframeEles);
		WebElement iframeEle = driver.findElement(By.cssSelector("iframe"));
		driver.switchTo().frame(iframeEle);
		driver.findElement(By.id("email")).sendKeys("abcd@yahoo.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirm-password")).sendKeys("123456");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().parentFrame();
		System.out.println("Switched to parent frame");
		WebElement nestedIframe = driver.findElement(By.xpath("(//iframe[@class='w-full h-96'])[2]"));

		driver.switchTo().frame(nestedIframe);
		driver.findElement(By.id("username")).sendKeys("xyz");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
	}
}