package PracticeFramework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

		public static void screenshot(WebDriver driver, String fileName, ExtentTest extesTes) throws IOException {
			Date currentDate = new Date();
			TakesScreenshot tScreenshot1 = (TakesScreenshot) driver;
			File form1 = tScreenshot1.getScreenshotAs(OutputType.FILE);
			File to1 = new File(fileName + currentDate.toString().replace(":", "_") + ".png");
		//	Files.copy(form1, to1);
			extesTes.addScreenCaptureFromPath(to1.getAbsolutePath());
		}



	public static void Login () throws IOException {
		 
				DateFormat df= new SimpleDateFormat("MM_dd_yyyy___HH_mm_ss");
				String timeStamp=df.format(new Date());
				
				ExtentSparkReporter esr=new ExtentSparkReporter("Automationreport"+timeStamp+".html");
				ExtentReports ext=new ExtentReports();
				ext.attachReporter(esr);
				ExtentTest extTest=ext.createTest("verify create lead");
				
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				extTest.log(Status.INFO, "Chrome Browser Has been launched successfully");
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60000));
				driver.get("http://localhost:8888");
//				extTest.log(Status.INFO, "http://localhost:8888 opened successfully");
				
//				enterTextboxValue(driver, extTest, "//input[@name='user_name']", "user name", "admin");
//				enterTextboxValue(driver, extTest, "//input[@name='user_password']", "Password", "admin");
//				click(driver, extTest, "//inpu[@name='Login']", "Login Button");			
	}
			///   generic method  -  application independent util methods wrapper methods 
			public void verifySearchLeads() {
				DateFormat df= new SimpleDateFormat("MM_dd_yyyy___HH_mm_ss");
				String timeStamp=df.format(new Date());
				
				ExtentSparkReporter esr=new ExtentSparkReporter("Automationreport"+timeStamp+".html");
				ExtentReports ext=new ExtentReports();
				ext.attachReporter(esr);
				ExtentTest extTest=ext.createTest("verify search lead");
			}



			public static void launchBrowser(ChromeDriver chromeDriver, String string) {
				
				
			}
			public static void handleDropdown(WebElement we ,int byIndex) {
			Select sel =new Select(we);
			sel.selectByIndex(byIndex);
				
			}
			public static void handleDropdown(WebElement we ,String value) {
			Select sel =new Select(we);
			sel.selectByValue(value);
			}
			public static void handleDropdown1(WebElement we ,String visibleText) {
		    Select sel =new Select(we);
			sel.selectByVisibleText(visibleText);
					
			
			}
			public static void switchToFrame(WebDriver driver,int index) {
			driver.switchTo().frame(index);	
			}	
			public static void switchToFrame(WebDriver driver,String nameorId) {
			driver.switchTo().frame(nameorId);	
			}					
		    public static void switchToFrame(WebDriver driver,WebElement we) {	
 		    driver.switchTo().frame(we);	
		    }
				
				
		   public static void switchToAlert(WebDriver driver) {
		   driver.switchTo().alert().accept();		
				
				
				
				
				
				
				
			
}}
