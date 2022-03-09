package excelDataDriver;

import java.util.Hashtable;

public class DataUtils 
{
	public static Object[][] getTestData(ExcelApi e, String sheetName, String testCaseName )
	{
		 
		  //ExcelApi e = new ExcelApi("C:\\Users\\sathi\\Desktop\\Excellss\\suitex.xlsx");
		  //String sheetName = "data";
		  //String testCaseName = "TestB";

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
		  Object[][] data = new Object[rows][1];
		  Hashtable<String, String> table = null;

		  //getting data 
		  for(int rNum = dataStartRowNum; rNum<dataStartRowNum+rows; rNum++)
		  {
			  table = new Hashtable<String,String>();// object for hashtable
			  for(int cNum = 0; cNum<cols; cNum++)
			  {
				  //System.out.println(e.getCellData(sheetName, cNum, rNum));
				  //data[dataRow][cNum]=e.getCellData(sheetName, cNum, rNum);
				  //here not storing data directly into 2D Array
				  //storing into Hashtable in as key-value pairs
				  String key = e.getCellData(sheetName, cNum, colStartRowNum);
				  String value = e.getCellData(sheetName, cNum, rNum);
				  table.put(key, value);
			  }
			  data[dataRow][0] = table;
			  dataRow++;
		  }
		  return data;
		
		
	}

}
