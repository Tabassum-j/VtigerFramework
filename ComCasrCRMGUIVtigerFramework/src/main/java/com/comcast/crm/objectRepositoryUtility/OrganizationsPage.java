package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")    //Object Creation
	 private WebElement createOrg;
	
	@FindBy(name = "search_text")
	private WebElement searchtxtfld;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchDD;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	WebDriver driver;
	
	public OrganizationsPage(WebDriver driver) {           //Initialization
		this.driver= driver;
	   PageFactory.initElements(driver, this);
	}
	
	public WebElement getcreateOrg() {					//Encapsulation
		return createOrg;
	}
	
	public WebElement getsearchtxtfld() {
		return searchtxtfld;
	}
	
	public WebElement getsearchDD() {
		return searchDD;
	}
	
	public WebElement getsubmitBtn() {
		return submitBtn ;
	}
}
