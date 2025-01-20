package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.Scenario;
import pageFactory.Homepage;
import pageFactory.ProductListPage;
import pageFactory.ViewProductPage;


public class TestBase {
	
	public static Properties prop;
	public static String Browser;
	public static String url;
	public static WebDriver driver;
	public static  JavascriptExecutor js;
	public static SoftAssert st;
	public static Homepage homep;
	public static XSSFWorkbook wbook;
	public static HashMap<String, String>map;
	public static ProductListPage plistpage;
	public static ViewProductPage viewProductData;
	
	
	public static void openBrowser() throws Throwable, Throwable
	{
		
		prop=new Properties();
		prop.load(new FileReader("src\\test\\java\\config\\Global.properties"));
		Browser=prop.getProperty("Browser");
		System.out.println(Browser);
		  if(Browser.equalsIgnoreCase("chrome")) driver=new ChromeDriver();
		  else
		  if(Browser.equalsIgnoreCase("Firefox")) driver=new FirefoxDriver(); 
		  else
		  if(Browser.equalsIgnoreCase("Edge")) driver=new EdgeDriver();
		 url=prop.getProperty("url");
		 System.out.println(url);
		  driver.get(url);
		  driver.manage().window().maximize();	
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		// Thread.sleep(4000);
		  
		js= (JavascriptExecutor)driver;
		st= new SoftAssert();
				
		  
		 ititclass();
		
	}
	
	
	@Test
	public static void moduledriver() throws Throwable
	{
		String fileloc="./excelPack/ModuleDriver.xlsx";
		wbook=new XSSFWorkbook(fileloc);
		XSSFSheet sheet = wbook.getSheetAt(0);
		
		for(int i=1;i<=2;i++)
		{
			XSSFRow row = sheet.getRow(i);
			
				for(int j=0;j<2;j++)
				{
				XSSFCell cell = row.getCell(j);
				String username = cell.getStringCellValue();
				System.out.println(username);
				
			 
				}
		}
		
		
	}
	

	public static String readExcel(int row, int cell) throws Throwable
	{
		String fileLocation="./TestData/SelTest.xlsx";
		XSSFWorkbook wbook= new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		XSSFRow rows = sheet.getRow(row);
		XSSFCell cells = rows.getCell(cell);
		String unameone= cells.getStringCellValue();
		//wbook.close();
		return unameone;
		/*
		 * System.out.println(Value); UserNameField.sendKeys(Value);
		 */
		
	}
	
	public static void closeBrowser()
	{
		 
		//driver.quit();
	}
	
	public static void ititclass()
	{
	
		homep=PageFactory.initElements(driver, Homepage.class);
		plistpage=PageFactory.initElements(driver, ProductListPage.class);
		viewProductData=PageFactory.initElements(driver, ViewProductPage.class);
	}

}
