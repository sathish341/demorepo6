package excelDataDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWriterByColumnNumber 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\sathi\\Desktop\\Excellss\\Textdata.xlsx");
		FileOutputStream fos = null;
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFFont font = wb.createFont();
		XSSFCellStyle style = wb.createCellStyle();
		
		//font.setFontName("Bodoni MT Black");
		//font.setFontHeight(20.0);
		//font.setBold(true);
		
		XSSFRow row = sheet.getRow(3);
		XSSFCell cell = row.getCell(3);
		
		//style.setFont(font);
		//cell.setCellStyle(style);
		cell.setCellValue("Passed");
		
		
		fos = new FileOutputStream("C:\\Users\\sathi\\Desktop\\Excellss\\Textdata.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		
		
		
		
		

	}

}
