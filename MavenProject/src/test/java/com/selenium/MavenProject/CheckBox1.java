package com.selenium.MavenProject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class CheckBox1 extends BaseTest
{
  
  @BeforeMethod(groups = {"regression","smoke"})
  @Parameters("browser")
  public void beforeMethod(String bType) throws IOException 
  {
	  init();
		test = report.startTest("CheckBox1");
		test.log(LogStatus.INFO,"Initializing properties files..");
		
		
		launch(bType);
		test.log(LogStatus.INFO,"opened the Browser:-"+p.getProperty("chromebrowser"));
	
		
		navigateurl("amazonurl");
		test.log(LogStatus.PASS,"Navigating to url:-" +childProperty.getProperty("amazonurl"));
		
	  
  }
  
  
  @Test(groups = {"regression","smoke"})
  public void CheckBoxTest() 
  {
	  driver.findElement(By.linkText("Best Sellers")).click();
	  test.log(LogStatus.INFO, "Clicking on Best Sellers");
  }

  @AfterMethod(groups= {"regression","smoke"})
  public void afterMethod() 
  {
	  driver.quit();
	  report.endTest(test);
	  report.flush();
	  
  }

}
