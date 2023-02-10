package Vtiger_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_Utiles {
 public static WebDriver driver;
// public static ExtentTest extTest;
	public static void main(String[] args) {
		invokeBrowser("chrome", "http://localhost:88888") ;
			

	}
//	public static WebDriver invokeBrowser(String brName, String url) {
//			WebDriver driver =null;
//	
//		try {
//		if (brName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver =new ChromeDriver();
//		}else if (brName.equalsIgnoreCase("fireFox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver =new FirefoxDriver();
//		}else if (brName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver =new EdgeDriver();
//		}else {
//			System.out.println("Given browser is wrong");
//		}
////		return driver;
//	}catch (Exception e) {
//		e.printStackTrace();
//		}
//		try {
//		driver.get(url);
//	}catch(Exception e) {
//		driver.navigate().to(url);
//	}catch(Throwable e) {
//		e.getMessage();
//	}
//		return driver;
//			
//			
	public static void invokeBrowser(String brName, String url) {		
			
	
		if (brName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			driver.get(url);
		}else if (brName.equalsIgnoreCase("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			driver.get(url);
		}else if (brName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
		
			
			
			
}}}
