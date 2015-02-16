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
public class DCDT_page {

private static WebElement element = null;

public static void Test_DirectTransportLink_under_Home_Menu(WebDriver driver){

	WebElement menu=driver.findElement(By.xpath("//html/body/div[1]/div/div/nav/ul/li[1]/a/span"));
	Actions builder = new Actions(driver);
	builder.moveToElement(menu).build().perform();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/nav/ul/li[1]/div/ul/li[2]/a")));
	WebElement menuOption = driver.findElement(By.xpath("/html/body/div[1]/div/div/nav/ul/li[1]/div/ul/li[2]/a"));
	menuOption.click();
}

public static WebElement Verify_DCDT_Thumbnail_Link(WebDriver driver){

element =  driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div/div[2]/a/span/span[2]"));
element.click();

return element;
}

//Automatic scrolling
public static WebElement Test_AutoScroll_Hosting_Works(WebDriver driver){

element = driver.findElement(By.xpath("//a[contains(@href,\"#panel_hosting\")]"));
element.click();

return element;
}
public static WebElement Test_AutoScroll_Discovery_Works(WebDriver driver){

element = driver.findElement(By.xpath("//a[contains(@href,\"#panel_discovery\")]"));
element.click();

return element;
}

public static WebElement Select_Testcase_from_Dropdown(WebDriver driver){
	element = driver.findElement(By.tagName("select"));

	return element;

}
public static void Verify_multiple_selection(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 assertFalse(select.isMultiple());
     assertEquals(5,select.getOptions().size());
	 
}

public static WebElement DirectAddressForHosting(WebDriver driver){
	element = driver.findElement(By.id("testcase-hosting-direct-addr"));

	return element;

}
public static void DirectAddresss_Input(WebDriver driver){

	DCDT_page.DirectAddressForHosting(driver).sendKeys("provider1@direct.sitenv.org");

}

public static WebElement SubmitBtn(WebDriver driver){
	element = driver.findElement(By.id("testcase-hosting-submit"));
	element.click();
	return element;

}
public static void Verify_H1Test_output(WebDriver driver){

	driver.getPageSource().contains("Success: false");
    driver.getPageSource().contains("DNS lookup (recordType=SRV, directAddrName=_ldap._tcp.direct.sitenv.org.) failed");
    driver.getPageSource().contains("Discovered Valid Certificate: None");
    driver.getPageSource().contains("Discovered Invalid Certificate(s): None");
    System.out.println("Test case H1");

}
public static void Verify_HostingReset_Works(WebDriver driver){
	
DCDT_page.Hosting_ResetBtn(driver).click();

}
public static void Verify_H2Test_output(WebDriver driver){

	 driver.getPageSource().contains("Success: true");
	    driver.getPageSource().contains("DNS lookup (recordType=CERT, directAddrName=direct.sitenv.org) was successful:");
    System.out.println("Test case H2");

}
public static void Verify_H3Test_output(WebDriver driver){

	driver.getPageSource().contains("Success: false");
    driver.getPageSource().contains("DNS lookup (recordType=SRV, directAddrName=_ldap._tcp.direct.sitenv.org.) failed");
    driver.getPageSource().contains("Discovered Valid Certificate: None");
    driver.getPageSource().contains("Discovered Invalid Certificate(s): None");
    System.out.println("Test case H3");
}
public static void Verify_H4Test_output(WebDriver driver){

	driver.getPageSource().contains("Success: false");
    driver.getPageSource().contains("DNS lookup (recordType=SRV, directAddrName=_ldap._tcp.direct.sitenv.org.) failed");
    driver.getPageSource().contains("Discovered Valid Certificate: None");
    driver.getPageSource().contains("Discovered Invalid Certificate(s): None");
    System.out.println("Test case H4");

}



public static void HostingTest_H1(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("H1 - Normal address-bound certificate search in DNS");
	 DCDT_page.DirectAddresss_Input(driver);
	 DCDT_page.SubmitBtn(driver);
	 DCDT_page.Verify_H1Test_output(driver);
  
}
public static void HostingTest_H2(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("H2 - Normal domain-bound certificate search in DNS");
	 //DCDT_page.DirectAddresss_Input(driver);
	 DCDT_page.SubmitBtn(driver);
	 DCDT_page.Verify_H2Test_output(driver);
 
}
public static void HostingTest_H3(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("H3 - Normal address-bound certificate search in LDAP");
	 //DCDT_page.DirectAddresss_Input(driver);
	 DCDT_page.SubmitBtn(driver);
	 DCDT_page.Verify_H3Test_output(driver);

}
public static void HostingTest_H4(WebDriver driver){
	 
	 Select select = new Select(PD_Page.Select_Testcase_from_Dropdown(driver));
	 select.selectByVisibleText("H4 - Normal domain-bound certificate search in LDAP");
	 //DCDT_page.DirectAddresss_Input(driver);
	 DCDT_page.SubmitBtn(driver);
	 DCDT_page.Verify_H4Test_output(driver);

}
public static WebElement Discovery_ResetBtn(WebDriver driver){
	driver.findElement(By.id("discovery-mail-mapping-reset"));
	
	return element;

}

public static WebElement Hosting_ResetBtn(WebDriver driver){
	driver.findElement(By.id("testcase-hosting-reset"));
	
	return element;

}

public static void Verify_DiscoveryReset_Works(WebDriver driver){
	
DCDT_page.Discovery_ResetBtn(driver).click();

}
public static WebElement Discovery_EnterYourEmailAddress(WebDriver driver){

	element = driver.findElement(By.id("testcase-hosting-submit"));
	element.click();
	return element;

}
public static WebElement Discovery_EnterYourEmailAddressForResults(WebDriver driver){

	element = driver.findElement(By.id("resultsAddress"));
	element.click();
	return element;

}

public static void Discovery_EnterInvalidEmailAddressForResults(WebDriver driver){

	DCDT_page.Discovery_EnterYourEmailAddressForResults(driver).sendKeys("a@nqm");

}
public static WebElement Discovery_SubmitBtn(WebDriver driver){
	element = driver.findElement(By.id("discovery-mail-mapping-submit"));
	
	return element;

}
public static WebElement ErrorContent(WebDriver driver){
	element = driver.findElement(By.className("formErrorContent"));
	
	return element;

}

public static void ErrorOnInvalidEmailAddress(WebDriver driver){
	
DCDT_page.ErrorContent(driver).getText().contains("* Lookup of @ MX isnt done");
DCDT_page.ErrorContent(driver).getText().contains("* Must be a valid Direct address.");

}
public static void Verify_ErrorOnInvalidEmailAddress(WebDriver driver){
	
	DCDT_page.Discovery_EnterInvalidEmailAddressForResults(driver);
    DCDT_page.Discovery_SubmitBtn(driver).click();
    DCDT_page.ErrorOnInvalidEmailAddress(driver);

}
public static WebElement Discovery_DirectAddress(WebDriver driver){

	element = driver.findElement(By.id("directAddress"));
	
	return element;

}


public static void Discovery_EnterValidDirectEmailAddress(WebDriver driver){

	DCDT_page.Discovery_DirectAddress(driver).sendKeys("Provider1@direct.sitenv.org");

}
public static void Discovery_EnterValidEmailAddressForResults(WebDriver driver){

	DCDT_page.Discovery_EnterYourEmailAddressForResults(driver).sendKeys("amore@ainq.com");

}

public static void Verify_Success_Message_On_Mapping_of_EmailAddress(WebDriver driver){

	driver.getPageSource().contains("You have successfully associated the Direct address Provider1@direct.sitenv.org with the results address amore@ainq.com.");

}
public static void Verify_Mapping_of_EmailAddress(WebDriver driver){

	DCDT_page.Discovery_EnterValidDirectEmailAddress(driver);
    DCDT_page.Discovery_EnterValidEmailAddressForResults(driver);
    DCDT_page.Discovery_SubmitBtn(driver).click();
    DCDT_page.Verify_Success_Message_On_Mapping_of_EmailAddress(driver);
}


}
