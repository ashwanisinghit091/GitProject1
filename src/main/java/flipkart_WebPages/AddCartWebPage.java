package flipkart_WebPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;






public class AddCartWebPage {
	

@FindBy(css="div[class=\"_1At\"]") List<WebElement> checkCartref;
	
	WebDriver driver;
	
	public AddCartWebPage(WebDriver driver){
		
	this.driver=driver;	
	PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void checkCart() {
		Assert.assertNotNull(checkCartref.size());
		
		
	}

}


