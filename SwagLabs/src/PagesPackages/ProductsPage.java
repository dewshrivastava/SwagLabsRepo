package PagesPackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import UtilityPackage.DriverActionUtility;

public class ProductsPage {
	
	By cart = By.id("shopping_cart_container");
	By items = By.cssSelector("div.inventory_item_name");
	By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	By cartItemCount = By.xpath("//*[@id='shopping_cart_container']/a/span");
	
	
	
	DriverActionUtility driverAction;
	
	
	public ProductsPage(DriverActionUtility webdriver) {
		driverAction = webdriver;
		driverAction.waitTillVisible(cart);
	}
	
	public YourCart addToCart(String product) {
		List<WebElement> products = driverAction.driver.findElements(items);
		
		for(int i = 0;i<products.size();i++) {
			String productsText = products.get(i).getText();
			
			if(productsText.contains(product)){
				driverAction.driver.findElements(addToCartButton).get(i).click();
				break;
			}
					
		}		
		driverAction.driver.findElement(cart).click();
		YourCart yourCartObj = new YourCart(driverAction);
		return yourCartObj;			
	}
		

	public void addMultipleItemToCart(String[] vegList) {
		
		List<WebElement> products = driverAction.driver.findElements(items);
		
		for(int i = 0;i<products.size();i++) {
			String productsText = products.get(i).getText();
			for(int j=0;j<vegList.length;j++) {
				if(productsText.contains(vegList[j])){
					driverAction.driver.findElements(addToCartButton).get(i).click();
					break;
				}
			}
								
		}	
	}		
		
	public YourCart clickOnCart() {
		driverAction.driver.findElement(cart).click();
		YourCart yourCartObj = new YourCart(driverAction);
		return yourCartObj;			
	}
	
	public int checkCartItemCount() {
		String count = driverAction.getYourText(cartItemCount);
		int itemCount = Integer.parseInt(count);
		return itemCount;
				
	}
	
	
	public Boolean waitTillElementVisible() {
		driverAction.waitTillVisible(cart);
		return true;
	}


	
}

