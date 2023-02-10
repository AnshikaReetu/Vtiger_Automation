package GenericFramework;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class WebUtiles {
	public static WebDriver driver;
	public static ExtentTest extentTest;

	public static void screenshot(String fileName) throws IOException {
		Date currentDate = new Date();
		TakesScreenshot tScreenshot1 = (TakesScreenshot) driver;
		File form1 = tScreenshot1.getScreenshotAs(OutputType.FILE);
		File to1 = new File(fileName + currentDate.toString().replace(":", "_") + ".png");
		Files.copy(form1, to1);
		extentTest.addScreenCaptureFromPath(to1.getAbsolutePath());
	}

	/**
	 * @param browserName
	 * @param url
	 * @throws IOException
	 */
	public static void lounchBrowser(WebDriver browserName, String url) throws IOException {
		try {
			driver = browserName;
			extentTest.log(Status.INFO, "Browser lounch succesfully");
			driver.get(url);
			extentTest.log(Status.INFO, "Url hit succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			screenshot("BrowserLounching");
		}
	}

	/**
	 * @param fileName
	 * @param OsName
	 * @param UserName
	 * @param TcId
	 * @return
	 * @throws IOException
	 */
	public static ExtentReports ExtentReport(String fileName, String OsName, String UserName, String TcId)
			throws IOException {
		File objfile = new File(fileName + ".html");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(objfile);
		ExtentReports ExtReport = new ExtentReports();
		ExtReport.attachReporter(htmlReport);
		ExtReport.setSystemInfo("OS Name", System.getProperty(OsName));
		ExtReport.setSystemInfo("UserName", System.getProperty(UserName));
		ExtReport.setSystemInfo("Server name", "Qa Server");
		extentTest = ExtReport.createTest(TcId);

		return ExtReport;
	}

	/**
	 * @param locatorValue
	 * @param locatorType
	 * @return
	 */
	public static WebElement getWebElement(String locatorValue, String locatorType) {
		WebElement we = null;
		if (locatorType.equalsIgnoreCase("xpath")) {

			we = driver.findElement(By.xpath(locatorValue));
			return we;
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			we = driver.findElement(By.linkText(locatorValue));
			return we;
		} else if (locatorType.equalsIgnoreCase("name")) {

			we = driver.findElement(By.name(locatorValue));
			return we;
		} else if (locatorType.equalsIgnoreCase("Id")) {
			we = driver.findElement(By.id(locatorValue));
			return we;
		} else if (locatorType.equalsIgnoreCase("css")) {
			we = driver.findElement(By.cssSelector(locatorValue));
			return we;
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			we = driver.findElement(By.tagName(locatorValue));
			return we;
		} else {

			extentTest.log(Status.FAIL, locatorType + "Locator type is wrong . plz check");
			return we;
		}

	}
	public static boolean ToCheckElementEnability(WebElement webElement, String inputBoxNameForInfo)
			throws IOException {

				boolean status = false;

		if (webElement.isDisplayed()) {
			extentTest.log(Status.INFO, inputBoxNameForInfo + " box is displaying");
			if (webElement.isEnabled()) {
				extentTest.log(Status.INFO, inputBoxNameForInfo + " box is enable");

				status = true;

				extentTest.log(Status.FAIL, inputBoxNameForInfo + " box is disable");
			} else {
				extentTest.log(Status.FAIL, inputBoxNameForInfo + " box is not enable");
			}
		} else {
			extentTest.log(Status.FAIL, inputBoxNameForInfo + " box is not displaying");
		}
		return status;
	}
	public static boolean checkElement(WebElement we, String elementName) {
		boolean status = false;
		if (we.isDisplayed() == true) {
			extentTest.log(Status.INFO, "user name text box is  visible");
			if (we.isEnabled() == true) {
				extentTest.log(Status.INFO, elementName + " text box is  enabled");
				status = true;
			} else {
				extentTest.log(Status.INFO, elementName + " text box is  disabled");
			}
		} else {
			extentTest.log(Status.FAIL, elementName + " text box is not visible");
		}
		return status;
	}

	public static void sendKey(String locatorValue, String locatorType, String elementName) {
		try {
			WebElement we = getWebElement(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				Actions ac = new Actions(driver);
				ac.sendKeys(elementName).build().perform();
			}
		} catch (Exception e) {

		}
	}

	public static WebElement sendKey1(String locatorValue, String locatorType, String elementName) {
		WebElement we = null;
		try {
			we = getWebElement(locatorValue, locatorType);
			System.out.println("we===" + we);
			boolean st = checkElement(we, elementName);
			System.out.println("Status===" + st);
			if (st == true) {
				Actions ac = new Actions(driver);
				ac.sendKeys(we, elementName).build().perform();
				extentTest.log(Status.INFO, elementName + "> is entered  successfully  in the box.");
				screenshot(elementName);
			}
		} catch (Exception e) {

		}
		return we;
	}

	public static void invokeBrowser(String brName, String url) {
}}
