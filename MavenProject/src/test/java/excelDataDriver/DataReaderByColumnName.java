package excelDataDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderByColumnName 
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\sathi\\Desktop\\Excellss\\Textdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell;
		
		int cellindex = 0;
		
		for(int i = 0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Password"))
			{
				cellindex=i;
			}
		}
		
		row = sheet.getRow(2);
		cell = row.getCell(cellindex);
		double str = cell.getNumericCellValue();
		
		System.out.println(str);
		
		wb.close();
		fis.close();
		
	}

}
