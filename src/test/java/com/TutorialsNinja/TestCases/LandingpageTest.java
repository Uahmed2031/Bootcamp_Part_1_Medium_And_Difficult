package com.TutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialsNinja.Pages.LandingPage;
import com.TutorialsNinja.Pages.LoginPage;
import com.TutorialsNinja.TestBase.TestBase;


public class LandingpageTest extends TestBase{
	
	public LandingpageTest() throws Exception {
		super();
		
	}

	public WebDriver driver;
	public LandingPage landingPage;
	public LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
		
	}
	
	@Test
	public void navigateToDifferentPage() {
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropdown();
		landingPage.clickOnLoginOption();
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.displayReturningCustomerText());
	
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
