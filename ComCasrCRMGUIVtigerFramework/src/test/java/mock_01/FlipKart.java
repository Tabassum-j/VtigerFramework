package mock_01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipKart {
@Test
public void displayDropdownData() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.flipkart.com/");
	Thread.sleep(2000);
	Actions action = new Actions(driver);
	WebElement eleModule = driver.findElement(By.xpath("//span[text()='Electronics']"));
	action.moveToElement(eleModule).perform();
	
	List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_16rZTH']"));
	for(WebElement eles:elements) {
		System.out.println(eles.getText());
	}
	WebElement audio = driver.findElement(By.xpath("//a[text()='Audio']"));
	action.moveToElement(audio).perform();
	List<WebElement> audioeles = driver.findElements(By.xpath("//div[@class='_31z7R_']"));
	for(WebElement aeles:audioeles) {
		System.out.println(aeles.getText());
	}
	WebElement camera = driver.findElement(By.linkText("Cameras & Accessories"));
	action.moveToElement(camera).perform();
	List<WebElement> cameraeles = driver.findElements(By.xpath("//div[@class='_31z7R_']"));
	for(WebElement celes:cameraeles) {
		System.out.println(celes.getText());
	}
	
	driver.quit();
	
}
}
