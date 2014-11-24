package automationFramework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Qrda {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "http://54.200.44.56/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testQrda() throws Exception {
	  
	  driver.get(baseUrl + "/web/site/home");
	  driver.findElement(By.xpath("(//a[contains(text(),'View details �')])[4]")).click();
	  driver.findElement(By.cssSelector("span.caption-head")).click();
	  driver.findElement(By.xpath("//div[@id='article_10154_10180_11797_1.0']/div/div/div[2]/a/span/span[2]")).click();
	  driver.findElement(By.xpath("//div[@id='article_10154_10180_11797_1.0']/div/div/div[3]/a/span/span")).click();
	  driver.findElement(By.xpath("//div[@id='article_10154_10180_11797_1.0']/div/div[3]/div/a/span/span")).click();
	  driver.findElement(By.xpath("//div[@id='article_10154_10180_11797_1.0']/div/div[3]/div[2]/a/span/span[2]")).click();
	  driver.get("http://54.200.44.56/qrda-validator");
      
    driver.findElement(By.xpath("//input[@name='qrdauploadfile']")).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\2_Tom_Gray-Cat I.xml");
    driver.findElement(By.xpath("//button[@id='qrdavalidate_btn']")).click();
    Thread.sleep(20000);
    driver.findElement(By.id("tabs-1")).getText().contains("The file: 2_Tom_Gray-Cat I.xml was uploaded successfully.");
    driver.findElement(By.id("tabs-1")).getText().contains("QRDA category selected: categoryI");
    String bodyText1 = driver.findElement(By.tagName("body")).getText();
    assertTrue("Text not found!", bodyText1.contains("Validation Succeeded"));
    driver.findElement(By.linkText("Original QRDA")).click();
    Thread.sleep(10000);
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    Thread.sleep(5000);
    
  //negative cases coverage for catI
    driver.findElement(By.xpath("//input[@name='qrdauploadfile']")).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\CDAR2_IG_QRDA_CATIII_RI_NOV_Good.xml");
    driver.findElement(By.xpath("//button[@id='qrdavalidate_btn']")).click();
    Thread.sleep(20000);
    driver.findElement(By.id("tabs-1")).getText().contains("Validation Failed.");
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    Thread.sleep(5000);
    //Error pop up
    driver.findElement(By.xpath("//input[@name='qrdauploadfile']")).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\test(3).pdf");
    driver.findElement(By.xpath("//button[@id='qrdavalidate_btn']")).click();
    driver.findElement(By.className("formErrorContent")).getText().contains("* The selected QRDA file must be an xml file (.xml).");
    
    Select select = new Select(driver.findElement(By.tagName("select")));
    //select.deselectAll();
    
    assertFalse(select.isMultiple());
    assertEquals(2,select.getOptions().size());
    select.selectByVisibleText("Category III");
    driver.findElement(By.xpath("//input[@name='qrdauploadfile']")).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\CDAR2_IG_QRDA_CATIII_RI_NOV_Good.xml");
    driver.findElement(By.xpath("//button[@id='qrdavalidate_btn']")).click();  
    Thread.sleep(20000);
    driver.findElement(By.id("tabs-1")).getText().contains("The file: CDAR2_IG_QRDA_CATIII_RI_NOV_Good.xml was uploaded successfully.");
    driver.findElement(By.id("tabs-1")).getText().contains("QRDA category selected: categoryIII");
    String bodyText = driver.findElement(By.tagName("body")).getText();
    assertTrue("Text not found!", bodyText.contains("Validation Succeeded"));
    driver.findElement(By.linkText("Original QRDA")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    Thread.sleep(5000);
   
    //negative cases coverage for catIII
    driver.findElement(By.xpath("//input[@name='qrdauploadfile']")).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\2_Tom_Gray-Cat I.xml");
    driver.findElement(By.xpath("//button[@id='qrdavalidate_btn']")).click();
    Thread.sleep(20000);
    driver.findElement(By.id("tabs-1")).getText().contains("Validation Failed.");
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    Thread.sleep(5000);
    
      
    
    
    driver.findElement(By.id("qrda_releaseNote_popup")).click();
    driver.findElement(By.cssSelector("#qrdaReleaseModal > div.modal-dialog > div.modal-content > div.modal-footer > button.btn.btn-default")).click();
    driver.findElement(By.linkText("Category I Standard")).click();
    driver.findElement(By.linkText("Category III Standard")).click();
    
  }

   
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
