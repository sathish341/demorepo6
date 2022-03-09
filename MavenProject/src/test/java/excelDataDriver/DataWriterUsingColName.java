package excelDataDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWriterUsingColName 
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\sathi\\Desktop\\Excellss\\Textdata.xlsx");
		FileOutputStream fos = null;
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row = sheet.getRow(0);
		
		int columnIndex = -1;
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Location"))
				columnIndex = i;
		}	
		
		
		XSSFCell cell = row.getCell(columnIndex);
		cell.setCellValue("hhh");
		
		fos = new FileOutputStream("C:\\Users\\sathi\\Desktop\\Excellss\\Textdata.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();

	}

}
