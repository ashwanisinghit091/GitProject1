package Flipkart.com.Testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataResources.JasonDataFile;
import flipkart_WebPages.GroceryWebPage;
import flipkart_WebPages.HomeWebPage;
import flipkart_WebPages.LoginWebPage;
import flipkart_WebPages.ProductAfterSearchWebPage;
import flipkart_WebPages.ProductDescriptionWebPage;







public class TestCase1 extends BaseTest{

	

	LoginWebPage LoginWebPageref;
	HomeWebPage HomeWebPageref;
	GroceryWebPage GroceryWebPageref;
	ProductDescriptionWebPage ProductDescriptionWebPageref;
	ProductAfterSearchWebPage ProductAfterSearchWebPageref;
	WebDriver driver;

	static final Logger l=LogManager.getLogger(TestCase1.class.getName());
	

	
	
	@Test(dataProvider= "getJasonData")
	public void SearchProduct(HashMap<String,String> product) throws InterruptedException {
		
		System.out.println("testin");
		LoginWebPageref=new LoginWebPage(driver);
		l.debug("Checking Login Functionality");
		 HomeWebPageref=LoginWebPageref.login();
		
		
		l.debug("Clicking on grocery link");
		GroceryWebPageref=	HomeWebPageref.Grocery();
		l.info("Entered the Grocery webpage");
		l.debug("checking pincode func");
		GroceryWebPageref.pincode();
		l.debug("Checking search box functionality");
		ProductAfterSearchWebPageref=	GroceryWebPageref.searchBox(product.get("Product"));
		l.debug("checking either product appears or not");
		List<WebElement> resultantProductsWe= ProductAfterSearchWebPageref.resultantProduct();
		l.info("Product search succesfully");
		l.debug("checking desired product selected or not");
		ProductDescriptionWebPageref=ProductAfterSearchWebPageref.GetDesireProduct(resultantProductsWe,product.get("ProductName"),product.get("Quantity"));

	
	
	}
	
	
	@DataProvider
	public Object[][] getJasonData() throws IOException{

		JasonDataFile j=new JasonDataFile();
		List<HashMap<String,String>> data1=j.getData();
		Object data [][]={ {data1.get(0)},{data1.get(1)}};
		return 		data;
		
	
		
		
		
		
	}
	
	
	
	@BeforeMethod(alwaysRun=true )
	public void initiateBrowser() throws IOException, InterruptedException {
		driver=	invokeBrowser();
		
	}
	
	
	
	@AfterMethod(alwaysRun=true,enabled=false )
	public void closeBrowser() throws IOException {
		driver.close();
	
	}
	
	
	
	
	@Test(groups="Smoke",enabled=false)
	public void LoginFinctionality() throws InterruptedException {
		
		LoginWebPageref=new LoginWebPage(driver);
		l.debug("Checking Login Functionality");
		HomeWebPageref=LoginWebPageref.login();
System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));
	}
	}
