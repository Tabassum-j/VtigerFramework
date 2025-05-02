package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfromationPage {
  WebDriver driver;
  
	@FindBy(className = "dvHeaderText")
    private WebElement headerMsg;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgMsg;
  

public OrganizationInfromationPage(WebDriver driver) {
	this.driver=driver;
    PageFactory.initElements(driver, this);	
}

public WebElement getheaderMsg() {
	return headerMsg;
}
 public WebElement getorgMsg() {
	 return orgMsg;
 }
}
