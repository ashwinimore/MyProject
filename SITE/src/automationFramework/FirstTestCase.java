package automationFramework;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class FirstTestCase {
 
    private static WebDriver driver ;
 
    public static void main(String[] args) throws InterruptedException {
 
        // Create a new instance of the Firefox driver
 
        driver = new FirefoxDriver();
 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Online Store Website
 
        //driver.get("http://54.200.44.56/web/site/home");
        driver.get("http://54.200.44.56/qrda-validator");
        
       driver.findElement(By.xpath("//input[@name='qrdauploadfile']")).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\2_Tom_Gray-Cat I.xml");
       driver.findElement(By.xpath("//button[@id='qrdavalidate_btn']")).click();

          //wait for 20 seconds 
      Thread.sleep(20000);
       
        driver.quit();
        
    }

}