package testngdataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginmethod {
	WebDriver driver;
	@BeforeTest
	public void Start() {
		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32(1)\\chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@DataProvider
	public void getLoginData()
	{
		
		
	}
	@Test
	public void login(String username, String password) {
		driver.findElement(By.xpath("/html/body/div[2]/header/div/nav/div[2]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[4]")).click();
	}
}
