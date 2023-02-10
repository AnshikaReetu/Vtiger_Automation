package GenericFramework;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericMethods {
	
public static WebDriver driver;
public static ExtentTest exttest;
	public static void main(String[] args) {
	

	}
	public static void screenshot(String fileName )throws IOException{
		Date currentDate = new Date();
		TakesScreenshot tss =(TakesScreenshot)driver;
		File from =tss.getScreenshotAs(OutputType.FILE);
		File to = new File("");
		Files.copy(from, to);
		exttest.addScreenCaptureFromPath(to.getAbsolutePath());
		
		
		
	}
	public static void BrowserLaunch(WebDriver browName, String Url) throws IOException{

	}
	public static  ExtentReports ExtentReport(String fileName , String OsName ,String UserName, String TcId){
		File fileobj = new File(fileName + ".html");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(fileobj);
		ExtentReports ExtReport = new ExtentReports();
		ExtReport.attachReporter(htmlReport);
		ExtReport.setSystemInfo("Os Name",System.getProperty(OsName));
		ExtReport.setSystemInfo("UserName",System.getProperty(UserName));
		ExtReport.setSystemInfo("ServerName","Qa Server");
		exttest = ExtReport.createTest(TcId);
		
	return ExtReport;	
	}
	
	public void verifySearchLeads() {
		DateFormat df= new SimpleDateFormat("MM_dd_yyyy___HH_mm_ss");
		String timeStamp=df.format(new Date());

		ExtentSparkReporter esr=new ExtentSparkReporter("Automationreport"+timeStamp+".html");
		ExtentReports ext=new ExtentReports();
		ext.attachReporter(esr);
		ExtentTest extTest=ext.createTest("verify search lead");
	}

public static WebDriver launchBrowser(String browserName, ExtentTest extTest) {
	
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		extTest.log(Status.INFO, "Chrome Browser launched successfully");
	}else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		extTest.log(Status.INFO, "Firefox Browser launched successfully");
	}else if(browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		extTest.log(Status.INFO, "Edge Browser launched successfully");

	}else {
		extTest.log(Status.FAIL, "Browser Not Launched. Browser Name is not valid. Please check");
	}
	return driver;
}
public static void takeScreenshot(WebDriver driver, String elementName) {
    
	TakesScreenshot tss=(TakesScreenshot)driver;
	File src=tss.getScreenshotAs(OutputType.FILE);
	String ts=getTimeStamp();
	File  destinationFile=new File("snapshots\\"+elementName+ts+".png");
	try {
		FileUtils.copyFile(src, destinationFile);
	} catch (Exception e) {
		
		e.printStackTrace();	
	}
	
}
public static String getTimeStamp() {
	DateFormat df= new SimpleDateFormat("MM-dd-yyyy HH_MM_SS");
	return df.format(new Date());
}
public static WebElement getWebElement( String locatorValue,
		String locatorType) {
	WebElement we = null;
	/// we are checking locator Type value is xpath or not
	if (locatorType.equalsIgnoreCase("xpath")) {
		//// if it is xpath then it using
		we = driver.findElement(By.xpath(locatorValue));

	} else if (locatorType.equalsIgnoreCase("linkText")) {
		we = driver.findElement(By.linkText(locatorValue));
	} else if (locatorType.equalsIgnoreCase("name")) {
		we = driver.findElement(By.name(locatorValue));
	} else if (locatorType.equalsIgnoreCase("id")) {
		we = driver.findElement(By.id(locatorValue));
	} else if (locatorType.equalsIgnoreCase("class")) {
		we = driver.findElement(By.className(locatorValue));
	} else if (locatorType.equalsIgnoreCase("css")) {
		we = driver.findElement(By.cssSelector(locatorValue));
	} else {
		exttest.log(Status.FAIL, locatorType + " Locator Type is Wrong. Please check");
	}
	return we;
}
public static boolean checkElement(WebElement we, String elementName) {
	boolean status=false;
	/// we are checking element is displaying or not. if it is displaying then it is going into if condition
	if(we.isDisplayed()==true) {
		
		exttest.log(Status.INFO, "user name text box is  visible");
		//// we 
		if(we.isEnabled()==true) {
			exttest.log(Status.INFO, elementName+" text box is  enabled");
		     /// if element is visible and enabled then it is assigning true value
			status=true;
		}else {
			exttest.log(Status.INFO, elementName+" text box is  disabled");
		}
	}else {
		exttest.log(Status.FAIL, elementName+" text box is not visible");
	}
	return status;
}

	





}


