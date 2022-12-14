package com.firebase.test.pages.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.firebase.test.utility.GenerateReports;

public class BasePage {
   protected static WebDriver driver;
   protected static WebDriverWait wait;
   protected static GenerateReports report;
	
	public BasePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		report=GenerateReports.getInstance();
	}
	public static String getPageTitle() {
		return driver.getTitle();
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
		report.logTestInfo("page got refreshed");
	}
	public static void clickButton(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			//logger.info("Click-pass: " + objName + " field");
			report.logTestInfo("Click-pass: " + objName + " field");
		} else {
			//logger.error("Click-Fail:" + objName + " element not displayed");
			report.logTestFailed("Click-Fail:" + objName + " element not displayed");
		}
	}

	public static void enterText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			clearElement(element, objName);
			element.sendKeys(text);
			//logger.info("Text enterted in " + objName + " field");
			report.logTestInfo("Text enterted in " + objName + " field");
		} else {
			//logger.error("Fail:" + objName + " element not displayed");
			report.logTestFailed("Fail:" + objName + " element not displayed");
		}
	}

	public static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			//logger.info("Pass:" + objName + " element cleared");
			report.logTestInfo("Pass:" + objName + " element cleared");
		} else {
			//logger.error("Fail:" + objName + " element not cleared");
			report.logTestFailed("Fail:" + objName + " element not cleared");
		}
	}
	public static void waitByVisibility(WebElement element, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(element));
		report.logTestInfo("Found Element by Visibility:"+objName);
		
	}
	
	public static WebElement findByClickable(By locator, String objName) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		report.logTestInfo("Element available for click:"+objName);
		return driver.findElement(locator);
	}
	
	public static void verifyisSelected(WebElement element,String objName) {
		if(element.isSelected()){
			report.logTestInfo("Pass:" + objName + " element Selecetd");
		}
		else
		{
			report.logTestFailed("fail:" + objName + " element not Selecetd");
		}
	}

}
