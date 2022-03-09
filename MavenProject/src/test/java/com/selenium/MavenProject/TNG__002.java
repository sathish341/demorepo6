package com.selenium.MavenProject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class TNG__002 extends BaseTest
{
  
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void beforeMethod(String bType) throws IOException
  {
	  init();
		test = report.startTest("TNG__002");
		test.log(LogStatus.INFO,"Initializing properties files..");
		
		
		launch(bType);
		test.log(LogStatus.INFO,"opened the Browser:-"+p.getProperty("chromebrowser"));
	
		
		navigateurl("amazonurl");
		test.log(LogStatus.PASS,"Navigating to url:-" +childProperty.getProperty("amazonurl"));
		
	  
  }
  
  @Test(groups = {"regression","sanity"})
  public void TNG__002Test()
  {

		selectOption("amazondropdown_id","Books");
		test.log(LogStatus.PASS,"Selected the option Books By using locator:-" + or.getProperty("amazondropdown_id"));
		
		
		typeText("amazonsearchtext_xpath", "Harry potter");
		test.log(LogStatus.PASS, "Entered the text Harry Potter By using the locator:-" + or.getProperty("amazonsearchtext_xpath"));
		
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on Element By using locator:-" + or.getProperty("amazonsearchbutton_xpath"));
		
  }

  @AfterMethod(groups = {"regression","sanity"})
  public void afterMethod()
  {
	  driver.quit();
	  report.endTest(test);
	  report.flush();
	  
  }

}
