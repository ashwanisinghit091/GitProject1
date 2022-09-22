package flipkart_WebPages;

import java.util.List;

import org.apache.logging.log4j.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeWebPage {

	Object o;

static private Logger l=LogManager.getLogger(HomeWebPage.class.getName());
	WebDriver driver;
	
	public HomeWebPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class=\"_37M3Pb\"] :nth-child(2)[class=\"eFQ30H\"]") WebElement GroceryrWe;
	@FindBy(css="div[class=\"eFQ30H\"]") List<WebElement> ChooseProductTypeWe;
	@FindBy(css="div a[class=\"_3SkBxJ\"]") WebElement clickCartWe;
	
	
	@FindBy(css="div[class*=\"_7qr1OC\"] a") List<WebElement> ChooseProfrmElectronicTabWe;
	
	@FindBy(css="div [class=\"_3XS_gI\"] a")  List<WebElement> ChooseSubProfrmElectronicTabWe;
	
	public  GroceryWebPage Grocery() throws InterruptedException {
		Thread.sleep(2000);
		GroceryrWe.click();
		l.info("Clicked on Grocery link");
		
	
	return  new GroceryWebPage(driver) ;
	}
	
	
	
	
	
	
	public  Object ChooseProductType(String text) throws InterruptedException {
		Thread.sleep(2000);
		for(int i=0;i<ChooseProductTypeWe.size();i++) {
			if(ChooseProductTypeWe.get(i).getText().equalsIgnoreCase(text)) {
				
				if(ChooseProductTypeWe.get(i).getText().equalsIgnoreCase("Electronics")) {
				Actions a=new Actions(driver);
				a.moveToElement(ChooseProductTypeWe.get(i)).build().perform();
				}
				
				else {ChooseProductTypeWe.get(i).click();}
		//l.info("Clicked on Grocery link");
		break;
	

	}}
			if(text=="Mobiles") {
				 o=  new  MobileWebPage(driver);}
			if(text=="Grocery") {
				 o=  new  GroceryWebPage(driver);}
	
	return o;
	
}
	


public AddCartWebPage clickCart() {
	clickCartWe.click();
	return new AddCartWebPage(driver);
	
}


public void ChooseProfrmElectronicTab(String ElectronicProduct,String ElectronicSubProduct) {
	for(int i=0;i<ChooseProfrmElectronicTabWe.size();i++) {
	if(ChooseProfrmElectronicTabWe.get(i).getText().equalsIgnoreCase(ElectronicProduct)){
		Actions a=new Actions(driver);
		a.moveToElement(ChooseProfrmElectronicTabWe.get(i)).build().perform();
		if(ChooseProfrmElectronicTabWe.get(i).getText().equalsIgnoreCase(ElectronicSubProduct)) {
			
			
			a.moveToElement(ChooseSubProfrmElectronicTabWe.get(i)).click().build().perform();
			
		}
	}
}
}

}
