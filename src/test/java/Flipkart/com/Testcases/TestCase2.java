package Flipkart.com.Testcases;

import java.io.IOException;
import java.util.HashMap;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Flipkart.com.Listeners.ListenerRerunTest;

import org.apache.logging.log4j.*;

import flipkart_WebPages.AddCartWebPage;
import flipkart_WebPages.HomeWebPage;
import flipkart_WebPages.LoginWebPage;
import flipkart_WebPages.MobileWebPage;

public class TestCase2 extends BaseTest{
	
	
	
	
	
	
	
	
private	static  Logger  l=LogManager.getLogger(TestCase2.class.getName());
	
	
//private static Logger l2=LogManager.getLogger(LaoDemo2.class.getName());
	
	
	LoginWebPage LoginWebPageref;
	HomeWebPage HomeWebPageref;
	MobileWebPage MobileWebPageref;
	AddCartWebPage 	AddCartWebPageref;

		
		@Test
		public void SearchMob() throws InterruptedException {
			HashMap<String,String> product=getProductType();
			System.out.println("testin");
			LoginWebPageref=new LoginWebPage(driver);
			l.debug("Checking Login Functionality");
			HomeWebPageref=LoginWebPageref.login();
			
			l.debug("Clicking on grocery link");
			MobileWebPageref=	(MobileWebPage) HomeWebPageref.ChooseProductType(product.get("Mobiles"));
			getCaptureScreenShot(driver,"SearchMob");
			MobileWebPageref.selectMobileCompany();
			
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void initiateBrowser() throws IOException {
		driver=	invokeBrowser();
	
	}
	

@Test(groups="Smoke",retryAnalyzer=ListenerRerunTest.class)
public void AddCart() throws InterruptedException {
	
	System.out.println("testin");
	LoginWebPageref=new LoginWebPage(driver);
	l.debug("Checking Login Functionality");
	HomeWebPageref=LoginWebPageref.login();
	AddCartWebPageref=	HomeWebPageref.clickCart();
	AddCartWebPageref.checkCart();
		
	
}




@Test
@Parameters({"text","ElectronicProduct","ElectronicSubProduct"})
public void clickElectronic(String text,String ElectronicProduct,String ElectronicSubProduct ) throws InterruptedException {


LoginWebPageref=new LoginWebPage(driver);
l.debug("Checking Login Functionality");
HomeWebPageref=LoginWebPageref.login();
HomeWebPageref.ChooseProductType(text);
HomeWebPageref.ChooseProfrmElectronicTab(ElectronicProduct, ElectronicSubProduct);

}


}
