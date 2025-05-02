package mock_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShadowRootElement {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");
		
		driver.findElement(By.xpath("//h1[text()='Login']"));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("abcd").perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("1234").perform();
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.quit();
		
	}

}
