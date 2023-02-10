package PracticeFramework;


	import java.io.File;
	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
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
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class CopyPaste1 { /// 750 15 m Maintainance

	    public static WebDriver driver ;	
	    public static ExtentTest extTest ;
		public void verifyCreateLead() {
	    
			DateFormat df = new SimpleDateFormat("MM_dd_yyyy___HH_mm_ss");
			String timeStamp = df.format(new Date());

			ExtentSparkReporter esr = new ExtentSparkReporter("Automationreport" + timeStamp + ".html");
			ExtentReports ext = new ExtentReports();
			ext.attachReporter(esr);
			ExtentTest extTest = ext.createTest("verify create lead");

			
			extTest.log(Status.INFO, "Chrome Browser Has been launched successfully");

			WebDriver dr=WebUtil.launchBrowser("chrome", extTest);
			
			
			dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(60000));
			dr.get("localhost:8888/");
			extTest.log(Status.INFO, "http://localhost:8888/ opened successfully");

			WebUtil.enterTextboxValue( "user_name", "name", "user name", "admin");
			WebUtil.enterTextboxValue( "input[name='user_password']", "css", "Password", "admin");
			WebUtil.click( "//input[@name='Login']", "xpath", "Login Button");
			WebUtil.click("Marketing", "linkText", "Login Button");
			WebUtil.enterTextboxValue(timeStamp, timeStamp, timeStamp, timeStamp);

		}
		
	}




	