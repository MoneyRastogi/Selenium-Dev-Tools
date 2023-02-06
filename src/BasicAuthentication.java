import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;
public class BasicAuthentication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver =new ChromeDriver();
		//predicate, consumers
		Predicate<URI> uriPredicate =uri->uri.getHost().contains("httpbin.org");
		//registering the pop-up
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		String text=driver.findElement(By.cssSelector("[style*='word-wrap']")).getText();
		System.out.println(text);
	}

}
