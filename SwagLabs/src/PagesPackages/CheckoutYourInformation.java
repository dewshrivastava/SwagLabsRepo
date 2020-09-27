package PagesPackages;


import org.openqa.selenium.By;

import UtilityPackage.DriverActionUtility;

public class CheckoutYourInformation {
	
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By postalCode = By.id("postal-code");
	By continueButton = By.cssSelector("input[value='CONTINUE']");
	By errorButton = By.className("error-button");
	
	DriverActionUtility driverAction;
	
	public CheckoutYourInformation(DriverActionUtility webdriver) {
		driverAction = webdriver;
	}

	//Method to provide FirstName
	public CheckOutOverViewPage fillUpCheckoutInformationAndClikOnClickOnContinueButton() {
		driverAction.sendKeys(firstName, "Test");
		driverAction.sendKeys(lastName, "User");
		driverAction.sendKeys(postalCode, "382007");	
		driverAction.clickOnButton(continueButton);
    	CheckOutOverViewPage overviewPageObj = new CheckOutOverViewPage(driverAction);
    	return overviewPageObj;
	}

    public Boolean clickOnContinueButtonWithoutUserDetails () {
    	driverAction.clickOnButton(continueButton);
    	driverAction.driver.findElement(errorButton);
    	return true;
	
    }
}
