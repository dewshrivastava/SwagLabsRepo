package UtilityPackage;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverActionUtility {
	
	public WebDriver driver;
	public DriverActionUtility(WebDriver webDriver) {
		driver = webDriver;
	}
    
	//Method to enter text into text box
	public void sendKeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);		
	}
	
	//Method to click on button
	public void clickOnButton(By locator) {
		driver.findElement(locator).click();
	}
	
	//Method to wait till item visible
	public void waitTillVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public String getYourText(By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}
	
	
	/*
	//Method to store webElements in list
	public List<WebElement> storeList(By locator) {
		driver.findElements(locator);
		}  */
}
