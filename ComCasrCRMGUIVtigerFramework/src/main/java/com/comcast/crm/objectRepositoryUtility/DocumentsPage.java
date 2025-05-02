package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {
  @FindBy(xpath = "//img[@title='Create Document...']")
  private WebElement createDocument;
  
  WebDriver driver;
  public DocumentsPage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  public WebElement getcreateDocument () {
	  return createDocument;
  }
  
}
