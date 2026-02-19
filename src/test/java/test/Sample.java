package test;

import org.testng.annotations.Listeners;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Reports;

@Listeners(utility.Listeners.class)


public class Sample {
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		reports = Reports.createExtentReports();
	}
	
	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	
	@Test(dependsOnMethods ="test3")
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(timeOut = 1000)
	public void test3() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test2");
	}
	
	@AfterMethod  // Dependency injection concept
	public void publishResult(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else {
			test.log(Status.SKIP, result.getName());
			}
	}
	
	@AfterTest
	public void createReport() {
		reports.flush();
	}

}
