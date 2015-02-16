package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DirectTransport_page {

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

public static WebElement DirectSendMessages_TotalCount(WebDriver driver){

element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div/div/div[2]/table/tbody/tr[1]/td[2]"));

return element;
}
public static void Print_DirectSendMessages_TotalCount(WebDriver driver){

	String sCellValue1 = DirectTransport_page.DirectSendMessages_TotalCount(driver).getText();
    System.out.println(sCellValue1);
}

public static WebElement DirectReceiveMessages_TotalCount(WebDriver driver){

element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]"));

return element;
}
public static void Print_DirectReceiveMessages_TotalCountAtTheStart(WebDriver driver){

	String sCellValue1 = DirectTransport_page.DirectReceiveMessages_TotalCount(driver).getText();
    System.out.println(sCellValue1);
}
public static WebElement Test_DirectspecificationsLink(WebDriver driver){

element = driver.findElement(By.linkText("Direct specifications"));
element.click();

return element;
}
public static WebElement Test_BlueButton1ink1(WebDriver driver){

element = driver.findElement(By.linkText("BlueButton"));
element.click();

return element;
}
public static WebElement Test_BlueButton1ink2(WebDriver driver){

element = driver.findElement(By.xpath("(//a[contains(text(),'BlueButton')])[2]"));
element.click();

return element;
}
public static WebElement Test_BlueButton1ink3(WebDriver driver){

element = driver.findElement(By.cssSelector("ul > li > ul > li > a"));
element.click();

return element;
}
public static WebElement Test_BlueButton1ink4(WebDriver driver){

element = driver.findElement(By.xpath("(//a[contains(text(),'BlueButton')])[4]"));
element.click();

return element;
}
public static WebElement Test_TrustBundleLink(WebDriver driver){

element = driver.findElement(By.linkText("Trust Bundle"));
element.click();

return element;
}
public static WebElement Test_DirectSitenvOrgLink(WebDriver driver){

element = driver.findElement(By.linkText("direct.sitenv.org"));
element.click();

return element;
}

public static WebElement Test_DirectSitenvOrgCertificateLink(WebDriver driver){

element = driver.findElement(By.linkText("direct.sitenv.org Certificate"));
element.click();
Alert alert=driver.switchTo().alert();
//String alertText = alert.getText();
//System.out.println(alertText);
alert.accept();
return element;
}
public static WebElement AnchorUpload(WebDriver driver){

element = driver.findElement(By.id("anchoruploadfile"));

return element;
}
public static void AnchorUploadFile(WebDriver driver){

DirectTransport_page.AnchorUpload(driver).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\root-ca.crt");

}

public static WebElement AnchorUpload_SubmitBtn(WebDriver driver){

element = driver.findElement(By.id("anchoruploadsubmit"));
element.click();

return element;
}

public static WebElement PickSampleBtn(WebDriver driver){

element = driver.findElement(By.id("dLabel"));
element.click();

return element;
}


public static WebElement PrecannedSample(WebDriver driver){

element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div[1]/div/div[1]/div/form/div/div/div/div[1]/ul/li/div/ul/li/ul/li[1]/ul/li[1]/ul/li[1]/a"));
element.click();

return element;
}

public static WebElement PrecannedSubmitBtn(WebDriver driver){

element = driver.findElement(By.id("precannedCCDAsubmit"));
element.click();

return element;
}
public static WebElement ErrorOnBlankEndpoint(WebDriver driver){

element = driver.findElement(By.className("formErrorContent"));

return element;
}

public static void VerifyErrorOnBlankEndpoint(WebDriver driver){

DirectTransport_page.ErrorOnBlankEndpoint(driver).getText().contains("end point is required!");


}

public static WebElement PrecannedEmail(WebDriver driver){

element = driver.findElement(By.id("precannedemail"));

return element;
}
public static void EnterPrecannedEmail(WebDriver driver){

DirectTransport_page.PrecannedEmail(driver).sendKeys("Provider1@direct.sitenv.org");

}
public static WebElement MainContent(WebDriver driver){

element = driver.findElement(By.xpath("//div[@id='main-content']/div[2]"));
element.click();

return element;
}
public static WebElement ChooseYourOwnContent(WebDriver driver){

element = driver.findElement(By.linkText("Choose Your Own Content"));
element.click();
return element;
}
public static WebElement CcdaUploadFile(WebDriver driver){

element = driver.findElement(By.id("ccdauploadfile"));

return element;
}
public static void CcdaUploadFile_Sample(WebDriver driver){

DirectTransport_page.CcdaUploadFile(driver).sendKeys("C:\\Users\\amore\\Desktop\\Selenium\\170.314(b)(1)InPt_Discharge Summary CED Type.xml");


}

public static WebElement SubmitCcdaUpload(WebDriver driver){

element = driver.findElement(By.id("ccdauploadsubmit"));
element.click();

return element;
}
public static WebElement ChoosePrecannedContent(WebDriver driver){

element = driver.findElement(By.linkText("Choose Precanned Content"));
element.click();

return element;
}

public static void EnterDirectReceiveEmailAddress(WebDriver driver){

	DirectTransport_page.PrecannedEmail(driver).clear();
	DirectTransport_page.PrecannedEmail(driver).sendKeys("provider2@direct2.sitenv.org");
}

public static WebElement PickSample(WebDriver driver){

element = driver.findElement(By.id("dLabel"));
element.click();

return element;
}
public static WebElement PickSample_SelectSample(WebDriver driver){

element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/div[3]/div[2]/div[1]/div/div[1]/div/form/div/div/div/div[1]/ul/li/div/ul/li/ul/li[1]/ul/li[1]/ul/li[1]/a"));
element.click();

return element;
}



public static void Pick_Precanned_Sample_CCDA_File_to_Send_and_Submit(WebDriver driver){

	DirectTransport_page.PickSample(driver);
	DirectTransport_page.PickSample_SelectSample(driver);
	DirectTransport_page.PrecannedSubmitBtn(driver);
}

public static void Test_Reference_Links(WebDriver driver){
	driver.findElement(By.id("directsandbox_releaseNote_popup")).click();
	   
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
    
	driver.findElement(By.xpath("(//a[contains(text(),'Direct Project Wiki')])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Direct Certificate Discovery Tool')])[2]")).click();


}



}
