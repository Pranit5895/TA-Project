package Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Logger
{
	static WebDriver driver;
	static String driverPath;
	static String baseURL;
	
	@Test
	public static void logSample()
	{
		driverPath = "C:\\\\Users\\\\Pranit Gupta\\\\Downloads\\\\chromedriver_win32 (1)\\\\chromedriver.exe";
		baseURL = "https://www.jockey.in/";
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		Reporter.log("Browser Is Now Opened");
		
		driver.manage().window().maximize();
		Reporter.log("Browser Is Now Maximized");
		
		driver.get(baseURL);
		Reporter.log("Jockey.in Is Now Opened");
		
		driver.close();
		Reporter.log("Browser Is Now Closed");
	}
}
