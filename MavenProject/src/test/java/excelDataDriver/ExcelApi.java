package excelDataDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelApi
{
	public FileInputStream fis1 = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook= null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xfilepath;
	
	public ExcelApi(String xfilepath) throws IOException
	{
		System.out.println("Excel has initilized....");
		this.xfilepath = xfilepath;
		fis1 = new FileInputStream(xfilepath);
		workbook = new XSSFWorkbook(fis1);
	}
	
	public int getRowCount(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()+1;
		return rowCount;
		
	}
	
	public int columnCount(String sheetName )
	{
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		return columnCount;
	}
	
	//Reading cell data from Excel by using Column number
	public String getCellData(String sheetName,int colNum, int rowNum)
	{
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			
			else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
					java.util.Date date = cell.getDateCellValue();
					cellValue=dt.format(date);	
				}
				return cellValue;
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} 
		
		catch (Exception e) 
		{
			
			e.printStackTrace();
			return "No matching value";
		}
		
	}
		
		
		
		//Reading cell data from Excel by using Column Name
		public String getCellData(String sheetName,String colName,int rowNum)
		{
			try
			{
				int colNum =-1;
				sheet=workbook.getSheet(sheetName);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++)
				{
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum=i;
				}
				
				row=sheet.getRow(rowNum);
				cell=row.getCell(colNum);
				
				if(cell.getCellTypeEnum()==CellType.STRING)
					return cell.getStringCellValue();
				else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
				{
					String cellValue = String.valueOf(cell.getNumericCellValue());
					if(HSSFDateUtil.isCellDateFormatted(cell))
					{
						DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
						java.util.Date date=cell.getDateCellValue();
						cellValue=dt.format(date);	
					}
					return cellValue;
				}
				else if(cell.getCellTypeEnum()==CellType.BLANK)
					return "";
				else
					return String.valueOf(cell.getBooleanCellValue());
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "No matching value";
			}
			
			
		}
		
		
		
		
		//Writing cell data to Excel by using column Number
		public boolean setCellData(String sheetName,int colNum, int rowNum, String value) throws IOException
		{
			try {
				sheet = workbook.getSheet(sheetName);
				row = sheet.getRow(rowNum);
				cell = row.getCell(colNum);
				
				cell.setCellValue(value);
				
				fos = new FileOutputStream(xfilepath);
				workbook.write(fos);
				fos.close();
			
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
				return false;
			}
			
			return true;
			
			
		}
		
		
		//Writing cell Data to Excel using column Name
		public boolean setCellData(String sheetName,String colName,int rowNum,String value) throws Exception
		{
			try {
				sheet = workbook.getSheet(sheetName);
				row = sheet.getRow(rowNum);
				
				int colNum=-1;
				
				for(int i=0;i<row.getLastCellNum();i++)
				{
					if(row.getCell(i).getStringCellValue().trim().equals(value))
						colNum = i; 
						
				}
				
				//row = sheet.getRow(rowNum);
				row = sheet.getRow(rowNum + 1);
				cell = row.getCell(colNum);
				
				cell.setCellValue(value);
				
				fos = new FileOutputStream(xfilepath);
				workbook.write(fos);
				fos.close();
			} 
			
			catch (Exception e)
			{
				
				e.printStackTrace();
				return false;
			}
			
			
			return true;
			
		}
		
	

}
