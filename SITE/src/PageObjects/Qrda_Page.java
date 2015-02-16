package PageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qrda_Page {

private static WebElement element = null;

public static void Test_QRDALink_under_Home_Menu(WebDriver driver){

	WebElement menu=driver.findElement(By.xpath("//html/body/div[1]/div/div/nav/ul/li[1]/a/span"));
	Actions builder = new Actions(driver);
	builder.moveToElement(menu).build().perform();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div/div/nav/ul/li[1]/div/ul/li[4]/a")));
	WebElement menuOption = driver.findElement(By.xpath("//html/body/div[1]/div/div/nav/ul/li[1]/div/ul/li[4]/a"));
	menuOption.click();
}

public static WebElement Verify_Forum_Thumbnail_Link(WebDriver driver){

element =  driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[1]/a/span/span[2]"));
element.click();

return element;
}
public static WebElement Verify_IssueTracker_Thumbnail_Link(WebDriver driver){

element =  driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/a/span/span[2]"));
element.click();

return element;
}
public static WebElement Verify_SampleRepository_Thumbnail_Link(WebDriver driver){

element = driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[3]/a/span"));
element.click();

return element;
}
public static WebElement Verify_CotributeQrda_Thumbnail_Link(WebDriver driver){

element = driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div[1]/a/span/span[1]"));
element.click();

return element;
}
public static WebElement Verify_QrdaValidator_Thumbnail_Link(WebDriver driver){

element = driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div[2]/a/span/span[2]"));
element.click();

return element;
}
public static WebElement File_Upload_CatI(WebDriver driver){

element = driver.findElement(By.id("qrdauploadfile"));

return element;

}

public static void File_Upload_CatI_Sample(WebDriver driver){

	Qrda_Page.File_Upload_CatI(driver).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\Test cases\\2_Tom_Gray-Cat I.xml");

}

public static void File_Upload_CatIII_Sample(WebDriver driver){

	Qrda_Page.File_Upload_CatI(driver).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\Test cases\\CDAR2_IG_QRDA_CATIII_RI_NOV_Good.xml");

}
public static void Invalid_FileType_Sample(WebDriver driver){

	Qrda_Page.File_Upload_CatI(driver).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\test.pdf");

}

public static WebElement Validate_Button(WebDriver driver){

element = driver.findElement(By.id("qrdavalidate_btn"));
element.click();
return element;
}

public static WebElement Select_Testcase_from_Dropdown(WebDriver driver){
	element = driver.findElement(By.tagName("select"));

	return element;

}

public static void Verify_multiple_selection(WebDriver driver){
	 
	Select select = new Select(Qrda_Page.Select_Testcase_from_Dropdown(driver));
	assertFalse(select.isMultiple());
    assertEquals(2,select.getOptions().size());
	 
}

public static void Testcase_CatI_Validation(WebDriver driver) throws InterruptedException{
		   
    Select select = new Select(Qrda_Page.Select_Testcase_from_Dropdown(driver));
    select.selectByVisibleText("Category I");
	Qrda_Page.File_Upload_CatI_Sample(driver);
    Qrda_Page.Validate_Button(driver);
    Qrda_Page.File_Upload_Success_Message(driver);
    Qrda_Page.Validation_Success_Message(driver);  
    Qrda_Page.Verify_Original_Qrda(driver);
    Qrda_Page.Close_ValidationResults_Popup(driver);
  
}


public static WebElement File_Upload_Success_Message(WebDriver driver){

element = driver.findElement(By.id("tabs-1"));
element.getText().contains("The file: 2_Tom_Gray-Cat I.xml was uploaded successfully.");
element.getText().contains("QRDA category selected: categoryI");

return element;
}

public static WebElement Validation_Success_Message(WebDriver driver){

element = driver.findElement(By.tagName("body"));
String bodyText1 =element.getText();
assertTrue("Text not found!", bodyText1.contains("Validation Succeeded"));

return element;
}

public static WebElement Verify_Original_Qrda(WebDriver driver){

element = driver.findElement(By.linkText("Original QRDA"));
element.click();

return element;
}

public static WebElement Close_ValidationResults_Popup(WebDriver driver){

element = driver.findElement(By.cssSelector("button.btn.btn-default"));
element.click();

return element;
}

public static WebElement Failure_Message(WebDriver driver){

element = driver.findElement(By.id("tabs-1"));
element.getText().contains("Validation Failed.");

return element;
}

public static void Verify_CatI_Validation_failure_for_invalid_Sample(WebDriver driver){
	
	Select select = new Select(Qrda_Page.Select_Testcase_from_Dropdown(driver));
    select.selectByVisibleText("Category I");
	Qrda_Page.File_Upload_CatI(driver).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\CDAR2_IG_QRDA_CATIII_RI_NOV_Good.xml");
	Qrda_Page.Validate_Button(driver);
	Qrda_Page.Failure_Message(driver);
	Qrda_Page.Close_ValidationResults_Popup(driver);

}


public static WebElement Verify_Error_On_Invalid_FileType(WebDriver driver){
	element = driver.findElement(By.className("formErrorContent"));
    element.getText().contains("* The selected QRDA file must be an xml file (.xml).");
	return element;

}


public static void Testcase_CatIII_Validation(WebDriver driver){
	 
	Select select = new Select(Qrda_Page.Select_Testcase_from_Dropdown(driver));
	select.selectByVisibleText("Category III");
	Qrda_Page.File_Upload_CatIII_Sample(driver);
    Qrda_Page.Validate_Button(driver);
    Qrda_Page.File_Upload_Success_Message(driver);
    Qrda_Page.Validation_Success_Message(driver);  
    Qrda_Page.Verify_Original_Qrda(driver);
    Qrda_Page.Close_ValidationResults_Popup(driver);
}
public static void Verify_CatIII_Validation_failure_for_invalid_Sample(WebDriver driver){

Qrda_Page.File_Upload_CatI_Sample(driver);
Qrda_Page.Validate_Button(driver);
Qrda_Page.Failure_Message(driver);
Qrda_Page.Close_ValidationResults_Popup(driver);

}

public static WebElement Verify_ReleaseNote_Link(WebDriver driver){

element = driver.findElement(By.id("qrda_releaseNote_popup"));
element.click();

return element;
}
public static WebElement Verify_CatIStandard_Link(WebDriver driver){

element = driver.findElement(By.linkText("Category I Standard"));
element.click();

return element;
}
public static WebElement Verify_CatIIIStandard_Link(WebDriver driver){

element = driver.findElement(By.linkText("Category III Standard"));
element.click();

return element;
}
public static WebElement Close_Releaseote_Popup(WebDriver driver){

element = driver.findElement(By.cssSelector("#qrdaReleaseModal > div.modal-dialog > div.modal-content > div.modal-footer > button.btn.btn-default"));
element.click();

return element;
}

public static void Verify_Reference_Links(WebDriver driver){

	Qrda_Page.Test_QRDALink_under_Home_Menu(driver);
	  Qrda_Page.Verify_Forum_Thumbnail_Link(driver);
	  Qrda_Page.Verify_IssueTracker_Thumbnail_Link(driver);
	  Qrda_Page.Verify_SampleRepository_Thumbnail_Link(driver);
	  Qrda_Page.Verify_CotributeQrda_Thumbnail_Link(driver);
	  Qrda_Page.Verify_QrdaValidator_Thumbnail_Link(driver);
}



}