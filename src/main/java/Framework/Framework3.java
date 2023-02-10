package Framework;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework3 {
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
				getScreenShot(elementName);
			}
		} catch (Exception e) {

		}
		return we;
	}

	public static void invokeBrowser(String brName, String url) {
 try {
			if (brName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				extentTest.log(Status.INFO, "browser launched successfully ");
			} else if (brName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (brName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else {
				System.out.println("Given browername is successfully");

			}

		} catch (Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "browser not launched...");

		}

		try {
			driver.get(url);
			extentTest.log(Status.INFO, url + "> is navigated successfully");
		} catch (Exception e) {
			driver.navigate().to(url);
			extentTest.log(Status.INFO,
					url + "> is not navigated by get() and navigeted successfully by navitate.to()");
			e.printStackTrace();
		}

	}

	public static void click(WebDriver driver, ExtentTest extTest, String locator, String elementName) {
		try {
			WebElement we = driver.findElement(By.xpath(locator));
			if (we.isDisplayed() == true) {
				extTest.log(Status.INFO, "user name text box is  visible");
				if (we.isEnabled() == true) {
					extTest.log(Status.INFO, elementName + " text box is  enabled");
					we.click();
					extTest.log(Status.INFO, "click performed successfully on " + elementName);

				} else {
					extTest.log(Status.INFO, elementName + " text box is  disabled");
				}
			} else {
				extTest.log(Status.FAIL, elementName + " text box is not visible");
			}
		} catch (Exception e) {
			TakesScreenshot tss = (TakesScreenshot) driver;
			File fileObj = tss.getScreenshotAs(OutputType.FILE);

		}

	}

	public static WebElement ActionsClick(String locatorType, String locatorValue) {
		WebElement we = null;
		try {
			we = getWebElement(locatorValue, locatorType);
			boolean st = checkElement(we, locatorValue);
			if (st == true) {
				Actions ac = new Actions(driver);
				ac.click().build().perform();

			}
		} catch (Exception e) {
			e.getMessage();
			getScreenShot("ActionClick");
		}

		return we;

	}

	/**
	 * 
	 * alt+ shift + j ===== to write the method related massage over the method
	 * 
	 * @param locName
	 */
	public static void getScreenShot(String locName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File tempFile = screenshot.getScreenshotAs(OutputType.FILE);

		File destination = new File("Scr/" + locName + ".png");
		try {
			Files.copy(tempFile, destination);
			extentTest.log(Status.INFO,
					"screenShot captured and copied  to the specified location" + "Scr/" + locName + ".jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void handleFrame(String frameValue) {
		try {
			driver.switchTo().frame(frameValue);
			extentTest.log(Status.INFO, "switched to " + frameValue + " successfully");
		} catch (Exception e) {
			e.printStackTrace();
			getScreenShot(frameValue);
			extentTest.log(Status.FAIL, "given " + frameValue + " is not swiched successfully");

		}
	}

	public static void handleFrame(int frameindex) {
		try {
			driver.switchTo().frame(frameindex);
			extentTest.log(Status.INFO, "switched to frame index no- " + frameindex + " successfully");
		} catch (Exception e) {
			e.printStackTrace();
			getScreenShot("frameindex");
			extentTest.log(Status.FAIL, "given frame index no- " + frameindex + " is not swiched successfully");

		}
		
	}
	public static void acceptPopup() {
		try {
			driver.switchTo().alert().accept();
			extentTest.log(Status.INFO, "switched to popup "  + " successfully");
		} catch (Exception e) {
			e.printStackTrace();
			getScreenShot("frameindex");
			extentTest.log(Status.FAIL, "given frame popup "  + " is not swiched successfully");

		}
		
	}
	public static void dismissPopup() {
		try {
			driver.switchTo().alert().accept();
			extentTest.log(Status.INFO, "Alert/popup is dissmissed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			getScreenShot("frameindex");
			extentTest.log(Status.FAIL, "Alert/popup not dissmiss successful");

		}}
	public static void  getTextPopup() {
		try {
			driver.switchTo().alert().getText();
			extentTest.log(Status.INFO, "Alert/popup is getText  successfully");
		} catch (Exception e) {
			e.printStackTrace();
			getScreenShot("frameindex");
			extentTest.log(Status.FAIL, "Alert/popup not getText successful");

		}}
		public static void getwindow( String windowvalue) {
			try {
				Set<String> ssSet=driver.getWindowHandles();
				extentTest.log(Status.INFO, "");
				for (String string : ssSet) {
					extentTest.log(Status.INFO, "");
					driver.switchTo().window(windowvalue);
					extentTest.log(Status.INFO, "");
				String getString=	driver.getTitle();
				extentTest.log(Status.INFO, "");
				if (getString.equalsIgnoreCase(getString)) {
					extentTest.log(Status.INFO, "");	
					break;
				}
				}
				}catch (Exception e) {
				}
				}
			public static void Urlgetwindow( String windowvalue) {
				try {
					Set<String> ssSet=driver.getWindowHandles();
					extentTest.log(Status.INFO, "");
					for (String string : ssSet) {
						extentTest.log(Status.INFO, "");
						driver.switchTo().window(windowvalue);
						extentTest.log(Status.INFO, "");
					String getString=	driver.getCurrentUrl();
					extentTest.log(Status.INFO, "");
					if (getString.equalsIgnoreCase(getString)) {
						extentTest.log(Status.INFO, "");	
						break;
					}
					}
					}catch (Exception e) {
						
					}
			}
			 public static void ToSendValueInInputBox(WebElement webElement, String value, String inputboxname)
					throws IOException {
				try {

//					 WebElement web = ToSearchTheElementByLocaters(webElement);
					boolean enability = ToCheckElementEnability(webElement, inputboxname);

					if (enability) {
						webElement.sendKeys(value);
					}
				} catch (Exception n) {
					screenshot(inputboxname);
					extentTest.log(Status.FAIL, "here is a exception");
				}
			}

			public static void ToClickAnyButton(WebElement webElement, String inputboxname)
					throws IOException {

				try {

//					WebElement web = ToSearchTheElementByLocaters(webElement);
					boolean elementEnability = ToCheckElementEnability(webElement, inputboxname);

					if (elementEnability) {
						webElement.click();
					}
				} catch (Exception e) {
					screenshot(inputboxname);
					extentTest.log(Status.FAIL, "This exception is handled");
				}
			}

			public static void ToHandleDropDownByVisibalText(WebElement webElement , String inputboxname,
					String visibalTextOfSelectingOptInDrop) {
				try {


					boolean dropDownEnability = ToCheckElementEnability(webElement, inputboxname);

					if (dropDownEnability == true) {
						Select select = new Select(webElement);
						select.selectByVisibleText(visibalTextOfSelectingOptInDrop);
					}
				} catch (Exception n) {
					extentTest.log(Status.FAIL, "here is a exception");

				}
			}

			public static void ToHandleDropDownByIndexOf(WebElement webElement, int endexOfSelectingOPTinDropDown,
					String inputboxname) throws IOException {

				try {
					boolean elementLocaterEnability = ToCheckElementEnability(webElement, inputboxname);

					if (elementLocaterEnability == true) {

						Select select = new Select(webElement);
						select.selectByIndex(endexOfSelectingOPTinDropDown);
						extentTest.log(Status.PASS, "the option is selected in dropdown");
					}
				} catch (Exception e) {
					screenshot(inputboxname);
				}
			}

			public static void ToHandleDropDownByValue(WebElement webElement, String valueOfAttrebuteValue,
					String inputboxname) throws IOException {

				try {

					boolean elementEnability = ToCheckElementEnability(webElement, inputboxname);

					if (elementEnability == true) {
						Select select = new Select(webElement);
						select.selectByValue(valueOfAttrebuteValue);
					}
				} catch (Exception e) {
					screenshot(inputboxname);
				}
			}

			public String ToFindTheInnerText(WebElement webElement, int endexOfSelectingOPTinDropDown,
					String valueOfAttrebuteValue, String inputboxname) throws IOException {

				String innerText = "";
				try {

					boolean elementEnability = ToCheckElementEnability(webElement, innerText);

					if (elementEnability == true) {
						innerText = webElement.getText();
//						return innerText;
					}
				} catch (Exception ex) {
					screenshot(inputboxname);
				}
				return innerText;
			}

			public static String TogetAttribute(WebElement webElement, String attributename) throws IOException {

				boolean elementEnability = ToCheckElementEnability(webElement, attributename);

				String valueOfAttribute = webElement.getAttribute(attributename);
				return valueOfAttribute; // not taken to any where
			}

			public static void ToCountOptionsOfDropdown(WebElement webElement, String dropDownName)
					throws IOException {

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, dropDownName);

					if (elementEnability) {

						Select allOption = new Select(webElement);
						List<WebElement> getoptions = allOption.getOptions();

						for (int i = 0; i < getoptions.size(); i++) {
							WebElement get = getoptions.get(i);
							String text = get.getText();
							System.out.println(text);
						}
					}
				} catch (Exception e) {
					screenshot(dropDownName);
				}
			}

			public static void ToGetSelectedValueInDrop(WebElement webElement, String dropDownName)
					throws IOException {

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, dropDownName);

					if (elementEnability) {

						Select select = new Select(webElement);
						WebElement option = select.getFirstSelectedOption();
						System.out.println(option.getText());
					}
				} catch (Exception e) {
					screenshot(dropDownName);
				}
			}

			public static Actions ToMouseOver(WebElement webElement, String mouseOveringLinkName)
					throws IOException {

				Actions action = null;
				try {
					boolean elementEnability = ToCheckElementEnability(webElement, mouseOveringLinkName);

					if (elementEnability) {
						action = new Actions(driver);
						action.moveToElement(webElement).build().perform();
					}
				} catch (Exception e) {
					screenshot(mouseOveringLinkName);
				}
				return action;
			}

			public static void ToClickByActions(WebElement webElement, String clickingButtonName)
					throws IOException {

				Actions action = ToMouseOver(webElement, clickingButtonName);

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, clickingButtonName);
					if (elementEnability) {
						action.click(webElement).build().perform();
					}

				} catch (Exception e) {
					screenshot(clickingButtonName);
				}
			}

			public static void ToSendKeysByActions(WebElement webElement, String inputBoxName,
					String whatDoUwantToSend) throws IOException {

				Actions action = ToMouseOver(webElement, inputBoxName);

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, inputBoxName);

					if (elementEnability) {
						action.sendKeys(webElement, whatDoUwantToSend).build().perform();
					}

				} catch (Exception e) {
					screenshot(inputBoxName);
				}
			}

			public static void ToSwitchInFrameByIndex(WebElement webElement, String frameNameForInfo,
					int indexOfFrame) throws IOException {

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, frameNameForInfo);

					if (elementEnability) {
						driver.switchTo().frame(indexOfFrame);
					}
				} catch (Exception e) {
					screenshot(frameNameForInfo);
				}
			}

			public static void toSwitchInFrameByNameOrId(WebElement webElement, String frameNameForInfo,
					int indexOfFrame, String FrameByNameOrId) throws IOException {

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, frameNameForInfo);

					if (elementEnability) {
						driver.switchTo().frame(FrameByNameOrId);
					}
				} catch (Exception e) {
					screenshot(frameNameForInfo);
				}
			}

			public static void toSwitchInFrameByWebElement(WebElement webElement, String frameNameForInfo,
					int indexOfFrame, String FrameByWebElement) throws IOException {

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, frameNameForInfo);

					if (elementEnability) {
						driver.switchTo().frame(FrameByWebElement);
					}
				} catch (Exception e) {
					screenshot(frameNameForInfo);
				}
			}

			public static void toHandleWindowByTitle(WebElement webElement, String windowTitle, String windowName)
					throws IOException {

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, windowName);

					if (elementEnability) {
						Set<String> windows = driver.getWindowHandles();
						for (String string : windows) {
							String title = driver.getTitle();
							if (title.equalsIgnoreCase(windowTitle)) {
								break;
							}
						}
					}
				} catch (Exception e) {
					screenshot(windowName);
				}
			}

			public static void toHandleWindowByUrl(WebElement webElement, String windowUrl, String windowName)
					throws IOException {

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, windowName);

					if (elementEnability) {
						Set<String> windows = driver.getWindowHandles();
						for (String string : windows) {
							String title = driver.getTitle();
							if (title.equalsIgnoreCase(windowUrl)) {

								break;
							}
						}
					}
				} catch (Exception e) {
					screenshot(windowName);
				}
			}

			public static void toGetTitle(WebElement webElement, String windowTitle, String elementNameGettingTitle)
					throws IOException {

				try {
					boolean elementEnability = ToCheckElementEnability(webElement, elementNameGettingTitle);

					if (elementEnability) {
							String title = driver.getTitle();
							System.out.println(title);
					}
				} catch (Exception e) {
					screenshot(elementNameGettingTitle);
				}
			}
			public static void toGetCssValueOrElementColour(WebElement webElement,String elementName,
					String whichThingColour) throws IOException {
				
				try {
					boolean elementEnability = ToCheckElementEnability(webElement, elementName);
					
					if(elementEnability) {
		                String colour = webElement.getCssValue(whichThingColour);
		                String clure= Color.fromString(colour).asHex();
		                System.out.println(clure);
					}
				}catch(Exception e) {
					screenshot(elementName);
				}
			}
			public static void toUploadFile(WebElement webElement,String uploadingFileName,
					String fullXpathOfFile) throws IOException {
				
				try {
					boolean elementEnability = ToCheckElementEnability(webElement, uploadingFileName);
					
					if(elementEnability) {
//						web.sendKeys(fullXpathOfFile);
						ToSendValueInInputBox( webElement,  fullXpathOfFile,  uploadingFileName);
					}
				}catch(Exception e) {
					screenshot(uploadingFileName);
				}
			}
			public static void toCheck_CheckBoxStatus(WebElement webElement,String checkBoxName) throws IOException {
				
				try {
					boolean elementEnability = ToCheckElementEnability(webElement, checkBoxName);
					
					if(elementEnability) {
						ToClickAnyButton(webElement, checkBoxName);
					}
				}catch(Exception e) {
					screenshot(checkBoxName);
				}
				
			}
			public static void toHandleCalanderDate() {
				
				
					
					Calendar c = Calendar.getInstance();
					c.add(Calendar.DATE, 1);
					Date d = c.getTime();
					DateFormat date = new SimpleDateFormat("d_MMM");
					String d1 = date.format(d);
					System.out.println(d1);
					
					String [] split = d1.split("_");
					String dayString= split[0];
					String monthString= split[1];
					WebDriver driver= new ChromeDriver();
					driver.get("https://erail.in/");
					driver.findElement(By.xpath("//input[@title=\"Select Departure date for availability\"]")).click();
					driver.findElement(By.xpath("//td[contains(text(),'"+monthString+"']//parent::tr/following-sibling::tr//td[text()='"+dayString+"']"));

				
				
			}
			public static void m1(int month) {
				String month1 = null;
				if(month==1) {
					month1 = "jan"; 
				}
			}
			
	

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		ToHandleDropDownByVisibalText(null, null, null);
		
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//		
//		ExtentReports reports = ExtentReport("Nitu", "os.name", "user name", "Tc001");
/////	screenshot(:);
//		invokeBrowser("chrome", "http:localhost:8888");
//		sendKey1("//input[@name='user_name']", "xpath", "admin");
//		sendKey1("//input[@name='user_password']", "xpath", "admin");
//		System.out.println("1");
//		dismissPopup();
//		acceptPopup();
//		handleFrame(6);
//		
//		reports.flush();
	}
}

