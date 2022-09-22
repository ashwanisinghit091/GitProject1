package flipkart_WebPages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWebPage {
WebDriver driver;
	public LoginWebPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	static final Logger l=LogManager.getLogger(LoginWebPage.class.getName());
	
	@FindBy(css="div input[class=\"_2IX_2- VJZDxU\"]") WebElement userName;
	@FindBy(css="div input[type=\"password\"]") WebElement password;
	@FindBy(css="div[class=\"_1D1L_j\"] button[type=\"submit\"]") WebElement submit;
	
	
	
	public HomeWebPage login() throws InterruptedException {
		System.out.println("I am in");
		userName.click();
		l.info("Clicked on username box");
		
		userName.sendKeys("8056100429");
		l.info("entered the username");
		System.out.println("I am in3");
		password.click();
		password.sendKeys("Pinki@50S");
		l.info("enter the password");
		submit.click();
		l.info("Successfully login to homepage");
		Thread.sleep(2000);
		return new HomeWebPage(driver);
	}
	
	
	
}
