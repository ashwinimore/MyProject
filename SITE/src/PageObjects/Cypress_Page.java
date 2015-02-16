package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cypress_Page {

	private static WebElement element = null;

	
	public static void Cypress_Link_Under_HomeNav(WebDriver driver){

		WebElement menu=driver.findElement(By.xpath("//html/body/div[1]/div/div/nav/ul/li[1]/a/span"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menu).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/nav/ul/li[1]/div/ul/li[5]/a")));
		WebElement menuOption = driver.findElement(By.xpath("/html/body/div[1]/div/div/nav/ul/li[1]/div/ul/li[5]/a"));
		menuOption.click();
	}

	public static WebElement Test_Cypress_KnowledgeBase_Link(WebDriver driver){

		element = driver.findElement(By.xpath("//div[@id='article_10154_10180_20418_1.0']/div/div/div/a/span"));
		element.click(); 
		return element;
		}
	public static WebElement Test_Cypress_Forum_Link(WebDriver driver){

		element = driver.findElement(By.xpath("//div[@id='article_10154_10180_20418_1.0']/div/div/div[2]/a/span/span[2]"));
		element.click(); 
		return element;
		}
	public static WebElement Test_Cypress_IssueTracker_Link(WebDriver driver){

		element = driver.findElement(By.xpath("//div[@id='article_10154_10180_20418_1.0']/div/div/div[3]/a/span/span[2]"));
		element.click(); 
		return element;
		}
	public static WebElement Test_Cypress_SampleRepo_Link(WebDriver driver){

		element = driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div[1]/a/span"));
		element.click(); 
		return element;
		}
	public static WebElement Test_Cypress_InstallCypress_Link(WebDriver driver){

		element = driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div[2]/a/span"));
		element.click(); 
		return element;
		}
	public static WebElement Test_Cypress_DemoCypress_Link(WebDriver driver){

		element = driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/a/span/span[2]"));
		element.click(); 
		return element;
		}


}


