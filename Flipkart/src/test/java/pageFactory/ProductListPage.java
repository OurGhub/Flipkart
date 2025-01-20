package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class ProductListPage extends TestBase
{
	
	@FindBy(xpath="//div[text()='to']/../div[3]/select")public WebElement pricedropdown;
	@FindBy(xpath="//div[text()='SAMSUNG']")public WebElement BrandCheckbox;
	@FindBy(xpath="//div[text()='Customer Ratings']")public WebElement CustRate;
	@FindBy(xpath="//div[text()='Customer Ratings']/../../div[2]/div/div[2]")public WebElement CustomerRate;
	@FindBy(xpath="//span[contains(text(),'Showing 1')]/../../../following-sibling::div[1]")public WebElement FirstItem;
	
	public void DropDownList()
	{
		Select s=new Select(pricedropdown);
		List<WebElement> options = s.getOptions();
		
		for(WebElement e:options)
		{
			if(e.getText().contains("30000"))
				e.click();
		}
	}
	public void SelectBeand() throws Throwable
	{
		BrandCheckbox.click();
	
	}
	
	public void CustRating() throws Throwable
	{
		Actions act=new Actions(driver);
		act.scrollToElement(CustRate);
		Thread.sleep(2000);
		CustomerRate.click();
		
	}
	public void FirstProductSelect()
	{
		FirstItem.click();
	}

}
