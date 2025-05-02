package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {
	@FindBy(xpath = "//img[@title='Create Ticket...']")
	private WebElement createTT;
	
	WebDriver driver;
	public TroubleTicketPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);  	
	}
	
	public WebElement getcreateTT () {       
		return createTT;
	}
	

}
