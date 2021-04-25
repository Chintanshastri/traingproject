package util;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	 static WebDriver driver=null; 
		@BeforeTest
	    public void launchBrowser() {
	        System.out.println("launching chrome browser"); 
	     //   System.setProperty("webdriver.chrome.driver", driverPath);
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);}
		
	
	@Test(dataProvider = "Test1Data")
	public static void test1(String username, String password) throws InterruptedException 
	{
		System.out.println(username + " | " + password);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	Thread.sleep(2000);
		//	driver.findElement(By.xpath("//*[@id=\"u_0_d_RO\"]")).click();
	}

	@DataProvider(name = "Test1Data")
	public Object[][] getdata() {
		String excelPath = "C:\\Users\\user4\\eclipse-workspace\\Trainginproject\\excel\\loginfile.xlsx";
		Object data[][] = TestData(excelPath, "login");
		return data; 

	}

	public Object[][] TestData(String excelPath, String sheetName) {

		Utildatafile excel = new Utildatafile(excelPath, sheetName);
		int rowcount = excel.getRowCount();
		int colcount = excel.getcolCount();

		Object data[][] = new Object[rowcount - 1][colcount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData + " | ");
				data[i - 1][j] = cellData;
			}
			System.out.println();
		}
		return data;
	}

}
