package Framework;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework2 {
public static void main(String[] args) {
	
}
public static void takeSnapshot(WebDriver driver, ExtentTest test, String s) {
	Date date = new Date();
	TakesScreenshot tss = (TakesScreenshot)driver;
 //    File from = tss.getScreenshotAs(OutputType.FILE);
}
public static void LaunchBrowser() {
	
	WebDriverManager.chromedriver().setup();
	WebDriver we = new ChromeDriver();
	
}
}