package PagesPackages;

import org.openqa.selenium.By;
import UtilityPackage.DriverActionUtility;

public class HomePage {
	
	By userName = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.xpath("//input[@value='LOGIN']");
	
	
	DriverActionUtility driverAction;
	
	public HomePage(DriverActionUtility driver) {
		driverAction = driver;
		
		driverAction.waitTillVisible(userName);
		
	}

	public ProductsPage Login(){
		driverAction.sendKeys(userName, "standard_user");
		driverAction.sendKeys(password, "secret_sauce");
		driverAction.clickOnButton(loginButton);
		ProductsPage productPageObj = new ProductsPage(driverAction);
		return productPageObj;
		
	}
	
}
