package com.TutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialsNinja.Pages.AccountSuccessPage;
import com.TutorialsNinja.Pages.LandingPage;
import com.TutorialsNinja.Pages.RegisterPage;
import com.TutorialsNinja.TestBase.TestBase;
import com.TutorialsNinja.TestData.DataProvider_Data;
import com.TutorialsNinja.Utilities.Utils;

public class RegisterTest extends TestBase {
	
public RegisterTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingPage;
	public RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);		
		landingPage.clickOnMyAccountDropdown();
		landingPage.clickOnRegisterOption();
	}
	
	@Test(dataProvider = "TNRegister", dataProviderClass = DataProvider_Data.class)
	public void verifyRegisterWithAllDetails(String firstname, String lastname, String telephone, String password, String confirmPassword) {
		
		registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(firstname);
		registerPage.enterLastName(lastname);
		registerPage.enterEmail(Utils.emailWithDateTimeStamp());
		registerPage.enterTelephone(telephone);
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(confirmPassword);
		registerPage.selectYesSubscribeRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.clickOnContinueButton();		
		accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.displayStatusOfAccountSuccess());
				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
