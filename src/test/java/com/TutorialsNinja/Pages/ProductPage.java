package com.TutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement HPLaptop;	
	
	@FindBy(linkText = "HP LP3065")
	private WebElement HPLP3065;
	
	
	public ProductPage(WebDriver driver) {
		this.driver	= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean displayStatusOfHPLaptop() {
		boolean status = HPLaptop.isDisplayed();
		return status;
	}
	
	public void clickOnHPLP3065() {
		HPLP3065.click();
	}

}
