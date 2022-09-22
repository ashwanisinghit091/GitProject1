package flipkart_WebPages;








import java.util.List;






import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroceryWebPage {
	WebDriver driver;
	
	public GroceryWebPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	static private Logger l=LogManager.getLogger(GroceryWebPage.class.getName());
	
	
	
	
	@FindBy(css="input[class=\"_166SQN\"]") WebElement pincodeWe;
	@FindBy(css="div[class=\"_3OO5Xc\"] input") WebElement searchBoxWe;
	
	
	
	
	public ProductAfterSearchWebPage searchBox(String product) {
		searchBoxWe.sendKeys(product);
		searchBoxWe.sendKeys(Keys.ENTER);
		l.info("successfully entered the product for search and click enter");
		return new ProductAfterSearchWebPage(driver);
		
	}
	
	public void pincode() throws InterruptedException {
		Thread.sleep(2000);
		pincodeWe.sendKeys("125055");
		l.info("successfully enter the pincode");
		pincodeWe.sendKeys(Keys.ENTER);
	}

}
