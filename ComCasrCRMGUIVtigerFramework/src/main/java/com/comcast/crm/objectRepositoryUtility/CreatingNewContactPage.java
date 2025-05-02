package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement sprtEndDate;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement sprtStartDate;
	 
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameWidget;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name ="account_name")
	private WebElement orgNameEdt;
	
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getlastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getsprtEndDate() {
		return sprtEndDate;
	}
	
	public WebElement getsprtStartDate() {
		return sprtStartDate;
	}
	
	public WebElement getorgNameWidget() {
		return orgNameWidget;
	}
	
	public WebElement getsaveBtn() {
		return saveBtn;
	}
	
	public WebElement getorgNameEdt() {
		return orgNameEdt;
	}

}
