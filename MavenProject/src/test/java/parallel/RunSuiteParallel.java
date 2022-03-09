package parallel;

import java.util.Arrays;

import org.testng.TestNG;

public class RunSuiteParallel 
{

	public static void main(String[] args) 
	{
		TestNG t = new TestNG();
		t.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//megasuite.xml"}));
		t.setSuiteThreadPoolSize(2);
		t.run();
		

	}

}
