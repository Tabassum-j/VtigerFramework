package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerInfo;
	
	WebDriver driver;
	 public ProductInformationPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver,this);
	 }
	 
	 public WebElement getheaderInfo() {
		 return headerInfo;
	 }

}
