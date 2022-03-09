package com.selenium.MavenProject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class RadioButton1 extends BaseTest
{
 
  @BeforeMethod(groups = {"regression", "smoke"})
  @Parameters("browser")
  public void beforeMethod(String bType) throws IOException
  {
	  init();
		test = report.startTest("TC__004");
		test.log(LogStatus.INFO,"Initializing properties files..");
		
		
		launch(bType);
		test.log(LogStatus.INFO,"opened the Browser:-"+p.getProperty("chromebrowser"));
	
		
		navigateurl("amazonurl");
		test.log(LogStatus.PASS,"Navigating to url:-" +childProperty.getProperty("amazonurl"));
		
	  
  }
  
  @Test(groups= {"regression","smoke"})
  public void RadioButton1Test() 
  {
	  driver.findElement(By.linkText("Today's Deals")).click();
	  test.log(LogStatus.INFO, "Clicking on Today's Deals");
	  
  }
  

  @AfterMethod(groups  = {"regression","smoke"})
  public void afterMethod() 
  {
	  driver.quit();
	  report.endTest(test);
	  report.flush();
	  
	  
  }

}
