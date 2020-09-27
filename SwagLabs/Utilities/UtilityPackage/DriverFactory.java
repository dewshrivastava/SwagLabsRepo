package UtilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public WebDriver browserFactory(String browserName) {
		
		WebDriver driver;
		
		switch(browserName){
		
		case "ChromeDriver":
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Resource\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "GeckoDriver":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resource\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		
		default:
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Resource\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		break; 
	
		}
		
		return driver;
	}

}
