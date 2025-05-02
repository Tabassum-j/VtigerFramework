package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewDocumentPage {
	@FindBy(xpath = "//input[@name='notes_title']")
	WebElement title;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveBtn;
	
	WebDriver driver;
  public CreatingNewDocumentPage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  public WebElement gettitle() {
	  return title;
  }
  
  public WebElement getsaveBtn() {
	  return saveBtn;
  }

}
