package excelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReaderLogin {

	public static void main(String[] args) throws IOException {
		String username = "";
		String password = "";
		
		try {
			FileInputStream fis = new FileInputStream("D:\\SEMESTER 6\\Test Automation\\Project\\JockeyReader.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Login");
			
			int rowCount = sheet.getLastRowNum();
			
			for(int i=1; i<=rowCount; i++ ) {
				XSSFRow row = sheet.getRow(i);
				if(row.getCell(0).getCellType()==CellType.NUMERIC)
					username = row.getCell(0).getRawValue();
				else
					username = row.getCell(0).toString();
				if(row.getCell(1).getCellType()==CellType.NUMERIC)
					password = row.getCell(1).getRawValue();
				else
					password = row.getCell(1).toString();
				login(username, password);
			}
			fis.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void login(String uname, String pwd) {
		System.out.println("Running TC with username "+uname+" password "+pwd);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pranit Gupta\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jockey.in/");
		
		WebElement login = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[2]/div/div[2]/a[2]/small"));
		login.click();
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-login/div/div/form/div/div[1]/div[1]/input"));
		email.sendKeys(uname);
		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-login/div/div/form/div/div[1]/div[2]/input"));
		password.sendKeys(pwd);
		WebElement confirm = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-login/div/div/form/div/div[3]/a"));
		confirm.click();

	}

}
