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

public class ExcelReaderRegistration {

	public static void main(String[] args) throws IOException {
		String name = "";
		String number = "";
		String email = "";
		String password = "";
		String confirm = "";	
		
		try {
			FileInputStream fis = new FileInputStream("D:\\SEMESTER 6\\Test Automation\\Project\\JockeyReader.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Registration");
			
			int rowCount = sheet.getLastRowNum();
			
			for(int i=1; i<=rowCount; i++ ) {
				XSSFRow row = sheet.getRow(i);
				if(row.getCell(0).getCellType()==CellType.NUMERIC)
					name = row.getCell(0).getRawValue();
				else
					name = row.getCell(0).toString();
				if(row.getCell(1).getCellType()==CellType.NUMERIC)
					email = row.getCell(1).getRawValue();
				else
					email = row.getCell(1).toString();
				if(row.getCell(2).getCellType()==CellType.NUMERIC)
					number = row.getCell(2).getRawValue();
				else
					number = row.getCell(2).toString();
				password =  row.getCell(3).getRawValue();
				confirm =  row.getCell(4).getRawValue();
				registration(name, email, number, password,confirm);
			}
			fis.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void registration(String uname, String uemail, String unumber, String pwd, String upwd) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pranit Gupta\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jockey.in/");
		
		WebElement login = driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[2]/div/div[2]/a[2]/small"));
		login.click();
		WebElement create = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/div[1]/div/a[2]"));
		create.click();
		WebElement name = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[1]/input"));
		name.sendKeys(uname);
		WebElement email = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[2]/input"));
		email.sendKeys(uemail);
		WebElement number = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[3]/input"));
		number.sendKeys(unumber);
		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[4]/input[2]"));
		password.sendKeys(pwd);
		WebElement confirm = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[5]/input[2]"));
		confirm.sendKeys(upwd);
		WebElement male = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/form/div/div[6]/div[1]/div/label/span"));
		male.click();
		WebElement signup = driver.findElement(By.xpath("/html/body/app-root/app-header/app-login-popup/div/div/div/div/div/div/app-register/div/div/div/div[2]/a"));
		signup.click();
	}

	}
