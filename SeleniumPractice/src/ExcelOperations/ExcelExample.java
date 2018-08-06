package ExcelOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

public class ExcelExample {
	
	static Workbook wb=null;
	static Sheet ws=null;
	
	public ExcelExample(String Xlpath) throws Exception
	{
		//File xlfile = new File(Xlpath);
		FileInputStream inputStream = new FileInputStream(Xlpath); 
		wb= new XSSFWorkbook(inputStream);
		
	}
	
	public String getXldata(int SheetNo, int row, int col)
	{
		ws = wb.getSheetAt(SheetNo);
		String s=ws.getRow(row).getCell(col).getStringCellValue();
		return s;
	}
	
	public int getRowcount(int SheetNo)
	{
		int count = wb.getSheetAt(SheetNo).getLastRowNum();
		count = count+1;
		return count;
	}
	public int getColcount(int SheetNo)
	{
		int Ccount = wb.getSheetAt(SheetNo).getRow(0).getLastCellNum();
		//Ccount = Ccount+1;
		return Ccount;
	}
	
	
	/*public static void main(String[] args) throws IOException
	{
		System.out.println("Execution Started");
	//File xlF = new File("D:\\Selenium_Jun18\\Test data\\Registration.xlsx");
	//FileInputStream inputStream = new FileInputStream(xlF);
	//FileInputStream inputStream = new FileInputStream(".\\SeleniumPractice\\src\\ExcelOperations\\Registration.xlsx"); 
	FileInputStream inputStream = new FileInputStream("./src/ExcelOperations/Registration.xlsx"); 
	//"D:\\Selenium_Jun18\\Test data\\Registration.xlsx");
	wb= new XSSFWorkbook(inputStream);
	Sheet ws = wb.getSheet("Sheet1");
	System.out.println(wb.getNumberOfSheets());
	int rc = ws.getLastRowNum() - ws.getFirstRowNum();
	
	System.out.println(rc);
	for(int i=0;i<=rc;i++)
	{
		Row row = ws.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++)
		{
			System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			
		}
		System.out.println();
	}
	System.out.println("Execution stopped");
	}*/
}
