package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;
	
	@FindBy(id = "phone")
	private WebElement phoneEdt;
	 
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")		//Object creation
	private WebElement saveBtn;
	  
	//Initialization 
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Encapsulation
   public WebElement  orgNameEdt() {
	   return orgNameEdt;
   }
   
   public WebElement saveBtn() {
	   return saveBtn;
   }
   
   public WebElement typeDD() {
	   return typeDD;
   }
   
   public WebElement industryDD() {
	   return industryDD;
   }
   
   public WebElement phoneEdt() {
	   return phoneEdt;
   }
   
   
}
