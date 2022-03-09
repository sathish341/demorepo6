package excelDataDriver;

import java.io.IOException;

public class DataManagement 
{

	public static void main(String[] args) throws IOException
	{
		ExcelApi e = new ExcelApi("C:\\Users\\sathi\\Desktop\\Excellss\\suitex.xlsx");
		String sheetName = "data";
		String testCaseName = "TestB";
		
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
		
		//getting data 
		for(int rNum = dataStartRowNum; rNum<dataStartRowNum+rows; rNum++)
		{
			for(int cNum = 0; cNum<cols; cNum++)
			{
				System.out.println(e.getCellData(sheetName, cNum, rNum));
			}
		}

		
	}

}
