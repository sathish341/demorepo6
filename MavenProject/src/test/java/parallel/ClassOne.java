package parallel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ClassOne 
{
	
 
	  
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("beforemethod ");
	  
  }
  
  @Test
  public void TestOne() 
  {
	  System.out.println("TestOne");
  }
	  
	  
  

  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("aftermethod");
  }

}
