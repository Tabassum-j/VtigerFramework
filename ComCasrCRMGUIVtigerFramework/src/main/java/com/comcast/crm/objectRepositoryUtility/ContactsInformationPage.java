package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage {
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement reflectStrt;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement reflectEnd;
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerInfo;
	
	WebDriver driver;
	public ContactsInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getreflectStrt() {
		return reflectStrt;
	}
	
	public WebElement getreflectEnd() {
		return reflectEnd;
	}
	
	public WebElement getheaderInfo() {
		return headerInfo;
	}

}
