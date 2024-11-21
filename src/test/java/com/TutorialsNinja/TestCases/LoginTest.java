package com.TutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialsNinja.Pages.AccountPage;
import com.TutorialsNinja.Pages.LandingPage;
import com.TutorialsNinja.Pages.LoginPage;
import com.TutorialsNinja.TestBase.TestBase;
import com.TutorialsNinja.TestData.DataProvider_Data;

public class LoginTest extends TestBase{

	public LoginTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingPage;
	public LoginPage loginPage;
	public AccountPage accountPage;
	
	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropdown();
		landingPage.clickOnLoginOption();
	}
	
	@Test(dataProvider = "TNLogin", dataProviderClass = DataProvider_Data.class)
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.validateDisplayStatusOfLogoutLink());
		
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
