package AutomationProject.DemoE2ETesting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportTestNG;
import resources.PreRequisite;

public class ListenerClass extends PreRequisite implements ITestListener {
	ExtentReportTestNG extentReportObject = new ExtentReportTestNG();
	ExtentReports extentReportsObject = extentReportObject.getExterntReport();
	ExtentTest extentTestObject;
	ThreadLocal<ExtentTest> threadLocalObject = new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestStart(result);
		extentTestObject = extentReportsObject.createTest("Demo Report Test of" + result.getMethod().getMethodName());
		threadLocalObject.set(extentTestObject);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extentReportsObject.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
		threadLocalObject.get().log(Status.FAIL, "Test Failed With Timeout");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String testCaseName = result.getMethod().getMethodName();
		// screenshot method to be called.
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		try {
			threadLocalObject.get().addScreenCaptureFromPath(getScreenshotPath(testCaseName, driver), testCaseName);
			//getScreenshotPath(testCaseName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ITestListener.super.onTestFailure(result);
		threadLocalObject.get().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		threadLocalObject.get().log(Status.SKIP, "Test Skipped");
	}

	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		threadLocalObject.get().log(Status.PASS, "Test Passed");
	}

}
