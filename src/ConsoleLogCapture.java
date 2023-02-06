import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector("button[class='add-to-cart btn btn-default']")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry=driver.manage().logs().get(LogType.BROWSER); //get LogEntries Object
		List<LogEntry> logs=entry.getAll(); //LogEntryobject- getAll method return all logs in list
		for(LogEntry e: logs) //enhanced for loop, iterating through list and printing each log message
		{
			System.out.println(e.getMessage()); //push it to log4j in testNG
		}

	}

}
