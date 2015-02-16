 package automationFramework;


import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjects.PD_Page;


public class Test_PD {
	 private WebDriver driver;
	  private String baseUrl;
	 

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
		        
        driver.get("http://54.200.44.56/web/site/provider-directory-test-tool");
        String j = driver.getTitle();
        System.out.println(j);
        
        
        //Negative test coverage
        //Blank wsdl
         
        PD_Page.Enter_BaseDN(driver).sendKeys("o=dev.provider-directories.com,dc=hpd");
        PD_Page.Button_Submit(driver).click();
        PD_Page.Check_Error_On_Blank_BaseDN(driver).getText().contains("* This field is required");
        
        //Blank BaseDn
        PD_Page.Enter_EndpointUrl(driver).sendKeys("http://ec2-54-200-55-97.us-west-2.compute.amazonaws.com/pdti-server/ProviderInformationDirectory?wsdl");
        PD_Page.Enter_BaseDN(driver).clear();
        PD_Page.Button_Submit(driver).click();
        PD_Page.Check_Error_On_Blank_BaseDN(driver).getText().contains("* This field is required");
        
        //Invalid wsdl     
        
        PD_Page.Enter_BaseDN(driver).sendKeys("o=dev.provider-directories.com,dc=hpd");
        PD_Page.Button_Submit(driver).click();
        String bodyText1 = PD_Page.Verify_TestCase_Failure_Incorrect_wsdl(driver).getText();
        assertTrue("Text not found!", bodyText1.contains("FAILED"));
        System.out.println(bodyText1);
        
        PD_Page.Close_button_to_close_results_popup(driver).click();
        
        PD_Page.Enter_EndpointUrl(driver).clear();
        
        PD_Page.Enter_EndpointUrl(driver).sendKeys("http://ec2-54-200-55-97.us-west-2.compute.amazonaws.com/pdti-server/ProviderInformationDirectoryService?wsdl");
       
        PD_Page.Button_Submit(driver).click();
      
       //String bodyText = PD_Page.Verify_TestCase_Success(driver).getText();
       //assertTrue("Text not found!", bodyText.contains("PASSED"));
       //System.out.println(bodyText);
       
       PD_Page.Close_button_to_close_results_popup(driver).click();
      
       PD_Page.Select_Testcase_from_Dropdown(driver);
      
       PD_Page.Verify_multiple_selection(driver);
      
       //Test cases
       
       PD_Page.Testcase_Search_Provider_by_Name(driver);
       PD_Page.Testcase_Search_Organization_by_Id(driver);
       PD_Page.Testcase_Search_Service_by_Id(driver);
       PD_Page.Testcase_Search_Credential_by_Id(driver);
       PD_Page.Testcase_Find_Individual(driver);
       PD_Page.Testcase_Find_Uniqe_Individual(driver);
       PD_Page.Testcase_Find_Organization(driver);
       PD_Page.Testcase_Find_Unique_Organization(driver);
       PD_Page.Testcase_Find_Individuals_for_Unique_Organization(driver);
       PD_Page.Testcase_Find_Organizations_for_Unique_Individual(driver);
       PD_Page.Testcase_Find_Individuals_and_Organizations(driver);
       //PD_Page.Testcase_Find_Members_for_Unique_Relationship(driver);
       
      
       

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
