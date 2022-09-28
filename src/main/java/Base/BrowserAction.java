package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserAction {

	public static WebDriver driver;
	

	public void intializeBrowserIMDB() 
		{		
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.get("https://www.imdb.com/");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		public void intializeBrowserWikipedia() 
			{
				System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
				driver = new ChromeDriver(); 
				driver.get("https://en.wikipedia.org/wiki/Main_Page");
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}


	
	

}



