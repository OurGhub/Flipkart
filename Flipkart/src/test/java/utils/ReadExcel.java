package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testBase.TestBase;

public class ReadExcel extends TestBase
{
	public static XSSFWorkbook wbook;
	public static void main(String[] args) throws Throwable 
	{
		
		String fileLocation="./TestData/SelTest.xlsx";
		 wbook= new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(2);
			XSSFCell cell = row.getCell(0);
			String Value = cell.getStringCellValue();
			System.out.println(Value);
		
		wbook.close();
		
	}

}
