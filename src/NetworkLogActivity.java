import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v109.network.model.Request;
import org.openqa.selenium.devtools.v109.network.model.Response;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver =new ChromeDriver();
		//log file
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//this method will give request to the request object
		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req=request.getRequest();
			//System.out.println(req.getUrl());
		});
		//Event will get fired
		devTools.addListener(Network.responseReceived(), response ->
		{
			Response res=response.getResponse();
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			System.out.println(res.getHeaders());
			
			if(res.getHeaders().toString().startsWith("4"));
			{
				System.out.println(res.getUrl()+"is failing with status code"+res.getStatusText());
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();

	}

}
