package com.firebase.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReports {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static GenerateReports ob;
	private GenerateReports() {
	}
		public static GenerateReports getInstance() {
			if(ob==null) {
				ob=new GenerateReports();
			}
			return ob;
		}
		public void startExtentReports() {
			htmlReporter = new ExtentHtmlReporter(Constant.GENERATE_REPORT_PATH);
			extent = new ExtentReports();
			
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "Salesforce");
			extent.setSystemInfo("Environment", "Automation Testing");
			extent.setSystemInfo("User Name", "LikithaHS");
			
			htmlReporter.config().setDocumentTitle("Test Execution Report");
			htmlReporter.config().setReportName("firebase regression tests");
			htmlReporter.config().setTheme(Theme.STANDARD);
		}
		public void startSingleTestReport(String testname) {
			logger = extent.createTest(testname);
		}
		public void logTestInfo(String message) {
			logger.log(Status.INFO, message);
		}
		public void logTestPassed(String testcasename) {
			logger.log(Status.PASS, MarkupHelper.createLabel(testcasename + "is passTest",ExtentColor.GREEN));
		}
		
		public void logTestFailed(String testcasename) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(testcasename + "is not passTest",ExtentColor.RED));
		}
		public void logTestFailedWithException(Exception e) {
			logger.log(Status.ERROR, e);
		}
		public void logTestSkipped(String testcasename) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(testcasename + "is not passTest",ExtentColor.RED));
		}
		public void endReport() {
			extent.flush();
		}
	}

