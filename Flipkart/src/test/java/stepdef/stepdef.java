package stepdef;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.TestBase;

public class stepdef extends TestBase
{

	@BeforeAll
	public static void beforeAllfeatures() throws Throwable
	{
		openBrowser();
		
	}
	
	@AfterAll
	public static void afterAllfetaures()
	{
		closeBrowser();
	}
	
	@Given("^user launch url$")
	public void user_launch_url() 
	{
	   System.out.println("User Launches the website");
	   
	}

	@When("^user search for specific product in search bar$")
	public void user_search_for_specific_product_in_search_bar() throws Throwable 
	{
	        Thread.sleep(2000);
	        homep.searchs();
	}

	@And("search dropdown list will disply")
	public void search_dropdown_list_will_disply() throws Throwable 
	{
		Thread.sleep(2000);
		homep.searchdata();
	
	  
	}

	@Then("user selects first item from dropdown")
	public void user_selects_first_item_from_dropdown() throws Throwable 
	{
	   homep.selectdropvalue();
	   Thread.sleep(2000);
	   
	}

	//***************************ProductListPage**********************************//
	
	@Given("User is the product page")
	public void user_is_the_product_page() {
		 System.out.println("Product List Page");
	}

	@When("user apply brand, price and rating filter")
	public void user_apply_brand_price_and_rating_filter() throws Throwable {
	
	plistpage.DropDownList();
	Thread.sleep(2000);
	plistpage.SelectBeand();

	}

	@And("Based on filter item will display")
	public void based_on_filter_item_will_display() throws Throwable {
		plistpage.CustRating();
		Thread.sleep(2000);
	}

	@Then("user click First item in the list")
	public void user_click_first_item_in_the_list()throws Throwable  {
		plistpage.FirstProductSelect();
		Thread.sleep(2000);
	}

 //***********************Test Case 2************************************************	
	
	@Given("user url in browser")
	public void user_url_in_browser() {
		
	}

	@When("user validate title and URL from application")
	public void user_validate_title_and_url_from_application() {
	      
		homep.ValidateTitle();
	}
	
 //***************************Test case 3***********************************************
	
	@When("user search for a product in search bar by entering {string}")
	public void user_search_for_a_product_in_search_bar_by_entering(String string) throws Throwable {
		homep.specialChar(string);
	}
	
	@Then("user will not get any dropdown option")
	public void user_will_not_get_any_dropdown_option() 
	{
	  homep.searchdata();
	}
	
  //***********************View Product Page*******************************************
	
	@Given("user is on the View product page")
	public void user_is_on_the_view_product_page() throws Throwable 
	{
		Thread.sleep(1500);
		viewProductData.verifyTitle();
	}

	@When("user validate the name, price, discount and sellerinfo")
	public void user_validate_the_name_price_discount_and_sellerinfo() throws Throwable, IOException 
	{
	  Thread.sleep(1000);
	}

	@Then("user click add to cart button")
	public void user_click_add_to_cart_button()
	{
		viewProductData.AddToCart();
	}

	//******************User validate Cart page************************
	
	@Given("user is on the view Cart page")
	public void user_is_on_the_view_cart_page() throws Throwable {
		Thread.sleep(1000);
		viewProductData.validateDeatils();
	}

	@When("user validate and click on place order")
	public void user_validate_and_click_on_place_order() {
		viewProductData.clickPlaceOrder();
	}

}
