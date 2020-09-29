package PagesPackages;

import org.openqa.selenium.By;

import UtilityPackage.DriverActionUtility;

public class YourCart {
	
	By checkout = By.xpath("//a[text()='CHECKOUT']");
	By removeButton = By.xpath("//button[text()='REMOVE']");
	By continueShopping = By.xpath("//a[text()='Continue Shopping']");
	
	DriverActionUtility driverAction;
	
	public YourCart(DriverActionUtility webdriver) {
		driverAction = webdriver;
		driverAction.waitTillVisible(checkout);
	}
	
	//Method to click on Remove Button
	public void clickOnRemoveButton() {
		driverAction.clickOnButton(removeButton);
	}
	
	//Method to click on Continue Shopping Button
	public ProductsPage clickOnContinueShopping() {
		driverAction.clickOnButton(continueShopping);
		ProductsPage productPage = new ProductsPage(driverAction);
		return productPage;
	}
	
	
    // Method to click on Checkout
	public CheckoutYourInformation clickOnCheckout() {
	driverAction.clickOnButton(checkout);
	CheckoutYourInformation checkOutInformationObj = new CheckoutYourInformation(driverAction);
	return checkOutInformationObj;
	}
}