package Framework;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericMethods {

	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		String timeStamp= df.format(new Date());
		
		
		File fl = new File("C:\\Users\\anshi\\eclipse-workspace\\Vtiger_Automation\\Screenshot"+"xyz.html");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(fl); //
		
		ExtentReports ExtReport = new ExtentReports();
		ExtReport.attachReporter(htmlReport); //
		ExtReport.setSystemInfo("OS Name", System.getProperty("os.name"));
		ExtReport.setSystemInfo("UserName", System.getProperty("user.name"));
		ExtReport.setSystemInfo("Server name", "Qa Server");
		ExtentTest exttest = ExtReport.createTest("Tc001");
		
	    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		exttest.log(Status.INFO, "Chrome Browser launched Succesfully");
		driver.get("http://localhost:8888");

				driver.findElement(By.name("user_password")).sendKeys("admin");
		exttest.log(Status.INFO, "Password(admin) is entered successfully in Password box");

		driver.findElement(By.name("Login")).click();
		exttest.log(Status.INFO, "Clicked Performed succesfully on Login Button");
	

	}
public void verifyCreateLead(WebDriver driver, ExtentTest exttest, String locator , String element_name , String Datavalue) {
	try {
		
	  
	WebElement we=driver.findElement(By.name(locator));
	if (we.isDisplayed()==true) {
		exttest.log(Status.INFO, element_name+" ");
		if (we.isEnabled()==true) {
			exttest.log(Status.INFO, " "+ element_name+ "  ");
			we.sendKeys(Datavalue);
			exttest.log(Status.INFO, " ");
		}else {
			exttest.log(Status.INFO, " ");
		}
	}else {
		exttest.log(Status.INFO, " ");
	}
	}catch(Exception e) {
		TakesScreenshot tss = (TakesScreenshot)driver;
	File fi 	=tss.getScreenshotAs(OutputType.FILE);
		exttest.log(Status.INFO, " ");
		
	}
	
	
}


}
