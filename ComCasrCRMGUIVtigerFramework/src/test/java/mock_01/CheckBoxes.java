package mock_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBoxes {
	@Test
	public void handlingChechboxes() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/checkbox?sublist=0");
		driver.findElement(By.xpath("//p[text()='1. On which platform would you like to receive notifications ?']/..//span[text()='Email']")).click();
		driver.findElement(By.xpath("//p[text()='2. Would you like to receive recommendations for similar products?']/..//span[text()='No thanks']")).click();
		
		driver.quit();
	}

}
