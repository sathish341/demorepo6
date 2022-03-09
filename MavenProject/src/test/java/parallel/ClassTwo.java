package parallel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ClassTwo 
{
	
  
  @BeforeMethod
  public void beforeMethod() 
  {
	System.out.println("before method");  
  }
  
  @Test
  public void TestTwo() 
  {
	  System.out.println("TestTwo");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("after method");
  }

}
