package Flipkart.com.Listeners;











import org.apache.logging.log4j.*;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Flipkart.com.Testcases.BaseTest;




public class Listeners extends BaseTest implements ITestListener{
	static final Logger l=LogManager.getLogger(Listeners.class.getName());
	WebDriver driver;
	String path;
	ExtentTest test;
ExtentReports er;
ThreadLocal<ExtentTest> th;
	public void onTestStart(ITestResult result) {
	th=new ThreadLocal<ExtentTest>();
		er=config();
	
		test=er.createTest(result.getMethod().getMethodName());
		
		th.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		try {
			
			
			System.out.println("I am listener");
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	path=getCaptureScreenShot(driver,result.getMethod().getMethodName());

	th.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	
	l.info("Testcase is passed with screeshot"+result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
	
		try {
			System.out.println("i am testfailur");
			System.out.println(driver);
			
			
			
			//driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			driver=	(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			System.out.println("i am testfailur2");
			System.out.println(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		getCaptureScreenShot(driver,result.getMethod().getMethodName());
		path=getCaptureScreenShot(driver,result.getMethod().getMethodName());
		th.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		l.error("TestCases Failed with screenshot"+result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
	er.flush();
		
	}

}
