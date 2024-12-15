package com.TutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialsNinja.Pages.AddToCartPage;
import com.TutorialsNinja.Pages.LandingPage;
import com.TutorialsNinja.Pages.ProductPage;
import com.TutorialsNinja.TestBase.TestBase;

public class CheckOutTest extends TestBase{

	public CheckOutTest() throws Exception {
		super();
		
	}

	public WebDriver driver;
	public LandingPage landingPage;
	public ProductPage productPage;
	public AddToCartPage addToCartPage;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
	}
	
	@Test
	public void validateCorrectProductPurchased() {
		landingPage = new LandingPage(driver);
		landingPage.enterValidProduct(prop.getProperty("validProduct"));
		landingPage.clickOnSearchButton();
		productPage = new ProductPage(driver);
		Assert.assertTrue(productPage.displayStatusOfHPLaptop());
		productPage.clickOnHPLP3065();
		addToCartPage = new AddToCartPage(driver);
		addToCartPage.clickOnAddToCartButton();
		Assert.assertTrue(addToCartPage.validateCorrectProductSuccessMessage());
		addToCartPage.clickOnCheckoutButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
