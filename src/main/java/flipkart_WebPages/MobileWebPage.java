package flipkart_WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileWebPage {

	
	
	
	WebDriver driver;
	public MobileWebPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(css="div[class*=\"_1AtVbE\"] div div div img:nth-child(2)") List<WebElement> selectMobileCompany;
	//By selectMobileCompany1=By.cssSelector("div[class*=\"_1AtVbE\"] div div div img:nth-child(2)");
	public void selectMobileCompany() {
		
	System.out.println(selectMobileCompany.size());
		for(int i=0;i<selectMobileCompany.size();i++) {

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	      
	        js.executeScript("window.scrollBy(0,1000)");
			if(selectMobileCompany.get(i).getAttribute("alt").contains("samsung-F23-5G")) {
				
				selectMobileCompany.get(i).click();
				break;
			}
		}
		
		
	}
	
	//Products.stream().filter(s->s.getText().contains("Rice")).
	//map(s->s.findElement(By.xpath("following-sibling::td[1]")).getText()).forEach(s->System.out.println(s));
}
