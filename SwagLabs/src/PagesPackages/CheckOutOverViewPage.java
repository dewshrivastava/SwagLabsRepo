package PagesPackages;

import org.openqa.selenium.By;

import UtilityPackage.DriverActionUtility;

public class CheckOutOverViewPage {
	
	By overView = By.className("subheader");
	By finishButton =  By.xpath("//a[text()='FINISH']");
	By cancelButton = By.className("cart_cancel_link btn_secondary");
	
    DriverActionUtility driverAction;
	
	public CheckOutOverViewPage(DriverActionUtility webdriver) {
		driverAction = webdriver;
		
		// To wait till elements get loaded
		driverAction.waitTillVisible(overView);
	}
	
	public CheckOutCompletePage clickOnFinishButton() {
		driverAction.clickOnButton(finishButton);
		CheckOutCompletePage checkOutCompletePageObj = new CheckOutCompletePage(driverAction);
		return checkOutCompletePageObj;
	}
	
	public void clickOnCancelButton() {
		driverAction.clickOnButton(cancelButton);
	}
	
}
