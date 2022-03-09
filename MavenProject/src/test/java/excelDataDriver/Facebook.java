package excelDataDriver;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook 
{

	public static void main(String[] args) throws IOException, Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathi\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		ExcelApi e =new ExcelApi("C:\\Users\\sathi\\Desktop\\Excellss\\Textdata.xlsx");
		
		
		//driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "Username",1));
		//driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", 1));
		
		for(int i=0;i<e.getRowCount("login");i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "Username",i));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", i));
			Thread.sleep(3000);
		}

	}

}
