package automationFramework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ccda {

	private static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		   
	        // Create a new instance of the Firefox driver
	 
	        driver = new FirefoxDriver();
	 
	        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	        //Launch the Online Store Website
	 
	        driver.get("http://54.200.44.56/web/site/c-cda"); 
	        
	        Thread.sleep(10000);
	        
	        driver.get("http://54.200.44.56/web/site/c-cda-validator");
	        
	        
	       // driver.findElement(By.xpath("//a[contains(@href,\"#collapseCCDA1_1\")]")).click();
	        driver.findElement(By.xpath("//a[contains(@href,\"#collapseSuperValidator\")]")).click();
	       	               
	       driver.findElement(By.xpath("//input[@id='CCDASuperFileupload']")).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\170.314(b)(1)InPt_Discharge Summary CED Type.xml");
	      driver.findElement(By.xpath("//button[@id='CCDASuperFormSubmit']")).click();
	        
	      

	          //wait for 20 seconds 
	      Thread.sleep(20000);
	       
	        driver.quit();
	        
	    }

	}