import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class articleDetails {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pranit Gupta\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jockey.in/");
		
		WebElement search = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[2]/div/div[2]/div[2]/small"));
		search.click();
		WebElement product = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[5]/div/div/div[1]/input"));
		product.sendKeys("mask");
		WebElement enter = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[5]/div/div/div[1]/a/span"));
		enter.click();
		WebElement article = driver.findElement(By.partialLinkText("Performance Grey Kids Unisex Face Mask Pack of 2"));
		article.click();
		
//		System.out.println("Product: "+driver.findElement(By.partialLinkText("Kids Unisex Face Mask (Pack of 2) - Performance Grey")).getText());
//		System.out.println("Price: "+driver.findElement(By.xpath("/html/body/app-root/app-product-details/div[1]/div/div[1]/div[3]/div/div[1]/div/div[2]/div/div[3]/div[1]/h2")).getText());
//		
		
	    

	}

}
