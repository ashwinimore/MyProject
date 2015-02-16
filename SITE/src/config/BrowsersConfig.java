package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowsersConfig {

	private static WebElement element = null;
	
	public static WebElement IEWebDriver(WebDriver driver){

		 System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriverServer\\IEDriverServer.exe");
		   driver = new InternetExplorerDriver();
		return element;
		}	
}