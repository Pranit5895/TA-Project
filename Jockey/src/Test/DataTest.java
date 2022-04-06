package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest {
	@Test(dataProvider = "loginTest")
	  public void dataDisplay(String username, String password, String browser, String version) {
		  System.out.println("Username     "+ username);
		  System.out.println("Password     "+ password);
		  System.out.println("Browser      "+ browser);
		  System.out.println("Version      "+ version);
	  }

	  @DataProvider(name="loginTest")
	  public Object[][] loginData() {
	    Object[][] data = new Object[3][4];
	    
	    data[0][0]="pranitgupta@gmail.com";
	    data[0][1]="123";
	    data[0][2]="Chrome";
	    data[0][3]="12.1.0";
	    
	    data[1][0]="pranit7103@gmail.com";
	    data[1][1]="toor";
	    data[1][2]="Firefox";
	    data[1][3]="3.4.2";
	    
	    data[2][0]="8368072466";
	    data[2][1]="836";
	    data[2][2]="IE";
	    data[2][3]="20.1.0";
	    
	    return data;
	  }
}

