package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class searchArticle {
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
  public void searchTest()
  {
	  WebElement search = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[2]/div/div[2]/div[2]/small"));
		search.click();
		WebElement product = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[5]/div/div/div[1]/input"));
		product.sendKeys("T-shirt");
		WebElement enter = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[5]/div/div/div[1]/a/span"));
		enter.click();
  }
  
  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }
}
