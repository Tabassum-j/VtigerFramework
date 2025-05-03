package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	@FindBy(id = "dashboard_combo")
	private WebElement dashboardDD;
	
	public WebElement getDashboardDD() {
		return dashboardDD;
	}
	public void dashboardPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

}
