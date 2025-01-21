package pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import testBase.TestBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
public class Homepage extends TestBase
{
	
	@FindBy(xpath="//input[@name='q']")public WebElement searchText;
	@FindBy(xpath="//form[@action='/search']/ul/li/div/a/div[2]")public List<WebElement> searchlist;
	@FindBy(xpath="//div[text()='Customer Ratings']/../../div[2]/div/div[2]")public WebElement Ratings;
	
	public void searchs() throws Throwable, Throwable
	{
	prop=new Properties();
	prop.load(new FileReader("src\\test\\java\\config\\Global.properties")); 
	String searchproduct=prop.getProperty("search_product"); 
	searchText.sendKeys(searchproduct);
	}
	
	public void searchdata()
	{
		for(WebElement e: searchlist)
		{
			System.out.println(e.getText());
		}
	}
	
	public void selectdropvalue()
	{
		for(WebElement e:searchlist)
		{
			if(e.getText().equals(prop.getProperty("search_product")))
			{
				e.click();
				break;
			}
			else if(e.getText().contains(prop.getProperty("search_product")))
			{
				e.click();
				break;
			}
		}
	}
	
	public void ValidateTitle()
	{
		String ExpectedUrl = prop.getProperty("url");
		String currentUrl = driver.getCurrentUrl();
		st.assertEquals(currentUrl, ExpectedUrl);
		
		String actualtitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String title = driver.getTitle();
		st.assertEquals(actualtitle, title);
		st.assertAll();	
		
	}
	
	/*
	 * public void specialChar(String str) { searchText.sendKeys(str);
	 * 
	 * }
	 */

	public void specialChar(String string) throws AWTException, Throwable {
		// TODO Auto-generated method stub
		searchText.sendKeys(string);
		Thread.sleep(1000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_DELETE);
		//searchText.sendKeys(Keys.BACK_SPACE);
	}
	
	
	

}
