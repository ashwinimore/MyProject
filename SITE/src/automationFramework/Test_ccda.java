package automationFramework;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjects.Ccda_page;

public class Test_ccda {
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
  public void testCcda() throws Exception {
    
	 //open ccda validator page
	driver.get(baseUrl);
    Ccda_page.Ccda_Link_Under_HomeNav(driver);
    driver.get("http://54.200.44.56/web/site/c-cda-validator");
    
    //C-CDA R2.0 Validator 
    Ccda_page.Click_R2Validator_Link(driver);
    Ccda_page.Test_ccdaR2Validation(driver);
    
    //Test validation for C-CDA R1.1 or MU Stage 2 Validator document types
    Ccda_page.Click_R1Validator_Link(driver);
    Ccda_page.Testcase_MU2_170314e2_ClinicalSummary_Validation(driver);
    Ccda_page.Testcase_MU2_170314b2_TransitionofCareReferralSummary_ForAmbulatoryCare_Validation(driver);
    Ccda_page.Testcase_MU2_170314b7_DataPortability_ForAmbulatoryCare_Validation(driver);
    Ccda_page.Testcase_MU2_170314b1_TransitionofCareReceive_ForAmbulatoryCare_Validation(driver);
    Ccda_page.Testcase_MU2_170314b2_TransitionofCareReferralSummary_ForInpatientCare_Validation(driver);
    Ccda_page.Testcase_MU2_170314b7_DataPortability_ForInpatientCare_Validation(driver);
    Ccda_page.Testcase_MU2170314b1_TransitionofCareReceive_ForInpatientCare_Validation(driver);
    Ccda_page.Testcase_MU2_170314e1_VDTAmbulatorySummary_AmbulatorySummary_Validation(driver);
    Ccda_page.Testcase_MU2_170314e1_VDTAmbulatorySummary_InpatientSummary_Validation(driver);
    Ccda_page.Testcase_CCDAR1Document_Validation(driver);
    
    
    //C-CDA R2.0 Validator 
    Ccda_page.Click_R2Validator_Link(driver);
    Ccda_page.Test_ccdaR2Validation(driver);
    
   
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