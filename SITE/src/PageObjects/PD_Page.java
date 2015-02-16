package PageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PD_Page {

private static WebElement element = null;

public static WebElement Enter_BaseDN(WebDriver driver){

element = driver.findElement(By.id("baseDn"));


return element;

}

public static WebElement Enter_EndpointUrl(WebDriver driver){

element = driver.findElement(By.id("endpointUrl"));

return element;
}

public static WebElement Button_Submit(WebDriver driver){
	element = driver.findElement(By.id("querySubmit"));

	return element;

}
public static WebElement Check_Error_On_Blank_BaseDN(WebDriver driver){
	element = driver.findElement(By.className("formErrorContent"));

	return element;

}
public static WebElement Verify_TestCase_Failure_Incorrect_wsdl(WebDriver driver){
	element = driver.findElement(By.cssSelector("span.label.label-danger"));
	
	return element;

}
public static WebElement Close_button_to_close_results_popup(WebDriver driver){
	element = driver.findElement(By.cssSelector("button.btn.btn-default"));

	return element;

}
public static WebElement Verify_TestCase_Success(WebDriver driver){
	//element = driver.findElement(By.cssSelector("span.label.label-success"));
element = driver.findElement(By.cssSelector("span.label.label-success"));
	
	return element;

}

public static WebElement Select_Testcase_from_Dropdown(WebDriver driver){
	element = driver.findElement(By.tagName("select"));

	return element;

}
public static void Verify_multiple_selection(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 assertFalse(select.isMultiple());
     assertEquals(15,select.getOptions().size());
	 
}
public static void Testcase_Search_Provider_by_Name(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Search Provider by Name");
     PD_Page.Button_Submit(driver).click();
     PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
     PD_Page.Close_button_to_close_results_popup(driver).click();
   
}
public static void Testcase_Search_Organization_by_Id(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Search Organization by Id");
     PD_Page.Button_Submit(driver).click();
     PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
     PD_Page.Close_button_to_close_results_popup(driver).click();
  
}
public static void Testcase_Search_Service_by_Id(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Search Service by Id");
    PD_Page.Button_Submit(driver).click();
    PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
    PD_Page.Close_button_to_close_results_popup(driver).click();
 
}
public static void Testcase_Search_Credential_by_Id(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Search Credential by Id");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}
public static void Testcase_Find_Individual(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Find Individual");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}
public static void Testcase_Find_Uniqe_Individual(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Find Unique Individual");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}
public static void Testcase_Find_Organization(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Find Organization");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}
public static void Testcase_Find_Unique_Organization(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Find Unique Organization");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}
public static void Testcase_Find_Organizations_for_Unique_Individual(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Find Organizations for Unique Individual");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}
public static void Testcase_Find_Individuals_for_Unique_Organization(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Find Individuals for Unique Organization");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}
public static void Testcase_Find_Individuals_and_Organizations(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("Find Individuals and Organizations");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}
public static void Testcase_Find_Members_for_Unique_Relationship(WebDriver driver){
	 
   Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
   select.selectByVisibleText("Find Members for Unique Relationship");
   PD_Page.Button_Submit(driver).click();
   PD_Page.Verify_TestCase_Success(driver).getText().contains("PASSED");
   PD_Page.Close_button_to_close_results_popup(driver).click();

}

}