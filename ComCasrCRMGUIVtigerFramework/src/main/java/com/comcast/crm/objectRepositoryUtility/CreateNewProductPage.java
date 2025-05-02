package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	@FindBy(name = "productname")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	 public WebElement getproductName() {
		 return productName;
	 }
	 public WebElement getsaveBtn() {
		 return saveBtn;
	 }
	

}
