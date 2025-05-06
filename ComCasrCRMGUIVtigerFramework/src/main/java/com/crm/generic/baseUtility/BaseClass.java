package com.crm.generic.baseUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.HomePage;
//import com.comcast.crm.objectRepositoryUtility.LoginPage;

public class BaseClass {
	
	public DatabaseUtility dbutil = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public	JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wLib= new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeSuite() throws SQLException {
		System.out.println("Connected to Database");
		dbutil.getDbConnection();
		
	}
	@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeClass(String browser) throws IOException {
		System.out.println("Launched the browser");
		String BROWSER=browser;//flib.getDataFromPropertiesFile("browser");
         if(BROWSER.equalsIgnoreCase("chrome")) {
        	 driver = new ChromeDriver();
         }else if(BROWSER.equalsIgnoreCase("edge")) {
        	 driver = new EdgeDriver();
         }else {
        	 driver = new ChromeDriver();
         }
         sdriver=driver;
         UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configBM() throws IOException {
		System.out.println("Login to application");
		//LoginPage lp = new LoginPage(driver);
		/*
		 * String URL = flib.getDataFromPropertiesFile("url"); String USERNAME =
		 * flib.getDataFromPropertiesFile("username"); String PASSWORD =
		 * flib.getDataFromPropertiesFile("password"); lp.loginToapp(URL,USERNAME ,
		 * PASSWORD);
		 */
		String URL = System.getProperty("url",flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password",flib.getDataFromPropertiesFile("password"));
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
	}
	@AfterMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configAM() {
		System.out.println("Logout to application");
		HomePage hp = new HomePage(driver);
		hp.logout();	
	}
	@AfterClass(groups = {"SmokeTest", "RegressionTest"})
	public void configAfterClass() {
		System.out.println("Close the browser");
		driver.quit();	
	}
	@AfterSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configAfterSuite() throws SQLException {
		System.out.println("Database connection closed");
		dbutil.closeDbConnection();
	}
}
