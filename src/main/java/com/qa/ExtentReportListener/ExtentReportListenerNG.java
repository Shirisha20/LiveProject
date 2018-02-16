package com.qa.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListenerNG implements IReporter {

	public ExtentReports extent;
	WebDriver driver;
	ExtentTest extentTest;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator + "Facebook_Extent.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);

				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);

				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);

			}
		}

		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				extentTest = extent.startTest(result.getMethod().getMethodName());

				extentTest.setStartedTime(getTime(result.getStartMillis()));
				extentTest.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					extentTest.assignCategory(group);

				if (result.getThrowable() != null) {
					extentTest.log(status, result.getThrowable());
				} else {
					extentTest.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				extent.endTest(extentTest);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}