package com.TutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//button[@id = 'button-cart']")
	private WebElement addToCartButton;	
	
	@FindBy(xpath = "//div[contains(text(), 'Success: You have added')]")
	private WebElement correctProductSuccessMessage;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutButton;
	
	
	public AddToCartPage(WebDriver driver) {
		this.driver	= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	
	public boolean validateCorrectProductSuccessMessage() {
		boolean status = correctProductSuccessMessage.isDisplayed();
		return status;
	}
	
	public void clickOnCheckoutButton() {
		checkoutButton.click();
	}

}
