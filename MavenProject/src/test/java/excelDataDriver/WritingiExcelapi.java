package excelDataDriver;

import java.io.IOException;

public class WritingiExcelapi 
{

	public static void main(String[] args) throws Exception
	{
		ExcelApi e =new ExcelApi("C:\\Users\\sathi\\Desktop\\Excellss\\Textdata.xlsx");
		
		//e.setCellData("login", 3, 3, "sat");
		e.setCellData("login",  "Location", 2, "MBNR");
	

	}

}
