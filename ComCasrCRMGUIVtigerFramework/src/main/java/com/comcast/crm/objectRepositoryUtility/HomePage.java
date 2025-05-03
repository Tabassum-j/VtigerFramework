package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "Organizations") // 2. Object creation
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicketLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(id = "more")
	private WebElement campaignLink;
	
	@FindBy(linkText = "Dashboard")
	private WebElement dashBoardLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);  // 3. Object initialization-->Constructor	
	}

	public WebElement getOrgLink() {           // 4. Encapsulation
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getDashboardLink() {
		return dashBoardLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getTroubleTicketLink() {
		return troubleTicketLink;
	}
	
	public WebElement campaignLink() {
		return campaignLink;
	}
	
	public WebElement adminImg() {
		return adminImg;
	}
	
	public WebElement signOut() {
		return signOut;
	}
	
	public void navigateCampaignPage() {
		Actions action = new Actions(driver);
		action.moveToElement(moreLink).perform();
		campaignLink.click();
	}
   
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOut.click();
	}
	// 5. Business Library-->If multiple action are  present. There is only one action here(i,e: click on link)
}
