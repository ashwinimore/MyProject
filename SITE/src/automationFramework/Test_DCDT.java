package automationFramework;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import PageObjects.DCDT_page;

public class Test_DCDT {
  private WebDriver driver;
  private String baseUrl;

  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "http://54.200.44.56/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDCDT() throws Exception {
    driver.get(baseUrl + "/web/site/home");

    DCDT_page.Test_DirectTransportLink_under_Home_Menu(driver);
    DCDT_page.Verify_DCDT_Thumbnail_Link(driver);
    
    String j = driver.getTitle();
    System.out.println(j);
    
    driver.get("54.200.44.56/web/site/direct-certificate-discovery-tool");
    
    //Automatic scrolling
    DCDT_page.Test_AutoScroll_Hosting_Works(driver);
    
    DCDT_page.Verify_multiple_selection(driver);
     
    //H1
    DCDT_page.HostingTest_H1(driver);
    
    //Reset button under hosting
    DCDT_page.Verify_HostingReset_Works(driver);
        
    //H2
    DCDT_page.HostingTest_H2(driver);
   
    //H3   
    DCDT_page.HostingTest_H3(driver);
   
    //H4
    DCDT_page.HostingTest_H4(driver);
    
    //Scroll to discover certificate section
    DCDT_page.Test_AutoScroll_Discovery_Works(driver);
    //driver.findElement(By.linkText("Download Trust Anchor")).click();
    //Thread.sleep(5000);
    //Alert alert=driver.switchTo().alert();
    //String alertText = alert.getText();
	//System.out.println(alertText);
    //alert.accept(); 
    
    DCDT_page.Verify_ErrorOnInvalidEmailAddress(driver);
           
    DCDT_page.Verify_DiscoveryReset_Works(driver);
    
    DCDT_page.Verify_Mapping_of_EmailAddress(driver);
    
    //Select Discovery Test Case
   
    //driver.findElement(By.id("testcase-select")).click();
    Select select2 = new Select(driver.findElement(By.id("testcase-select")));
    select2.selectByVisibleText("D1 - Valid address-bound certificate discovery in DNS");
    
    //Direct Instance
    driver.get("http://54.200.44.56/web/site/direct-transport-test-tool");
    driver.findElement(By.id("anchoruploadfile")).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\direct.sitenv.org_ca");
    driver.findElement(By.id("anchoruploadsubmit")).click();
    
    driver.findElement(By.xpath("//div[@id='main-content']/div[2]")).click();
    driver.findElement(By.id("precannedemail")).sendKeys("d1@domain1.demo.direct-test.com");
    driver.findElement(By.id("dLabel")).click();
    driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div[1]/div/div[1]/div/form/div/div/div/div[1]/ul/li/div/ul/li/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
    driver.findElement(By.id("precannedCCDAsubmit")).click();
    
    //Verify if email is received at mapped email address
    
     
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
