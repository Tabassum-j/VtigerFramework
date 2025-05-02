package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTroubleTicketPage {
	@FindBy(name = "ticket_title")
	private WebElement newTT;
	 
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	WebDriver driver;
	public CreateNewTroubleTicketPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);  	
	}
	public WebElement getnewTT() {
		return newTT;
	}
	
	public WebElement getsaveBtn() {
		return saveBtn;
	}
	

}
