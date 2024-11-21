package com.TutorialsNinja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialsNinja.Pages.LandingPage;
import com.TutorialsNinja.Pages.ProductPage;
import com.TutorialsNinja.TestBase.TestBase;

public class SearchProductTest extends TestBase {

	public SearchProductTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingPage;
	public ProductPage productPage;
	
	@BeforeMethod
	public void searchProductSetup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));	
	}
	
	@Test
	public void verifySearchProductResult() {
		
		landingPage = new LandingPage(driver);
		landingPage.enterValidProduct(prop.getProperty("validProduct"));
		landingPage.clickOnSearchButton();
		
		productPage = new ProductPage(driver);
		Assert.assertTrue(productPage.displayStatusOfHPLaptop());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}