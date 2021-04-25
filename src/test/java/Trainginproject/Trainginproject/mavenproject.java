package Trainginproject.Trainginproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mavenproject {
  
 
	//public String baseUrl = "http://demo.guru99.com/test/newtours/";
			//public String baseUrl = "https://www.amazon.in/";
		   // String driverPath = "C:\\selenium\\chromedriver_win32 (4)\\chromedriver.exe";
		    public WebDriver driver ; 
			@BeforeTest
		    public void launchBrowser() {
		        System.out.println("launching chrome browser"); 
		     //   System.setProperty("webdriver.chrome.driver", driverPath);
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		        driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        driver.get("https://www.amazon.in/");
		    }
		    @Test (priority = 0)
		    public void verifyHomepageTitle() {
		    /*    String expectedTitle = "Welcome: Mercury Tours";
		        String actualTitle = driver.getTitle();
		        Assert.assertEquals(actualTitle, expectedTitle);
		   */
		    	driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("mobile");
		        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

		    }
		    @Test (priority = 1)
		    public void  search() {
		    	
		    	
		    	driver.findElement(By.xpath("//*[@id=\"p_89/Samsung\"]/span/a/div/label/i")).click();
		    	
		    	
		    }
		    @Test (priority = 2)
		    public void search1()
		    {
	            System.out.print("this is scrolling function");
		    	
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("window.scrollBy(0,500)");
		    driver.findElement(By.id("low-price")).sendKeys("100");
		    	driver.findElement(By.id("high-price")).sendKeys("5000");
		    	driver.findElement(By.id("a-autoid-1-announce")).submit();
		    	driver.findElement(By.xpath("//*[@id=\"p_n_feature_eight_browse-bin/8561113031\"]/span/a/div/label/i")).click();
		    	driver.findElement(By.xpath("//*[@id=\"p_n_feature_seven_browse-bin/8561133031\"]/span/a/div/label/i")).click();
		    	
		    }
		    
		    @AfterTest
		    public void terminateBrowser(){
		        driver.close();
		    }
  
  
  
}
