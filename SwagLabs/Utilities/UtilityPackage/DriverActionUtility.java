package UtilityPackage;



import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

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
	
	public void screenShots() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			Random random = new Random();
			int screenshot = random.nextInt(1000);
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\test-output\\Screenshots\\"+screenshot+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screenshot" +e.getMessage());
		}
		
		
	}  
}
