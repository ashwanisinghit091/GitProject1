package Flipkart.com.Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	
	
	
	public static WebDriver driver;

	
	
	
	
	
public WebDriver invokeBrowser() throws IOException{
	FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/DataResources/Platform.properties");
Properties p=new Properties();
p.load(f);
System.out.println(System.getProperty("Browser"));
String drivername=System.getProperty("Browser")!=null?System.getProperty("Browser"):p.getProperty("Browser");
if(drivername.equalsIgnoreCase("CHROME")) {
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(	p.getProperty("URL"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
}
	
	
	
	




if(drivername.equalsIgnoreCase("EDGEDRIVER")) {
	System.setProperty("webdriver.edge.driver", "E:\\msedgedriver.exe");
	driver=new EdgeDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

}






if(drivername.equalsIgnoreCase("FIREFOX")) {
	System.setProperty("webdriver.geckodriver.driver", "E:\\geckodriver.exe");
	driver=new FirefoxDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

}
return driver;



	
}

public String   getCaptureScreenShot(WebDriver driver1,String TestCaseName) {
	
TakesScreenshot ts=(TakesScreenshot)driver1;
File f=ts.getScreenshotAs(OutputType.FILE);
File path= new File(System.getProperty("user.dir")+"//ScreenShots//"+TestCaseName+".png");
try {
	FileUtils.copyFile(f, path);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return  System.getProperty("user.dir")+"//ScreenShots//"+TestCaseName+".png";
}
public HashMap<String,String> getProductType(){
	
	HashMap<String,String> h=new HashMap<String,String>();
	h.put("Grocery", "Grocery");
	h.put("Mobiles","Mobiles");
	
	return h;}


public ExtentReports config() {
	
	File f=new File("D:\\workspace100\\FlipkartAutomation\\test-output\\index.html");
	ExtentSparkReporter ex=new ExtentSparkReporter(f);
	ex.config().setDocumentTitle("Selenium Test Report");
	ex.config().setTimeStampFormat("DD/MM/YY");
	ExtentReports er=new ExtentReports();
	ex.config().setReportName("Selenium Automation Report");

	er.attachReporter(ex);
	return er;
	
}

}






