package com.selenium.MavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TNG__003
{
  WebDriver driver; 
  
  @BeforeMethod
  public void beforeMethod()
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathi\\Downloads\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  
  @Test
  public void f()
  {
	  driver.get("https://www.amazon.in/");
	  
	  driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
	  
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
	  
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.close();
  }

}
