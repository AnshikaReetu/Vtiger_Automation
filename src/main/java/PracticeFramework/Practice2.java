package PracticeFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Practice2 {
	public static void main(String[] args) {
		
	}
   public static void ToVerifyClick (WebDriver driver ,String xpath, ExtentTest test) {
  WebElement we =	driver.findElement(By.xpath(xpath));
  
 if( we.isDisplayed()==true) {
 test.log(Status.INFO, "element is displayed");
     if (we.isEnabled()==true) {
	 test.log(Status.INFO, "element is clickable");
	 
	     we.click();
	     test.log(Status.INFO, "click performed successfuly");
	     
     }else {
	 test.log(Status.FAIL, "element is'nt clickable");
 }}else {
 test.log(Status.FAIL, "element is'nt displayed");
 }
}
   public static void ToVerifySendkeys (WebDriver driver , String xpath, ExtentTest test, String value ) {
	   WebElement we =driver.findElement(By.xpath(xpath));
	   
	   if( we.isDisplayed()==true) {
	   test.log(Status.INFO, "element is displayed");
	       if (we.isEnabled()==true) {
	  	 test.log(Status.INFO, "element is clickable");
	  	 
	  	     we.sendKeys(value);;
	  	     test.log(Status.INFO, "value is enterd	 successfuly");
	  	     
	       }else {
	  	 test.log(Status.FAIL, "element is'nt clickable");
	   }}else {
	   test.log(Status.FAIL, "element is'nt displayed");
	   }
   }
public static void launchWebBrowser(WebDriver browserName, String url ) {
	WebDriver driver =browserName ;
	driver.get(url);
}
}
