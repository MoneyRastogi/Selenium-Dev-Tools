import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver =new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		//send commands to CDP Methods-->CDP Methods will invoke and get access to chrome dev tools
		devTools.send(Emulation.setDeviceMetricsOverride(600, 767, 50, true, Optional.empty(), Optional.empty(), 
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class*='btn btn-primary']")).click();

	}

}
