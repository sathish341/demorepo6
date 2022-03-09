package windowHaandles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathi\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.sc.com/in/bank-with-us/online-banking-login/");
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window :" + parentWindow);
		
		driver.findElement(By.xpath("//a[@title='Apply Now'] [@target='_blank']")).click();
		
		Set<String> multiWindow = driver.getWindowHandles();
		Iterator<String> itr = multiWindow.iterator();
		while(itr.hasNext())
		{
			String currentWindow = itr.next();
			System.out.println("Windows id's :" + currentWindow );
			
			if(!currentWindow.equals(parentWindow)) 
			{
				System.out.println("child Window handle id :" +currentWindow);
				driver.switchTo().window(currentWindow);
			}
		}
		
		String childTitle = driver.getTitle();
		System.out.println("Child Window Title :"+childTitle);
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("Parent window Title :"+ driver.getTitle());
		
		driver.quit();

	}

}
