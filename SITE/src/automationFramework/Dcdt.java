package automationFramework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Dcdt {

	private static WebDriver driver ;
	   public static void main(String[] args) throws InterruptedException {
		   
	        // Create a new instance of the Firefox driver
	 
	        driver = new FirefoxDriver();
	 
	        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	        //Launch the Online Store Website
	 
	        driver.get("http://54.200.44.56/web/site/direct-certificate-discovery-tool");
	        driver.findElement(By.xpath("//input[@id='testcase-hosting-direct-addr']")).sendKeys("provider1@direct.sitenv.org");
	        driver.findElement(By.xpath("//button[@id='testcase-hosting-submit']")).click();
	        
	        driver.quit();
	        
	    }

	}