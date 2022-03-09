package alertsHandle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AlertsHandling 
{
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod()
  {
	  System.setProperty("webdriver.chrome.browser", "C:\\Users\\sathi\\Downloads\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.get("http://demo.guru99.com/selenium/delete_customer.php");
  }
  
  
  @Test
  public void f() throws InterruptedException 
  {
	  driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("345778");
	  driver.findElement(By.xpath("//input[@name='submit']")).click();
	  
	  
	  Thread.sleep(3000);
	  Alert al = driver.switchTo().alert();
	  
	  System.out.println(al.getText());
	  String expval = "Do you really want to delete this Customer?";
	  Assert.assertEquals(al.getText(), expval);
	  al.accept();
		
		
	
  }

  @AfterMethod
  public void afterMethod() throws Exception 
  {
	  Thread.sleep(3000);
	  //driver.quit();
  }

}
