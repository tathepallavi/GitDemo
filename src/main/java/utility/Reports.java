package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports createExtentReports() {
		
		ExtentReports reports = new ExtentReports(); // data collect
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentreports.html");
		
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("createdBy", "Pallavi");
		
		reports.setSystemInfo("TestSuite", "Regression");
		
		return reports;
		

	
	}


}
