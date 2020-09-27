package PagesPackages;

import org.openqa.selenium.By;

import UtilityPackage.DriverActionUtility;

public class CheckOutCompletePage {
	
	By thankYouText = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
	
	DriverActionUtility driverAction;
	
	public CheckOutCompletePage (DriverActionUtility webdriver) {
		driverAction = webdriver;
	}
	
	public String getThankYouText() {
		String text = driverAction.getYourText(thankYouText);
		return text;
		
	}

}
