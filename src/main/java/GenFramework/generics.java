package GenFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class generics {
	public static void launchBrowser(WebDriver driver,String browserName , String url) {
		
	}
public static void getWebElement(WebDriver driver,String locatorType , String locatorValue) {
	if(locatorType.equalsIgnoreCase("xpath")) {
		driver.findElement(By.xpath(locatorValue));
	}else if(locatorType.equalsIgnoreCase("id")) {
		driver.findElement(By.id(locatorValue));
	}else if (locatorType.equalsIgnoreCase("linkText")) {
	  driver.findElement(By.linkText(locatorValue));
	} else if (locatorType.equalsIgnoreCase("name")) {
		 driver.findElement(By.name(locatorValue));
	} else if (locatorType.equalsIgnoreCase("tagName")) {
		 driver.findElement(By.tagName(locatorValue));
	} else if (locatorType.equalsIgnoreCase("class")) {
		 driver.findElement(By.className(locatorValue));
	} else if (locatorType.equalsIgnoreCase("css")) {
		 driver.findElement(By.cssSelector(locatorValue));
	}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
		 driver.findElement(By.partialLinkText(locatorValue));
	}else {
		System.out.println("Locator Type is wrong. please cheeck");
	}
	
}
public static void inputValue(WebDriver driver ) {
	
	
}
public static void checkElement() {
	
}
public static void toVerifyClick() {
	
}
public static void GenerateReport() {
	
}
public static void TakeSnapShot() {
	
}

}
