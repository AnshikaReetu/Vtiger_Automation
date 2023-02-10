package Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailCalander {
	public static void main(String[] args) {
		toHandleCalanderDate();
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
}
