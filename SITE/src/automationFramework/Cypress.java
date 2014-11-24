package automationFramework;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cypress {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "http://54.200.44.56/";
    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
  }

  @Test
  public void test() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("(//a[contains(text(),'View details �')])[10]")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("span.caption-body")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='article_10154_10180_20418_1.0']/div/div/div[2]/a/span/span[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='article_10154_10180_20418_1.0']/div/div/div[3]/a/span/span")).click();
    Thread.sleep(2000);  
    driver.findElement(By.xpath("//div[@id='article_10154_10180_20418_1.0']/div/div[3]/div[2]/a/span/span[2]")).click();
    Thread.sleep(2000);
       
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
