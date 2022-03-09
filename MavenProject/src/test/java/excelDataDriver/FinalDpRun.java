package excelDataDriver;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class FinalDpRun {
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String>data) 
  {
	  
  }

  @DataProvider
  public Object[][] getData() throws IOException 
  {
	  ExcelApi e = new ExcelApi("C:\\Users\\sathi\\Desktop\\Excellss\\suitex.xlsx");
	  String sheetName = "data";
	  String testCaseName = "TestA";
    return DataUtils.getTestData(e, sheetName, testCaseName);
  }
}
