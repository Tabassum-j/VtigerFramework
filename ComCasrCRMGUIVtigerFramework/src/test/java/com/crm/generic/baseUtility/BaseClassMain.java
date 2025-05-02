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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;

public class BaseClassMain {
	
	public DatabaseUtility dbutil = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public	JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wLib= new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public ExtentReports report;
	public ExtentSparkReporter spark;
	
	@BeforeSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeSuite() throws SQLException {
		System.out.println("Database Connected");
		dbutil.getDbConnection();
	}
	@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeClass() throws IOException {
		System.out.println("Launched the browser");
		String BROWSER = //browser;
				flib.getDataFromPropertiesFile("browser");
         if(BROWSER.equalsIgnoreCase("chrome")) {
        	 driver = new ChromeDriver();
         }else if(BROWSER.equalsIgnoreCase("edge")) {
        	 driver = new EdgeDriver();
         }else {
        	 driver = new ChromeDriver();
         }
         sdriver=driver;
	}
	@BeforeMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configBM() throws IOException {
		System.out.println("Login to application");
		LoginPage lp = new LoginPage(driver);
		String URL = flib.getDataFromPropertiesFile("url");
        String USERNAME = flib.getDataFromPropertiesFile("username");
        String PASSWORD = flib.getDataFromPropertiesFile("password");
		lp.loginToapp(URL,USERNAME , PASSWORD);
		
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
		System.out.println("Database closed");
		dbutil.closeDbConnection();
		
	}
}
