 package com.selenium.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectpath = System.getProperty("user.dir");
	public static Properties p;
	public static FileInputStream fis;
	public static Properties mainProperty ;
	public static Properties childProperty;
	public static Properties or;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String filepath;
	
	
	static
	{
		Date dt = new Date();
		filepath = dt.toString().replace(":", "_").replace(" ", "_");
	}
	
	public static void init() throws IOException
	{
		fis = new FileInputStream(projectpath +"//data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectpath + "//environment.properties");
		mainProperty = new Properties();
		mainProperty.load(fis);
		String e =mainProperty.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath + "//"+e+".properties");
		childProperty = new Properties();
		childProperty.load(fis);
		
		fis = new FileInputStream(projectpath + "//or.properties");
		or = new Properties();
		or.load(fis);
		
		fis = new FileInputStream(projectpath + "//log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		
		report=ExtentManager.getInstance();
		
		
	}
	
	
		
	

	public static void launch(String browser)
	{
		if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectpath+"//driver//chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\sathi\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 7");
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
		}
		
		
		else if(browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", projectpath+"//driver//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectpath+"//driver//geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		
		
		
	}
	
	public static void navigateurl(String url)
	{
		driver.get(childProperty.getProperty(url));
        //driver.navigate().to(childProperty.getProperty(url));	
	}
	
	
	
	public static void clickElement(String locatorkey) 
	{
		getElement(locatorkey).click();;
		//driver.findElement(By.xpath(or.getProperty(locatorkey))).click();
		
	}


	public static void typeText(String locatorkey, String text) 
	{
		getElement(locatorkey).sendKeys(text);
		//driver.findElement(By.xpath(or.getProperty(locatorkey))).sendKeys(text);
		
	}
	public static void selectOption(String locatorkey, String option)
	{
		getElement(locatorkey).sendKeys(option);
		//driver.findElement(By.id(or.getProperty(locatorkey))).sendKeys(option);
		
	}





	public static WebElement getElement(String locatorkey) 
	{
		WebElement element = null;
		
		if(locatorkey.endsWith("_id"))
		{
			element = driver.findElement(By.id(or.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_name"))
		{
			element = driver.findElement(By.name(or.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_class"))
		{
			element = driver.findElement(By.className(or.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_xpath"))
		{
			element = driver.findElement(By.xpath(or.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_css"))
		{
			element = driver.findElement(By.cssSelector(or.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_linktext"))
		{
			element = driver.findElement(By.linkText(or.getProperty(locatorkey)));
		}
		else if(locatorkey.endsWith("_partiallink"))
		{
			element = driver.findElement(By.partialLinkText(or.getProperty(locatorkey)));
		}
		
		
		return element;
		
	}
	
	
	//***************verifications*****************//

	public static boolean verifyLink(String expecteLink) 
	{
		String actualLink = driver.findElement(By.linkText("New Releases")).getAttribute("innerHTML");
		 
		if(actualLink.equals(expecteLink))
			return true;
		else
			return false;
	}
	
	
	//***************Reportings***************//
	

	public static void reportSuccess(String successmsg) 
	{
		test.log(LogStatus.PASS, successmsg);
		
	}

	public static void reportFailure(String failuremsg) throws IOException 
	{
		test.log(LogStatus.FAIL, failuremsg);
		takeScreenshot();
	}

//*********************takeScreenshot*************************
	
	public static void takeScreenshot() throws IOException 
	{
		Date dt = new Date();
		String dateFormate = dt.toString().replace(":", "_").replace(" ", "_");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File(projectpath+"\\failurescreenshots\\"+dateFormate+".png"));
	    
		test.log(LogStatus.INFO, "sceenshot->"+ test.addScreenCapture(projectpath+"\\failurescreenshots\\"+dateFormate+".png"));
	
	}
	
		



	

	

	

	

}
