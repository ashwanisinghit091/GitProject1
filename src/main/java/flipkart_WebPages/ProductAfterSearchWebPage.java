package flipkart_WebPages;

import java.util.List;


import java.util.Set;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductAfterSearchWebPage {


	

	WebDriver driver;
	
	public ProductAfterSearchWebPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	static final Logger l=LogManager.getLogger(ProductAfterSearchWebPage.class.getName());
	
	
	@FindBy(css="div[class=\"_35mN4f\"]") List<WebElement> resultantProductWe;
	@FindBy(xpath="//div[@class=\"row\"]/button") WebElement AddCartWe;
	
	
	By quantity=By.cssSelector("div[class=\"_3BhXPZ\"] button div div:first-of-type");
	By desiredProduct=By.cssSelector("div[class=\"_1v0EHc\"] div div[class=\"_1MbXnE\"]");
	
	public List<WebElement> resultantProduct() {
		l.debug("checking searching functionality");
		return resultantProductWe;
		
		
		
	}
	
	public ProductDescriptionWebPage GetDesireProduct(List<WebElement> resultantProductsWe1,String productname,String quantity1) throws InterruptedException {
		for(WebElement resultantProductsWe:resultantProductsWe1) {
		
			
//WebDriverWait wait=new WebDriverWait(driver,20);
//wait.until(ExpectedConditions.visibilityOf(driver.findElement(desiredProduct)));
//System.out.println(resultantProductsWe.findElement(desiredProduct).getText());
			l.debug("matching desired product to Searched products and clicking on desired product");
		if(resultantProductsWe.findElement(desiredProduct).getText().contains(productname)&&resultantProductsWe.findElement(quantity).getText().contains(quantity1)){
			
			
			//System.out.println("yes");
			resultantProductsWe.click();
			l.info("Susccesfully Clicked on desired product");
			
		}}
		return new ProductDescriptionWebPage();
		
	}
	
	

}
