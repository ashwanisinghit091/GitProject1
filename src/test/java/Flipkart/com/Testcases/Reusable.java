package Flipkart.com.Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Reusable {
	WebDriver driver ;
	
	String filePath;
String	imagePath;
FileOutputStream fo;
	
	
	public void robot() throws AWTException, IOException {
		
		
		
		FileInputStream fs=new FileInputStream("D:\\workspace100\\FlipkartAutomation\\src\\main\\java\\DataResources\\Platform.properties");
		Properties p=new Properties();
		p.load(fs);
		imagePath=p.getProperty("UploadFilePath");
		StringSelection s=new StringSelection(imagePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void WebDriverdriver_Wait(WebElement element,String WaitMethodName) {
		
		WebDriverWait wait =new WebDriverWait(driver,20);
		if(WaitMethodName.contains("visibilityOf")) {
		wait.until(ExpectedConditions.visibilityOf(element));}
		
		else if(WaitMethodName.contains("ElementTObeClickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));}
	}
	
	
	public void CheckExistenceOfFile() throws FileNotFoundException {
    fo=new FileOutputStream(filePath);
		
		Assert.assertNotNull(fo);
		
	}
}
