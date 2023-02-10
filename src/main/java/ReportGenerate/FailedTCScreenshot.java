package ReportGenerate;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FailedTCScreenshot {

public static void main(String[] args) throws IOException {	
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

	driver.findElement(By.name("user_name")).sendKeys("admin");
	exttest.log(Status.INFO, "Username(admins) is entered successfully in username box");

	driver.findElement(By.name("user_password")).sendKeys("admin");
	exttest.log(Status.INFO, "Password(admin) is entered successfully in Password box");

	driver.findElement(By.name("Login")).click();
	exttest.log(Status.INFO, "Clicked Performed succesfully on Login Button");

	String CheckVisiabilityOfMarketingButton= driver.findElement(By.xpath("//a[text()='Marketing']")).getText();
	 if(CheckVisiabilityOfMarketingButton.equals("marketings")) {
	 exttest.log(Status.INFO,"Marketing button is visiable Tc001 is passed");
	}else {
	 exttest.log(Status.INFO,"Marketing button is not visiable Tc001 is faild");
			

	TakesScreenshot tScreenshot = (TakesScreenshot) driver;
	File form = tScreenshot.getScreenshotAs(OutputType.FILE);
	File to = new File("Screenshot//screenshotname.png");

	Files.copy(form, to);


	TakesScreenshot tScreenshot1 = (TakesScreenshot) driver;
	File form1 = tScreenshot1.getScreenshotAs(OutputType.FILE);
	File to1 = new File("Screenshot//screenshotname.png");
	Files.copy(form1, to1);

	exttest.addScreenCaptureFromPath(to1.getAbsolutePath());

	ExtReport.flush();

	
	
	}
}
}
