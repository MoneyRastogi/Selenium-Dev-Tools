import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.emulation.Emulation;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		//devTools.send(Emulation.setGeolocationOverride(Optional.of(35.689487), Optional.of(139.691706), Optional.of(100)));
		Map<String,Object> coordinates=new HashMap<String,Object>();
		coordinates.put("latitude",40);
		coordinates.put("longitude",3);
		coordinates.put("accuracy",1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("restaurant near me",Keys.ENTER);
	}

}
