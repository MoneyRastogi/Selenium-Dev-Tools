import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//images, css
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		//Enable the network listening
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//trying to pass immutable string
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		
		long startTime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector("button[class='add-to-cart btn btn-default']")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		driver.findElement(By.cssSelector("a[href='/angularAppdemo/cart']")).click();
		long endTime= System.currentTimeMillis();
		System.out.println(endTime-startTime);

	}

}
