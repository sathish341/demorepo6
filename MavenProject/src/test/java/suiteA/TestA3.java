package suiteA;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestA3
{
	
	@BeforeMethod
	  public void beforeMethod() 
	  {
		  System.out.println("before Method");
		  
	  }
	  
	  @Test
	  public void f1() 
	  {
		  System.out.println("TestA3");
		  
	  }
	  
	  

	  @AfterMethod
	  public void afterMethod()
	  {
		  System.out.println("after Method");
		  
	  }

}
