package testComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportsNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReportsNG.getReporting();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS, "passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver=null;
		
		try
		{
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver")
				.get(result.getInstance());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String path=null;
		
		try
		{
			path=getScreenshot(driver,result.getMethod().getMethodName());
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		
		
		extentTest.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{

	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
