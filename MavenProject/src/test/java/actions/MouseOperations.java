package actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class MouseOperations 
{
	WebDriver driver;
	Actions a;
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathi\\Downloads\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  

	  
  }
  
  @Test(priority=0,enabled = false)
  public void moveToelement() throws Exception
  {
	  driver.get("https://www.snapdeal.com");
	  a = new Actions(driver);
	  
	  a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"))).perform();
	  driver.findElement(By.xpath("//body/div[@id='sdHeader']/div[4]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
	  Thread.sleep(3000);
  }
  
  
  @Test(priority=1,enabled = false)
  public void dragAnddrop() throws Exception
  {
	  driver.get("https://jqueryui.com/droppable/");
	  driver.switchTo().frame(0);
	  
	  WebElement drag = driver.findElement(By.id("draggable"));
	  WebElement drop = driver.findElement(By.id("droppable"));
	  
	  a = new Actions(driver);
	  //a.dragAndDrop(drag, drop).perform();
	  a.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
	  
	  Thread.sleep(3000);
	  
  }
  
  @Test(priority=2,enabled = false)
  public void resizeMethod() throws InterruptedException
  {
	  driver.get("https://jqueryui.com/resizable/");
	  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	  
	  a = new Actions(driver);
	  WebElement drag = driver.findElement(By.xpath("//body/div[@id='resizable']/div[1]"));
	  a.moveToElement(drag, 200, 300).perform();
	  
	  //a.clickAndHold(drag).moveByOffset(100, 300).release(drag).build().perform();
	  
	  Thread.sleep(3000);
  }
  
  
  
  @Test(priority=3,enabled = false)
  public void rightClick() throws Exception
  {
	  driver.get("https://jqueryui.com/");
	  
	  WebElement drag = driver.findElement(By.xpath("//a[contains(text(),'Sortable')]"));
	  a = new Actions(driver);
	  
	  a.contextClick(drag).perform();
	  Thread.sleep(3000);
	  
  }
  
  @Test(priority=4,enabled = false)
  public void slider() throws Exception
  {
	  driver.get("https://jqueryui.com/slider/");
	  driver.switchTo().frame(0);
	  WebElement drag = driver.findElement(By.id("slider"));
	  
	  a = new Actions(driver);
	  a.dragAndDropBy(drag, 200, 0).perform();
	  
	  Thread.sleep(3000);
  }
  
  
  @Test(priority=5,enabled = false)
  public void browserSlider() throws InterruptedException
  {
	  driver.get("https://www.selenium.dev/downloads/");
	  
	  for(int i=0; i<10;i++)
	  {
		  ((RemoteWebDriver)driver).executeScript("window.scrollBy(0,200)");
		  Thread.sleep(3000);
	  }
  }
  
  
  @Test(priority=5)
  public void autoSuggestions() throws InterruptedException 
  {
	  driver.get("https://www.google.com/");
	  driver.findElement(By.name("q")).sendKeys("hadoop tutorial");
	  
	  String val = driver.findElement(By.name("q")).getAttribute("value");
	  Thread.sleep(3000);
	  
	  List<WebElement> list = driver.findElements(By.xpath("//ui[@class='erkvQe']/li/div/div[2]/div/span"));
	  
	  for(int i=0;i<list.size();i++)
	  {
		  if(list.get(i).getText().equals(val))
		  {
			  list.get(i).click();
			  return;
		  }
		  list = driver.findElements(By.xpath("//ui[@class='erkvQe']/li/div/div[2]/div/span"));
		  
	  }
	  
  }
  
  

  @AfterMethod
  public void afterMethod()
  {
	  //driver.close();
	  
  }

}
