package TestPackages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PagesPackages.CheckOutCompletePage;
import PagesPackages.CheckOutOverViewPage;
import PagesPackages.CheckoutYourInformation;
import PagesPackages.HomePage;
import PagesPackages.ProductsPage;
import PagesPackages.YourCart;
import UtilityPackage.ConfigProperty;
import UtilityPackage.DriverActionUtility;
import UtilityPackage.DriverFactory;

public class TestAddToCart {
	WebDriver driver;
	DriverActionUtility driverAction;
	@BeforeMethod
	public void setUp() {
		String browser = ConfigProperty.getKeyValue("browserName"); //No need to create an object of static method
		DriverFactory driverFactory = new DriverFactory(); //Object Creation of DriverFactory Class
		driver = driverFactory.browserFactory(browser);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
    public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {			
		driverAction.screenShots();
		}  
		driver.quit(); 
	}
	

	@Test (priority=1)
	//Test to purchase single product
	public void purchaseSingleProduct() {
		driverAction = new DriverActionUtility(driver);
		HomePage homePage = new HomePage(driverAction);
		ProductsPage productPageObj = homePage.Login();
		YourCart yourCartObj = productPageObj.addToCart("Backpack");
		CheckoutYourInformation checkOutInformationObj = yourCartObj.clickOnCheckout();
		CheckOutOverViewPage overviewPageObj= checkOutInformationObj.fillUpCheckoutInformationAndClikOnClickOnContinueButton();
		CheckOutCompletePage checkOutCompletePageObj = overviewPageObj.clickOnFinishButton();
		String text = checkOutCompletePageObj.getThankYouText();
		Assert.assertEquals(text, "THANK YOU FOR YOUR ORDER");
				
	} 
	
	@Test
	//Test to purchase multiple products
	public void purchaseMultipleProduct() {
		DriverActionUtility driverAction = new DriverActionUtility(driver);
		HomePage homePage = new HomePage(driverAction);
		ProductsPage productPageObj = homePage.Login();
		String[] vegList = {"Backpack","Bike","Jacket"};
		productPageObj.addMultipleItemToCart(vegList);
		int count = productPageObj.checkCartItemCount();
		Assert.assertEquals(count, 3);
		YourCart yourCartObj = productPageObj.clickOnCart();
		CheckoutYourInformation checkOutInformationObj = yourCartObj.clickOnCheckout();
		CheckOutOverViewPage overviewPageObj= checkOutInformationObj.fillUpCheckoutInformationAndClikOnClickOnContinueButton();
		CheckOutCompletePage checkOutCompletePageObj = overviewPageObj.clickOnFinishButton();
		String text = checkOutCompletePageObj.getThankYouText();
		Assert.assertEquals(text, "THANK YOU FOR YOUR ORDER");
		
		
	} 
}
