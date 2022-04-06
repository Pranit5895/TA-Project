package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pranit Gupta\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jockey.in/");
	}
	
	@Test
	public void loginTest()
	{
		WebElement login = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[2]/div/div[2]/a[2]/small"));
		login.click();
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-login/div/div/form/div/div[1]/div[1]/input"));
		email.sendKeys("guptapranit9@gmail.com");
		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-login/div/div/form/div/div[1]/div[2]/input"));
		password.sendKeys("Jockey1234");
		WebElement confirm = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-login/div/div/form/div/div[3]/a"));
		confirm.click();
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
}
