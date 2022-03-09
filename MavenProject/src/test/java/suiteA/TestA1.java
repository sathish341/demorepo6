package suiteA;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestA1
{
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("before Method");
	  
  }
  
  @Test
  public void f() 
  {
	  System.out.println("TestA1");
	  
  }
  
  

  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("after Method");
	  
  }

}
