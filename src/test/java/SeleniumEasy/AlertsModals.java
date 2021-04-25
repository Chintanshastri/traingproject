package SeleniumEasy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsModals {
	WebDriver driver;
	@BeforeTest
	public void Start() {
		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32(1)\\chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://demo.automationtesting.in/Alerts.html");

		
	}
  @Test
  
	  public void BootstrapModal() {
	  System.out.print("button click\n");
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     //Alert with OK 
		  //driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
	     
	     //Alert with OK & Cancel 
	    /* driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click(); 
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		 */
	     //Alert with Textbox 
	     driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click(); 
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
	     
	     
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  Alert alert = driver.switchTo().alert();
		  System.out.print(alert.getText());
		  String text = alert.getText();
		 // if(text.equals("I am an alert box!"))
		  //if(text.equals("Press a Button !"))
		  
		  if(text.equals("Please enter your name"))
		  {
			  System.out.print( "done\n"); 
			  alert.dismiss();
		  }
		  else 
		  {
			  System.out.print("not done\n");
			  alert.accept();
		  }
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //alert.accept();
		  //alert.dismiss();
		  
		  
		  
	  }
  /*@Test
  public void fileupload() {
	  driver.get("https://html.com/input-type-file/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id=\"fileupload\"]")).sendKeys("C:\\Users\\user4\\Desktop\\sample-avi-file.avi");
  }*/
  
  }

