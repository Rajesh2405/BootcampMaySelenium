package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public void extentReportImplementation() {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Report/data.html");
		
		ExtentReports test = new ExtentReports();
		
		test.attachReporter(reporter);
		
		ExtentTest createTest = test.createTest("","");
		
		createTest.assignAuthor("Rajesh");
		createTest.assignCategory("Regression");
	
		
	}

}
