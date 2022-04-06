package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Registration {
  
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pranit Gupta\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jockey.in/");
	}
	
	@Test
	public void registrationTest()
	{
		WebElement login = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[2]/div/div[2]/a[2]/small"));
		login.click();
		WebElement create = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/div[1]/div/a[2]"));
		create.click();
		WebElement name = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[1]/input"));
		name.sendKeys("Pranit Gupta");
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[2]/input"));
		email.sendKeys("guptapranit9@gmail.com");
		WebElement number = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[3]/input"));
		number.sendKeys("8368072466");
		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[4]/input[2]"));
		password.sendKeys("Jockey1234");
		WebElement confirm = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[5]/input[2]"));
		confirm.sendKeys("Jockey1234");
		WebElement male = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[6]/div[1]/div/label/span"));
		male.click();
		WebElement signup = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/div[2]/a"));
		signup.click();
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
}
