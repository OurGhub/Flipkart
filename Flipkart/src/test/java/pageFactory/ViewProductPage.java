package pageFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import testBase.TestBase;
import utils.ReadExcel;

public class ViewProductPage extends TestBase
{

	public static    String Disc ="";
	public static String pname="";
	public static  String Price;
	
	@FindBy(xpath="//span[contains(text(),'SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)')]")public WebElement ProductName;
	@FindBy(xpath="//div[@id='container']/div/div[3]/div/div[2]/div[2]//span")public WebElement prodName;
	@FindBy(xpath="//div[@id='container']/div/div[3]/div/div[2]/div[2]//div/div[3]/div[1]/div[1]/div")public WebElement ProductPrice;
	@FindBy(xpath="//*[@id='container']/div/child::div[3]/child::div/child::div[2]/child::div[3]/div/child::div[4]/div[1]/div//div[3]/span")public WebElement Discount;
	
	@FindBy(xpath="//div[@id='container']/div/div[3]/div/div[2]/div[2]//div[5]/div[1]/div/div[1]")public WebElement pprice;
	@FindBy(xpath="//div[@id='container']/div/div[3]/div/div[2]/div[2]//div[5]/div[1]/div/div[3]/span")public WebElement pdiscount;
	
	@FindBy(xpath="//div[@id='container']/div/div[3]/div/div[2]/div[2]//div[4]/div[1]/div/div[1]")public WebElement proprice;
	
	@FindBy(xpath="//button[text()='Buy Now']/../../../li[1]/button")public WebElement AddtoCart;
	
	public void verifyTitle()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String sessionid:windowHandles)
		{
			driver.switchTo().window(sessionid);
		}
		
		
	    String pname=prodName.getText();
	    System.out.print("//////"+pname);
	    
	    try
	    {
	     Price=proprice.getText();
	     System.out.print("//////"+Price);
	    }catch(Exception e)
	    {
	    	 Price = ProductPrice.getText();
	         System.out.print("//////"+Price);
	    }
	 
	    
	    try
	    {
	    	 Disc = pdiscount.getText();
	    	 System.out.print("//////"+Disc);
	
	    }catch(Exception e)
	    {
	    	Reporter.log("No discount available");
	    	Disc="No discount available";
	    	System.out.println(Disc);
	    }
	  
	//    st.assertAll();
	    
	}
	
	
	public void AddToCart()
	{
		try
		{
		AddtoCart.click();
		}
		catch(Exception e)
		{
			System.out.println("Not found");
		}
	}
	
	public void writeToExcel() throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./ExcelFile/prodBooks.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet1 = wb.getSheet("product");
		sheet1.createRow(sheet1.getPhysicalNumberOfRows()).createCell(0).setCellValue(pname);
		sheet1.createRow(sheet1.getPhysicalNumberOfRows()).createCell(1).setCellValue(Price);
		sheet1.createRow(sheet1.getPhysicalNumberOfRows()).createCell(2).setCellValue(Disc);
		FileOutputStream fos = new FileOutputStream("./ExcelFile/prodBooks.xlsx");
		wb.write(fos);
		 wb.close();
	}	
}
