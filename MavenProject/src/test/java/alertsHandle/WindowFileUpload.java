package alertsHandle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WindowFileUpload 
{
	WebDriver driver;
	
	
  
	  
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.drivre", "C:\\Users\\sathi\\Downloads\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://transfer.pcloud.com/");
	  driver.manage().window().maximize();
	  
  }
  
  @Test
  public void fileUpload() throws InterruptedException, Exception 
  {
	  driver.findElement(By.xpath("//span[contains(text(),'Click here to add files')]")).click();
	  Thread.sleep(3000);
	  Runtime.getRuntime().exec("C:\\Users\\sathi\\Desktop\\fileupload.exe");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
	  
  }

}
