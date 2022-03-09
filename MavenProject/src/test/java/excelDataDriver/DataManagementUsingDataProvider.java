package excelDataDriver;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataManagementUsingDataProvider 
{
  @Test(dataProvider = "getData")
  public void f(String RunMode, String Browser, String UserName, String UserPassword, String ExpectedResult )
  {
	  //here we have disadvantage that we have to change parameters 
	  // according to the Test case columns
	  // To overcome this we use Hashtables
	  
  }

  @DataProvider
  public Object[][] getData() throws IOException
  {
    
	  ExcelApi e = new ExcelApi("C:\\Users\\sathi\\Desktop\\Excellss\\suitex.xlsx");
		String sheetName = "data";
		String testCaseName = "TestA";
		
		//1st finding the TestCase match
		int testStartRow = 0;
		while(!e.getCellData(sheetName, 0, testStartRow).equals(testCaseName))
		{
			testStartRow++;
		}
		System.out.println("Test row starts from :-"+ testStartRow );
		
		int colStartRowNum = testStartRow+1;
		int dataStartRowNum = testStartRow+2;
		
		//calculating total rows of data for matching testcase
		int rows = 0;
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total Rows are :-" + rows);
		
		//calculating total columns 
		int cols = 0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total columns :-" + cols );
		
		
		
		int dataRow = 0;
		Object[][] data = new Object[rows][cols];
		//getting data 
		for(int rNum = dataStartRowNum; rNum<dataStartRowNum+rows; rNum++)
		{
			for(int cNum = 0; cNum<cols; cNum++)
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
			    data[dataRow][cNum]=e.getCellData(sheetName, cNum, rNum);
			}
			dataRow++;
		}
		return data;
		
  }
}
