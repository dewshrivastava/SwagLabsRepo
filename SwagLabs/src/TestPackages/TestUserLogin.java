package TestPackages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesPackages.HomePage;
import PagesPackages.ProductsPage;
import UtilityPackage.ConfigProperty;
import UtilityPackage.DriverActionUtility;
import UtilityPackage.DriverFactory;

public class TestUserLogin {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		String browser = ConfigProperty.getKeyValue("browserName"); //No need to create an object of static method
		DriverFactory driverFactory = new DriverFactory(); //Object Creation of DriverFactory Class
		driver = driverFactory.browserFactory(browser);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
			
	}
	
	@AfterMethod
    public void tearDown(ITestResult result) {
		DriverActionUtility driverAction = new DriverActionUtility(driver);
		if(ITestResult.FAILURE==result.getStatus()) {			
		driverAction.screenShots();
		}  
		driver.quit(); 
	}
	
	@Test
	//Test to Login into application
	public void userLogin() {
		DriverActionUtility driverAction = new DriverActionUtility(driver);
		HomePage homePage = new HomePage(driverAction);
		ProductsPage productPageObj = homePage.Login();
		Boolean bool = productPageObj.waitTillElementVisible();
		Assert.assertTrue(bool);
		    	
		}
}
