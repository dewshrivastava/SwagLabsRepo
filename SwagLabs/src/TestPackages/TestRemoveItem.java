package TestPackages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesPackages.HomePage;
import PagesPackages.ProductsPage;
import PagesPackages.YourCart;
import UtilityPackage.ConfigProperty;
import UtilityPackage.DriverActionUtility;
import UtilityPackage.DriverFactory;

public class TestRemoveItem {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		String browser = ConfigProperty.getKeyValue("browserName"); //No need to create an object of static method
		DriverFactory driverFactory = new DriverFactory(); //Object Creation of DriverFactory Class
		driver = driverFactory.browserFactory(browser);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	//To remove selected product
	public void removeProduct() {
		DriverActionUtility driverAction = new DriverActionUtility(driver);
		HomePage homePage = new HomePage(driverAction);
		ProductsPage productPageObj = homePage.Login();
		String[] vegList = {"Backpack","Bike","Jacket"};
		productPageObj.addMultipleItemToCart(vegList);
		int count = productPageObj.checkCartItemCount();
		Assert.assertEquals(count, 3);
		YourCart yourCartObj = productPageObj.clickOnCart();
		yourCartObj.clickOnRemoveButton();
		ProductsPage productPage = yourCartObj.clickOnContinueShopping();
		int latestCount = productPage.checkCartItemCount();
		Assert.assertEquals(latestCount, 2);
		
	}
	

}
