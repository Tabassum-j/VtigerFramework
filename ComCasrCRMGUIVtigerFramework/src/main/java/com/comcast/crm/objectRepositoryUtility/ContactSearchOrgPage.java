package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactSearchOrgPage {
	
	@FindBy(id = "search_txt")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	WebDriver driver;
	
	public ContactSearchOrgPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getsearchEdt() {
		return searchEdt;
	}
	
	public WebElement getsearchBtn() {
		return searchBtn;
	}

}
