package automationFramework;

import java.io.IOException;

import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class AutoIt {
 
    private static WebDriver driver = null;
 
    public static void main(String[] args) throws IOException, InterruptedException {
 
        driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get("http://54.200.44.56/qrda-validator");
 
        driver.findElement(By.id("qrdauploadfile")).click();
 
        Runtime.getRuntime().exec("C:\\Users\\amore\\Desktop\\Selenium\\AutoIt\\qrdupld1");
 
        Thread.sleep(5000);
 
      //  driver.close();
 
    }
 
}