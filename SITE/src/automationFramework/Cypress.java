package automationFramework;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjects.Cypress_Page;

public class Cypress {
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
  
  public void HomePage() throws Exception {
	driver.get(baseUrl);
	Cypress_Page.Cypress_Link_Under_HomeNav(driver);
  }	
	@Test
	public void testCypress() throws Exception {
    driver.get(baseUrl + "/web/site/cqm-certification");
    Cypress_Page.Test_Cypress_KnowledgeBase_Link(driver);
    Cypress_Page.Test_Cypress_Forum_Link(driver);
    Cypress_Page.Test_Cypress_IssueTracker_Link(driver);
    Cypress_Page.Test_Cypress_SampleRepo_Link(driver);
    Cypress_Page.Test_Cypress_InstallCypress_Link(driver);
    Cypress_Page.Test_Cypress_DemoCypress_Link(driver);
    
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
