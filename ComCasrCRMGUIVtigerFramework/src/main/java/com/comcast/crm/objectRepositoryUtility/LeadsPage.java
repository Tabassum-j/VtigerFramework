package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement addLead;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchDD;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;
	
	WebDriver driver;
	
	public WebElement getaddLead() {
		return addLead;
	}
	
	public WebElement getsearchDD() {
		return searchDD;
	}
	
	public WebElement getsearchEdt() {
		return searchEdt;
	}
	
	public WebElement getsearchBtn() {
		return searchBtn;
	}
	 
	public LeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
