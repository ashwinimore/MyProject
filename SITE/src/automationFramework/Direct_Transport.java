package automationFramework;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjects.DirectTransport_page;

public class Direct_Transport {
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
  public void testDirectTransport() throws Exception {
    driver.get(baseUrl + "/web/site/home");
   
       
    driver.get("http://54.200.44.56/web/site/direct-transport-test-tool");
    
    DirectTransport_page.Print_DirectSendMessages_TotalCount(driver);
    DirectTransport_page.Print_DirectReceiveMessages_TotalCountAtTheStart(driver);
    
    
    //DirectTransport_page.Test_DirectspecificationsLink(driver);
   
    DirectTransport_page.Test_BlueButton1ink1(driver);
    DirectTransport_page.Test_BlueButton1ink2(driver);
    DirectTransport_page.Test_BlueButton1ink3(driver);
    DirectTransport_page.Test_BlueButton1ink4(driver);
    
    DirectTransport_page.Test_TrustBundleLink(driver);
    DirectTransport_page.Test_DirectSitenvOrgLink(driver);
    
    //DirectTransport_page.Test_DirectSitenvOrgCertificateLink(driver);
    
    
   
    DirectTransport_page.AnchorUploadFile(driver);
    DirectTransport_page.AnchorUpload_SubmitBtn(driver);
    
    
    DirectTransport_page.PickSampleBtn(driver);
    DirectTransport_page.PrecannedSample(driver);
    DirectTransport_page.PrecannedSubmitBtn(driver);
   
    DirectTransport_page.VerifyErrorOnBlankEndpoint(driver);
    DirectTransport_page.EnterPrecannedEmail(driver);
    DirectTransport_page.PrecannedSubmitBtn(driver);
    
    //Check thunderbird on vmtest to verify email has been received
    DirectTransport_page.MainContent(driver);
    DirectTransport_page.ChooseYourOwnContent(driver);
    

    DirectTransport_page.CcdaUploadFile_Sample(driver);
    DirectTransport_page.SubmitCcdaUpload(driver);
    
    
    
    DirectTransport_page.MainContent(driver);
    DirectTransport_page.ChoosePrecannedContent(driver);
    
    DirectTransport_page.EnterDirectReceiveEmailAddress(driver);
    
   
    //provider2@direct2.sitenv.org account for receive
    
    
    DirectTransport_page.Pick_Precanned_Sample_CCDA_File_to_Send_and_Submit(driver);
    
    driver.navigate().refresh();
    
    DirectTransport_page.Print_DirectSendMessages_TotalCount(driver);
    DirectTransport_page.Print_DirectReceiveMessages_TotalCountAtTheStart(driver);
   
    
    //Test reference links in Transport Resources
    DirectTransport_page.Test_Reference_Links(driver);
   
    
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
