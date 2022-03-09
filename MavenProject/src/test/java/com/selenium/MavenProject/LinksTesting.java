package com.selenium.MavenProject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class LinksTesting extends BaseTest
{
 
  @BeforeMethod(groups = {"regression"})
  @Parameters("browser")
  public void beforeMethod(String bType) throws IOException
  {
	  init();
		test = report.startTest("LinksTesting");
		test.log(LogStatus.INFO,"Initializing properties files..");
		
		
		launch(bType);
		test.log(LogStatus.INFO,"opened the Browser:-"+p.getProperty("chromebrowser"));
	
		
		navigateurl("amazonurl");
		test.log(LogStatus.PASS,"Navigating to url:-" +childProperty.getProperty("amazonurl"));
		
	  
  }
  
  
  @Test(groups = {"regression"})
  public void LinksTestingTest()
  {
	  driver.findElement(By.linkText("Mobiles")).click();
	  test.log(LogStatus.INFO, "Clicking on Mobiles");
  }

  @AfterMethod(groups = {"regression"})
  public void afterMethod() 
  {
	  driver.quit();
	  report.endTest(test);
	  report.flush();
	  
  }
  

}
