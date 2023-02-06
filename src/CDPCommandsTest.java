import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CDPCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools =driver.getDevTools();
		devTools.createSession();
		//We have to create hashmap to implement tools if there's no pre defined protocol
		Map<String,Object> deviceMatrics=new HashMap<String,Object>();
		deviceMatrics.put("width", 675);
		deviceMatrics.put("height", 675);
		deviceMatrics.put("deviceScaleFactor", 50);
		deviceMatrics.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMatrics);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class*='btn btn-primary']")).click();




	}
}
