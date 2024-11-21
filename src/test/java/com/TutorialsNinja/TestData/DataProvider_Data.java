package com.TutorialsNinja.TestData;

import org.testng.annotations.DataProvider;

public class DataProvider_Data {

	@DataProvider(name = "TNLogin")
	public Object[][] getLOginData() {
		
		Object[][] getData = {{"ummeahmed@gmail.com", "Umme@2111"},
							  {"ummeahmed1@gmail.com", "Umme@2111"},
							  {"ummeahmed2@gmail.com", "Umme@2111"}};
		return getData;	
		
	}
	
	@DataProvider(name = "TNRegister")
	public Object[][] getRegisterData() {
		
		Object[][] getData = {{"Umme", "Ahmed", "9876543", "Umme@2111", "Umme@2111"},
							  {"Umme", "Ahmed", "9876543", "Umme@2111", "Umme@2111"},
							  {"Umme", "Ahmed", "9876543", "Umme@2111", "Umme@2111"}};
		
		return getData;
		
	}
	

}

