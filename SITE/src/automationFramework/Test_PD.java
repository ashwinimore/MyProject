package automationFramework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test_PD {
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
	public void test() throws Exception{
		
		driver.get(baseUrl + "/web/site/home");
		driver.findElement(By.xpath("(//a[contains(text(),'View details �')])[3]")).click();
		//driver.get("http://54.200.44.56/web/site/provider-directory");
        
        Thread.sleep(4000);
        
        driver.get("http://54.200.44.56/web/site/provider-directory-test-tool");
        String j = driver.getTitle();
        System.out.println(j);
        
        
        //Negative test coverage
        //Blank wsdl
        driver.findElement(By.xpath("//input[@id='baseDn']")).sendKeys("o=dev.provider-directories.com,dc=hpd");
        driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
        driver.findElement(By.className("formErrorContent")).getText().contains("* This field is required");
        
        //Blank BaseDn
        driver.findElement(By.xpath("//input[@id='endpointUrl']")).sendKeys("http://ec2-54-200-55-97.us-west-2.compute.amazonaws.com/pdti-server/ProviderInformationDirectory?wsdl");
        driver.findElement(By.xpath("//input[@id='baseDn']")).clear();
        driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
        driver.findElement(By.className("formErrorContent")).getText().contains("* This field is required");
        
        //Invalid wsdl     
        
        driver.findElement(By.xpath("//input[@id='baseDn']")).sendKeys("o=dev.provider-directories.com,dc=hpd");
        driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
        String bodyText1 = driver.findElement(By.cssSelector("span.label.label-danger")).getText();
        assertTrue("Text not found!", bodyText1.contains("FAILED"));
        System.out.println(bodyText1);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
        
        driver.findElement(By.xpath("//input[@id='endpointUrl']")).clear();
        
       driver.findElement(By.xpath("//input[@id='endpointUrl']")).sendKeys("http://ec2-54-200-55-97.us-west-2.compute.amazonaws.com/pdti-server/ProviderInformationDirectoryService?wsdl");
       
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       String bodyText = driver.findElement(By.cssSelector("span.label.label-success")).getText();
       assertTrue("Text not found!", bodyText.contains("PASSED"));
       System.out.println(bodyText);
       
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
       
       Select select = new Select(driver.findElement(By.tagName("select")));
       //select.deselectAll();
       
       assertFalse(select.isMultiple());
       assertEquals(13,select.getOptions().size());
       Thread.sleep(4000);
       select.selectByVisibleText("Search Provider by Name");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
       select.selectByVisibleText("Search Organization by Id");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(8000);
       select.selectByVisibleText("Search Membership by Id");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(5000);
       select.selectByVisibleText("Search Service by Id");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(5000);
       select.selectByVisibleText("Search Credential by Id");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(15000);
       select.selectByVisibleText("Find Individual");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
       select.selectByVisibleText("Find Unique Individual");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
       select.selectByVisibleText("Find Organization");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
       select.selectByVisibleText("Find Unique Organization");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
       select.selectByVisibleText("Find Organizations for Unique Individual");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
       select.selectByVisibleText("Find Individuals for Unique Organization");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
       select.selectByVisibleText("Find Individuals and Organizations");
       driver.findElement(By.xpath("//button[@id='querySubmit']")).click();
       Thread.sleep(4000);
       driver.findElement(By.cssSelector("span.label.label-success")).getText().contains("PASSED");
       driver.findElement(By.cssSelector("button.btn.btn-default")).click();
       Thread.sleep(4000);
             
       driver.findElement(By.id("providerDirectory_releaseNote_popup")).click();
       driver.findElement(By.cssSelector("#pdReleaseModal > div.modal-dialog > div.modal-content > div.modal-footer > button.btn.btn-default")).click();
       driver.findElement(By.linkText("IHE HPD Specifications")).click();
       driver.findElement(By.linkText("PDTI Documentation")).click();
       driver.findElement(By.linkText("Provider Directory Forums")).click();
       driver.findElement(By.linkText("Provider Directory Test Data")).click();
       
       driver.quit();
	}
	@After
	public void tearDown() throws Exception {
	}
}
