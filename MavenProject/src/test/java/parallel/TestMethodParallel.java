package parallel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestMethodParallel 
{
  
  @BeforeMethod
  public void beforeMethod()
  
  {
	  System.out.println("BeforeMethod");

	 
  }
  
  @Test
  public void TestMethod1()
  {
	  System.out.println("TestMethod1");
	  
  }
  
  
  @Test
  public void TestMethod2()
  {
	  System.out.println("TestMethod2");
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("AfterMethod");
  }

}
