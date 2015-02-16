package automationFramework;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.Qrda_Page;

//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.chrome.ChromeDriver;



public class Qrda {
  private WebDriver driver;
  private String baseUrl;
  
  private StringBuffer verificationErrors = new StringBuffer();
  

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    //System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriverServer\\IEDriverServer.exe");
   //driver = new InternetExplorerDriver();
   // System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromedriver\\chromedriver.exe");
   // driver = new ChromeDriver();
    driver.manage().window().maximize();
    baseUrl = "http://54.200.44.56/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testQrda() throws Exception {
	  driver.get(baseUrl);
	  
	  
	 
	  //Verify Links
	 // Qrda_Page.Verify_Reference_Links(driver);
	  
	//Redirect to QRDA tool Page
	  driver.get("http://54.200.44.56/qrda-validator");
	  
	 
	// File test = getClass().getClassLoader().getResourceAsStream("/SITE/resources/files/test.pdf");

	//  File testpdf = new File("/SITE/resources/files/test.pdf");
		
	  //Error pop up
		driver.findElement(By.id("qrdauploadfile")).sendKeys("testpdf");
		Qrda_Page.Invalid_FileType_Sample(driver);
		Qrda_Page.Validate_Button(driver);
	    Qrda_Page.Verify_Error_On_Invalid_FileType(driver);
	  
       
	//Category dropdown
	  Qrda_Page.Verify_multiple_selection(driver);
	
	//CatI validation
	Qrda_Page.Testcase_CatI_Validation(driver);
	
	
    
  //negative cases coverage for catI
  //  Qrda_Page.Verify_CatI_Validation_failure_for_invalid_Sample(driver);
    
    
    
    
    //CatIII validation
    Qrda_Page.Testcase_CatIII_Validation(driver);
    
    //negative cases coverage for catIII
   // Qrda_Page.Verify_CatIII_Validation_failure_for_invalid_Sample(driver);
      
    //Verify Resource Links
    Qrda_Page.Verify_ReleaseNote_Link(driver);
    Qrda_Page.Close_Releaseote_Popup(driver);
    Qrda_Page.Verify_CatIStandard_Link(driver);
    Qrda_Page.Verify_CatIIIStandard_Link(driver);
    
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



 