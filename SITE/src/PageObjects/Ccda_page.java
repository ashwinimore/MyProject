package PageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Ccda_page {

	private static WebElement element = null;

	
	public static void Ccda_Link_Under_HomeNav(WebDriver driver){

		WebElement menu=driver.findElement(By.xpath("//html/body/div[1]/div/div/nav/ul/li[1]/a/span"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menu).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/nav/ul/li[1]/div/ul/li[1]/a")));
		WebElement menuOption = driver.findElement(By.xpath("/html/body/div[1]/div/div/nav/ul/li[1]/div/ul/li[1]/a"));
		menuOption.click();
	}
	public static WebElement Click_R1Validator_Link(WebDriver driver){

		element = driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/div[1]/h4/a"));
		element.click(); 
		return element;
		}	
	public static WebElement R1Validator_DocTypes_Dropdown(WebDriver driver){

		element = driver.findElement(By.id("CCDA1_type_val"));
		element.click(); 
		return element;
		}	
	public static void Verify_Document_Types_for_R1Validator(WebDriver driver){
		Select select = new Select(Ccda_page.R1Validator_DocTypes_Dropdown(driver));
		assertFalse(select.isMultiple());
	    assertEquals(10,select.getOptions().size());
		
		}	
	
	public static WebElement Upload_ccda_file_button(WebDriver driver){

		element = driver.findElement(By.id("CCDA1fileupload"));
		
		return element;
		}	
	
	public static void Upload_ccda_file(WebDriver driver){

		Ccda_page.Upload_ccda_file_button(driver).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\Test cases\\170.314(b)(1)InPt_Discharge Summary CED Type.xml");
		}	
	public static WebElement Validate_button(WebDriver driver){

		element = driver.findElement(By.id("CCDA1formSubmit"));
		element.click(); 
		return element;
		}	
	
	public static WebElement Results_popup(WebDriver driver){

		element = driver.findElement(By.id("tabs-1"));
				
		return element;
		}
	
	public static WebElement File_Upload_Success_Message_R1(WebDriver driver){

		Ccda_page.Results_popup(driver).getText().contains("170.314(b)(1)InPt_Discharge Summary CED Type.xml was uploaded successfully.");
		
		
		return element;
		}
	public static WebElement File_Upload_Success_Message_R2(WebDriver driver){

		Ccda_page.Results_popup(driver).getText().contains("Encounter Based C-CDA CCD - 08-06-2012 [Jones, Isabella - 170314E2].xml was uploaded successfully.");
		
		
		return element;
		}
	
	public static WebElement smartCCDAValidation_Btn(WebDriver driver){

		element = driver.findElement(By.id("smartCCDAValidationBtn"));
		element.click(); 
		element.getText().contains("Vitals are expressed with UCUM units");
		return element;
		}	
	public static WebElement saveResults_Btn(WebDriver driver){

		element = driver.findElement(By.id("saveResultsBtn"));
		element.click(); 
		return element;
}
	public static WebElement closeResults_Btn(WebDriver driver){

		element =  driver.findElement(By.id("closeResultsBtn"));
		element.click(); 
		return element;
		}
	public static WebElement Select_Testcase_from_Dropdown(WebDriver driver){
		element = driver.findElement(By.tagName("select"));

		return element;

	}
	public static void Testcase_MU2_170314e2_ClinicalSummary_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("Clinical Office Visit Summary - MU2 170.314(e)(2) - Clinical Summary");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	    Ccda_page.File_Upload_Success_Message_R1(driver);
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	
	public static void Testcase_MU2_170314b2_TransitionofCareReferralSummary_ForAmbulatoryCare_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("Transitions Of Care Ambulatory Summary - MU2 170.314(b)(2) Transition of Care/Referral Summary - For Ambulatory Care");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	    
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	public static void Testcase_MU2_170314b7_DataPortability_ForAmbulatoryCare_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("Transitions Of Care Ambulatory Summary - MU2 170.314(b)(7) Data Portability - For Ambulatory Care");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	   
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	public static void Testcase_MU2_170314b1_TransitionofCareReceive_ForAmbulatoryCare_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("Transitions Of Care Ambulatory Summary - MU2 170.314(b)(1) Transition of Care Receive - For Ambulatory Care");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	    
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	public static void Testcase_MU2_170314b2_TransitionofCareReferralSummary_ForInpatientCare_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("Transitions Of Care Inpatient Summary - MU2 170.314(b)(2) Transition of Care/Referral Summary - For Inpatient Care");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	    
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	public static void Testcase_MU2_170314b7_DataPortability_ForInpatientCare_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("Transitions Of Care Inpatient Summary - MU2 170.314(b)(7) Data Portability - For Inpatient Care");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	  
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	public static void Testcase_MU2170314b1_TransitionofCareReceive_ForInpatientCare_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("Transitions Of Care Inpatient Summary - MU2 170.314(b)(1) Transition of Care Receive - For Inpatient Care");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	   
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	public static void Testcase_MU2_170314e1_VDTAmbulatorySummary_AmbulatorySummary_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("VDT Ambulatory Summary - MU2 170.314 (e)(1) Ambulatory Summary");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	   
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	public static void Testcase_MU2_170314e1_VDTAmbulatorySummary_InpatientSummary_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("VDT Inpatient Summary - MU2 170.314 (e)(1) Inpatient Summary");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	    Ccda_page.File_Upload_Success_Message_R1(driver);
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	public static void Testcase_CCDAR1Document_Validation(WebDriver driver){
		 
		Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
		 select.selectByVisibleText("C-CDA R1.1 Document");
	     Ccda_page.Upload_ccda_file(driver);
	     Ccda_page.Validate_button(driver);
	 
	    Ccda_page.closeResults_Btn(driver);
	   
	}
	
	public static WebElement Click_R2Validator_Link(WebDriver driver){

		element = driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/div[1]/div[2]/div/div[2]/div[1]/h4/a"));
		element.click(); 
		return element;
		}		   
	
	public static WebElement Upload_ccda2_file_button(WebDriver driver){

		element = driver.findElement(By.id("CCDA2fileupload"));
		
		return element;
		}	
	public static WebElement ccda2Validate_button(WebDriver driver){

		element = driver.findElement(By.id("CCDA2formSubmit"));
		element.click(); 
		return element;
		}	
	
	public static void Upload_ccda2_file(WebDriver driver){

		Ccda_page.Upload_ccda2_file_button(driver).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\Test cases\\Encounter Based C-CDA CCD - 08-06-2012 [Jones, Isabella - 170314E2].xml");
		}	
	
	public static void Test_ccdaR2Validation(WebDriver driver){
		Ccda_page.Upload_ccda2_file(driver);
		Ccda_page.ccda2Validate_button(driver);
		Ccda_page.File_Upload_Success_Message_R2(driver);
		Ccda_page.closeResults_Btn(driver);

		}	
	
}



