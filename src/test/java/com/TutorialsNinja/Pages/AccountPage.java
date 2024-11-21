package com.TutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	public WebDriver driver;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;	
	
	public AccountPage(WebDriver driver) {
		this.driver	= driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateDisplayStatusOfLogoutLink() {
		boolean status = logoutLink.isDisplayed();
		return status;
	}
	
	
	
}
