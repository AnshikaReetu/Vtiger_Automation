package GenericMethods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//public class WebUtils {
//		public static WebDriver driver;
//		public static ExtentTest 
//	File from = screenshot.getScreenshotAs(OutputType.FILE);
//	File to = new File("Automation_Report\\screenshot " + inputboxname + ".png");
//	Files.copy(from, to);
//	testcase.addScreenCaptureFromPath(to.getAbsolutePath());
//}
//
//public static WebElement ToSearchTheElementByLocaters(String locatername,String locater) {
//
//	WebElement web = null;
//
//	if (locatername.equalsIgnoreCase("xpath")) {
//		web = driver.findElement(By.xpath(locater));
//	} else if (locatername.equalsIgnoreCase("name")) {
//		web = driver.findElement(By.name(locater));
//	} else if (locatername.equalsIgnoreCase("linkText")) {
//		web = driver.findElement(By.linkText(locater));
//	} else if (locatername.equalsIgnoreCase("class")) {
//		web = driver.findElement(By.className(locater));
//	} else if (locatername.equalsIgnoreCase("CSS selector")) {
//		web = driver.findElement(By.cssSelector(locater));
//	} else if (locatername.equalsIgnoreCase("id")) {
//		web = driver.findElement(By.id(locater));
//	} else if (locatername.equalsIgnoreCase("tagName")) {
//		web = driver.findElement(By.tagName(locater));
//	} else if (locatername.equalsIgnoreCase("PartialLinksText")) {
//		web = driver.findElement(By.partialLinkText(locater));
//	} else {
//		testcase.log(Status.FAIL, "the locater value is wrong");
//	}
//
//	return web;
//}
//
//public static boolean ToCheckElementEnability(WebElement webElement, String inputBoxNameForInfo)
//		throws IOException {
//
//			boolean status = false;
//
//	if (webElement.isDisplayed()) {
//		testcase.log(Status.INFO, inputBoxNameForInfo + " box is displaying");
//		if (webElement.isEnabled()) {
//			testcase.log(Status.INFO, inputBoxNameForInfo + " box is enable");
//
//			status = true;
//
//			testcase.log(Status.FAIL, inputBoxNameForInfo + " box is disable");
//		} else {
//			testcase.log(Status.FAIL, inputBoxNameForInfo + " box is not enable");
//		}
//	} else {
//		testcase.log(Status.FAIL, inputBoxNameForInfo + " box is not displaying");
//	}
//	return status;
//}
//
//public static void ToSendValueInInputBox(WebElement webElement, String value, String inputboxname)
//		throws IOException {
//	try {
//
////		 WebElement web = ToSearchTheElementByLocaters(webElement);
//		boolean enability = ToCheckElementEnability(webElement, inputboxname);
//
//		if (enability) {
//			webElement.sendKeys(value);
//		}
//	} catch (Exception n) {
//		toTakeScreenShot(inputboxname);
//		testcase.log(Status.FAIL, "here is a exception");
//	}
//}
//
//public static void ToClickAnyButton(WebElement webElement, String inputboxname)
//		throws IOException {
//
//	try {
//
////		WebElement web = ToSearchTheElementByLocaters(webElement);
//		boolean elementEnability = ToCheckElementEnability(webElement, inputboxname);
//
//		if (elementEnability) {
//			webElement.click();
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(inputboxname);
//		testcase.log(Status.FAIL, "This exception is handled");
//	}
//}
//
//public static void ToHandleDropDownByVisibalText(WebElement webElement , String inputboxname,
//		String visibalTextOfSelectingOptInDrop) {
//	try {
//
//
//		boolean dropDownEnability = ToCheckElementEnability(webElement, inputboxname);
//
//		if (dropDownEnability == true) {
//			Select select = new Select(webElement);
//			select.selectByVisibleText(visibalTextOfSelectingOptInDrop);
//		}
//	} catch (Exception n) {
//		testcase.log(Status.FAIL, "here is a exception");
//
//	}
//}
//
//public static void ToHandleDropDownByIndexOf(WebElement webElement, int endexOfSelectingOPTinDropDown,
//		String inputboxname) throws IOException {
//
//	try {
//		boolean elementLocaterEnability = ToCheckElementEnability(webElement, inputboxname);
//
//		if (elementLocaterEnability == true) {
//
//			Select select = new Select(webElement);
//			select.selectByIndex(endexOfSelectingOPTinDropDown);
//			testcase.log(Status.PASS, "the option is selected in dropdown");
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(inputboxname);
//	}
//}
//
//public static void ToHandleDropDownByValue(WebElement webElement, String valueOfAttrebuteValue,
//		String inputboxname) throws IOException {
//
//	try {
//
//		boolean elementEnability = ToCheckElementEnability(webElement, inputboxname);
//
//		if (elementEnability == true) {
//			Select select = new Select(webElement);
//			select.selectByValue(valueOfAttrebuteValue);
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(inputboxname);
//	}
//}
//
//public String ToFindTheInnerText(WebElement webElement, int endexOfSelectingOPTinDropDown,
//		String valueOfAttrebuteValue, String inputboxname) throws IOException {
//
//	String innerText = "";
//	try {
//
//		boolean elementEnability = ToCheckElementEnability(webElement, innerText);
//
//		if (elementEnability == true) {
//			innerText = webElement.getText();
////			return innerText;
//		}
//	} catch (Exception ex) {
//		toTakeScreenShot(inputboxname);
//	}
//	return innerText;
//}
//
//public static String TogetAttribute(WebElement webElement, String attributename) throws IOException {
//
//	boolean elementEnability = ToCheckElementEnability(webElement, attributename);
//
//	String valueOfAttribute = webElement.getAttribute(attributename);
//	return valueOfAttribute; // not taken to any where
//}
//
//public static void ToCountOptionsOfDropdown(WebElement webElement, String dropDownName)
//		throws IOException {
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, dropDownName);
//
//		if (elementEnability) {
//
//			Select allOption = new Select(webElement);
//			List<WebElement> getoptions = allOption.getOptions();
//
//			for (int i = 0; i < getoptions.size(); i++) {
//				WebElement get = getoptions.get(i);
//				String text = get.getText();
//				System.out.println(text);
//			}
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(dropDownName);
//	}
//}
//
//public static void ToGetSelectedValueInDrop(WebElement webElement, String dropDownName)
//		throws IOException {
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, dropDownName);
//
//		if (elementEnability) {
//
//			Select select = new Select(webElement);
//			WebElement option = select.getFirstSelectedOption();
//			System.out.println(option.getText());
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(dropDownName);
//	}
//}
//
//public static Actions ToMouseOver(WebElement webElement, String mouseOveringLinkName)
//		throws IOException {
//
//	Actions action = null;
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, mouseOveringLinkName);
//
//		if (elementEnability) {
//			action = new Actions(driver);
//			action.moveToElement(webElement).build().perform();
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(mouseOveringLinkName);
//	}
//	return action;
//}
//
//public static void ToClickByActions(WebElement webElement, String clickingButtonName)
//		throws IOException {
//
//	Actions action = ToMouseOver(webElement, clickingButtonName);
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, clickingButtonName);
//		if (elementEnability) {
//			action.click(webElement).build().perform();
//		}
//
//	} catch (Exception e) {
//		toTakeScreenShot(clickingButtonName);
//	}
//}
//
//public static void ToSendKeysByActions(WebElement webElement, String inputBoxName,
//		String whatDoUwantToSend) throws IOException {
//
//	Actions action = ToMouseOver(webElement, inputBoxName);
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, inputBoxName);
//
//		if (elementEnability) {
//			action.sendKeys(webElement, whatDoUwantToSend).build().perform();
//		}
//
//	} catch (Exception e) {
//		toTakeScreenShot(inputBoxName);
//	}
//}
//
//public static void ToSwitchInFrameByIndex(WebElement webElement, String frameNameForInfo,
//		int indexOfFrame) throws IOException {
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, frameNameForInfo);
//
//		if (elementEnability) {
//			driver.switchTo().frame(indexOfFrame);
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(frameNameForInfo);
//	}
//}
//
//public static void toSwitchInFrameByNameOrId(WebElement webElement, String frameNameForInfo,
//		int indexOfFrame, String FrameByNameOrId) throws IOException {
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, frameNameForInfo);
//
//		if (elementEnability) {
//			driver.switchTo().frame(FrameByNameOrId);
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(frameNameForInfo);
//	}
//}
//
//public static void toSwitchInFrameByWebElement(WebElement webElement, String frameNameForInfo,
//		int indexOfFrame, String FrameByWebElement) throws IOException {
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, frameNameForInfo);
//
//		if (elementEnability) {
//			driver.switchTo().frame(FrameByWebElement);
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(frameNameForInfo);
//	}
//}
//
//public static void toHandleWindowByTitle(WebElement webElement, String windowTitle, String windowName)
//		throws IOException {
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, windowName);
//
//		if (elementEnability) {
//			Set<String> windows = driver.getWindowHandles();
//			for (String string : windows) {
//				String title = driver.getTitle();
//				if (title.equalsIgnoreCase(windowTitle)) {
//					break;
//				}
//			}
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(windowName);
//	}
//}
//
//public static void toHandleWindowByUrl(WebElement webElement, String windowUrl, String windowName)
//		throws IOException {
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, windowName);
//
//		if (elementEnability) {
//			Set<String> windows = driver.getWindowHandles();
//			for (String string : windows) {
//				String title = driver.getTitle();
//				if (title.equalsIgnoreCase(windowUrl)) {
//
//					break;
//				}
//			}
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(windowName);
//	}
//}
//
//public static void toGetTitle(WebElement webElement, String windowTitle, String elementNameGettingTitle)
//		throws IOException {
//
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, elementNameGettingTitle);
//
//		if (elementEnability) {
//				String title = driver.getTitle();
//				System.out.println(title);
//		}
//	} catch (Exception e) {
//		toTakeScreenShot(elementNameGettingTitle);
//	}
//}
//public static void toGetCssValueOrElementColour(WebElement webElement,String elementName,
//		String whichThingColour) throws IOException {
//	
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, elementName);
//		
//		if(elementEnability) {
//            String colour = webElement.getCssValue(whichThingColour);
//            String clure= Color.fromString(colour).asHex();
//            System.out.println(clure);
//		}
//	}catch(Exception e) {
//		toTakeScreenShot(elementName);
//	}
//}
//public static void toUploadFile(WebElement webElement,String uploadingFileName,
//		String fullXpathOfFile) throws IOException {
//	
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, uploadingFileName);
//		
//		if(elementEnability) {
////			web.sendKeys(fullXpathOfFile);
//			ToSendValueInInputBox( webElement,  fullXpathOfFile,  uploadingFileName);
//		}
//	}catch(Exception e) {
//		toTakeScreenShot(uploadingFileName);
//	}
//}
//public static void toCheck_CheckBoxStatus(WebElement webElement,String checkBoxName) throws IOException {
//	
//	try {
//		boolean elementEnability = ToCheckElementEnability(webElement, checkBoxName);
//		
//		if(elementEnability) {
//			ToClickAnyButton(webElement, checkBoxName);
//		}
//	}catch(Exception e) {
//		toTakeScreenShot(checkBoxName);
//	}
//	
//}
//public static void toHandleCalanderDate() {
//	
//	
//		
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.DATE, 1);
//		Date d = c.getTime();
//		DateFormat date = new SimpleDateFormat("d_MMM");
//		String d1 = date.format(d);
//		System.out.println(d1);
//		
//		String [] split = d1.split("_");
//		String dayString= split[0];
//		String monthString= split[1];
//		WebDriver driver= new ChromeDriver();
//		driver.get("https://erail.in/");
//		driver.findElement(By.xpath("//input[@title=\"Select Departure date for availability\"]")).click();
//		driver.findElement(By.xpath("//td[contains(text(),'"+monthString+"']//parent::tr/following-sibling::tr//td[text()='"+dayString+"']"));
//
//	
//	
//}
//public static void m1(int month) {
//	String month1 = null;
//	if(month==1) {
//		month1 = "jan"; 
//	}
//}
//}
//
