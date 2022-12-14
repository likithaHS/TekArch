package com.firebase.test.test;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtend {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + File.separator + "extentReport2.html");
		setHtmlReporterConfig(htmlReporter);

		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		setExtentReportsSystemInfo(extentReports);

		ExtentTest extentTest = extentReports.createTest("Test1");
		extentTest.log(Status.INFO, "Test1 INFO");
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Test1" + " PASSED", ExtentColor.GREEN));
		extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test1" + " FAILED", ExtentColor.RED));

		extentTest = extentReports.createTest("Test2");
		extentTest.log(Status.INFO, "Test2 INFO");
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Test2" + " PASSED", ExtentColor.GREEN));
		extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test2" + " FAILED", ExtentColor.RED));

		System.out.println(".\\Screenshort\\1664658986842.png");
		extentTest.addScreenCaptureFromPath(".\\Screenshort\\1664658986842.png");

		extentReports.flush();
		System.out.println("Completed");

	}

	public static void setExtentReportsSystemInfo(ExtentReports extentReports) {
		extentReports.setSystemInfo("Host Name", "Salesforce");
		extentReports.setSystemInfo("Environment", "Automation Testing");
		extentReports.setSystemInfo("User Name", "LikithaHS");
	}

	public static void setHtmlReporterConfig(ExtentHtmlReporter htmlReporter) {
		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("firebase regression tests");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

}
