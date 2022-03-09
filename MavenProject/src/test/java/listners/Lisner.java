package listners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.selenium.MavenProject.BaseTest;

public class Lisner extends BaseTest implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result)
	{
		Reporter.log("Test has started:" + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		
		if (result.isSuccess())
		{
			try {
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcFile, new File(projectpath + "//success//" + filepath + ".png"));

				Reporter.log("<a href ='" + projectpath + "//success//" + filepath + ".png" + "'><img src ='"
						+ projectpath + "//success//" + filepath + ".png" + "'height='100' with = '100' '/></a>");
				Reporter.log("Test has success :" + result.getMethod().getMethodName());

			} catch (IOException e) {

				e.printStackTrace();
			} 
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{

		if (!result.isSuccess()) 
		{
			try {
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcFile, new File(projectpath + "//failure//" + filepath + ".png"));

				Reporter.log("<a href ='" + projectpath + "//failure//" + filepath + ".png" + "'><img src ='"
						+ projectpath + "//failure//" + filepath + ".png" + "'height='100' with = '100' '/></a>");
				Reporter.log("Test has failure :" + result.getMethod().getMethodName());

			} catch (IOException e) {

				e.printStackTrace();
			} 
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("Test has skipped:" + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
