package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {
	
	@FindBy(name = "lastname")
	private WebElement leadLastNameEdt;
	
	@FindBy(name = "company")
	private WebElement companyEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	WebDriver driver;
	
	public CreatingNewLeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getleadLastNameEdt() {
		return leadLastNameEdt;
	}
	
	public WebElement getcompanyEdt() {
		return companyEdt;
	}
	
	public WebElement getsaveBtn() {
		return saveBtn;
	}
}
