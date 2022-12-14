package com.firebase.test.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.firebase.test.utility.CommonUtilities;
import com.firebase.test.utility.GenerateReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Logger logger = LogManager.getLogger(BaseTest.class);
	public static GenerateReports report = null;

	public static void getDriver(String browser) {

		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\likit\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		default:
			break;
		}
	}

	@BeforeTest
	public static void setupBeforeTest() {
		report = GenerateReports.getInstance();
		report.startExtentReports();
	}

	@Parameters({ "browserName" })
	@BeforeMethod
	public static void setUp(String browserName, Method m) {
		//logger.info("Before Method Start execution");
		report.startSingleTestReport(m.getName());
		report.logTestInfo("Before Method Start execution");
		CommonUtilities cu = new CommonUtilities();
		Properties applicationPropertiesFile = cu.loadFile("applicationProperties");
		String url = cu.getApplicationProperty("url", applicationPropertiesFile);
		getDriver(browserName);
		WaitDriver();
		driver.get(url);
		driver.manage().window().maximize();
		sleep(1);
	}

	@AfterMethod
	public static void tearDown() {
		logger.info("After method start execution");
		report.logTestInfo("After method start execution");
		sleep(3);
		driver.close();
	}

	@AfterTest
	public static void teardownAfterTest() {
		report.endReport();
	}

	public static void defineWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	}

	public static void loginWithoutPassword() {
		CommonUtilities cu = new CommonUtilities();
		Properties applicationPropertiesFile = cu.loadFile("applicationProperties");
		By username_locator = By.id("username");
		WebElement username = findByVisibility(username_locator, "username_locator");
		enterText(username, cu.getApplicationProperty("vaild_username", applicationPropertiesFile), "vaild-uname");

		By password_locator = By.id("password");
		WebElement password = findByVisibility(password_locator, "password_locator");
		clearElement(password, "clear-password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");
	}

	public static void clickButton(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			report.logTestInfo("Click-pass: " + objName + " field");
		} else {
			report.logTestFailed("Click-Fail:" + objName + " element not displayed");
		}
	}

	public static void enterText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			clearElement(element, objName);
			element.sendKeys(text);
			report.logTestInfo("Text enterted in " + objName + " field");
		} else {
			report.logTestFailed("Fail:" + objName + " element not displayed");
		}
	}

	public static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			report.logTestInfo("Pass:" + objName + " element cleared");
		} else {
			report.logTestFailed("Fail:" + objName + " element not cleared");
		}
	}

	public static WebElement findByVisibility(By locator, String objName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		if(driver.findElement(locator).isDisplayed()) {
			report.logTestInfo("Found Element by Visibility:" + objName);
		}
		else {
			report.logTestFailed("Found Element by Visibility:" + objName);
		}
		
		return driver.findElement(locator);
	}

	public static WebElement findByClickable(By locator, String objName) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		if(driver.findElement(locator).isDisplayed()) {
			report.logTestInfo("Found Element for Clickable:" + objName);
		}
		else {
			report.logTestFailed("Found Element for Clickable:" + objName);
		}
		return driver.findElement(locator);
	}

	/**
	 * @param sleepMs
	 */
	public static void sleep(int sleepSec) {
		try {
			Thread.sleep(sleepSec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WaitDriver() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
	}

	public static void verifyisSelected(WebElement element, String objName) {
		if (element.isSelected()) {
			report.logTestInfo("Pass:" + objName + " element Seleceted");
		} else {
			report.logTestFailed("fail:" + objName + " element not Seleceted");
		}
	}

	public static void verifyisDisplayed(WebElement element, String objName) {
		if (element.isDisplayed()) {
			report.logTestInfo("Pass:" + objName + " element displayed");
		} else {
			report.logTestFailed("fail:" + objName + " element not displayed");
		}
	}

	public static void WaitByLocator(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void vaildLogin() {
		CommonUtilities cu = new CommonUtilities();
		Properties applicationPropertiesFile = cu.loadFile("applicationProperties");
		By username_locator = By.id("username");
		WebElement username = findByVisibility(username_locator, "username_locator");
		enterText(username, cu.getApplicationProperty("vaild_username", applicationPropertiesFile), "vaild-uname");
		By password_locator = By.id("password");
		WebElement password = findByVisibility(password_locator, "password_locator");
		enterText(password, cu.getApplicationProperty("valid_Password", applicationPropertiesFile), "valid_Password");
		By login_locator = By.id("Login");
		WebElement loginbutton = findByClickable(login_locator, "login_locator");
		clickButton(loginbutton, "login-button");
	}

	public static void UserMenuClick() {

		By usermenu_locator = By.id("userNavLabel");
		WebElement usermenu = findByVisibility(usermenu_locator, "usermenu_locator");
		clickButton(usermenu, "usermenu");
	}

	public static void browseText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			element.sendKeys(text);
			report.logTestInfo("Text enterted in " + objName + " field");
		} else {
			report.logTestFailed("Fail:" + objName + " element not displayed");
		}
	}

	public static void shareButtonClick() {
		By sharebutton_locator = By.id("publishersharebutton");
		WebElement sharebutton = findByVisibility(sharebutton_locator, "sharebutton_locator");
		clickButton(sharebutton, "sharebutton");
	}

	public static void actionMovetoElement(WebElement element, String objName) {
		Actions moveto_objName = new Actions(driver);
		moveto_objName.moveToElement(element).perform();
		report.logTestInfo("Mouse moved to element :" + objName);

	}

	public static void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	public static void selectElelmentByVisibleText(WebElement element, String value) {
		Select element_select = new Select(element);
		element_select.selectByVisibleText(value);
		report.logTestInfo(value + " selected from dropdown");
	}

	public static void saveButtonClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("save")));
		WebElement save_button = driver.findElement(By.name("save"));
		clickButton(save_button, "save_button");
	}

	public static void selectRadiobutton(By locator, String objName, int i) {
		List<WebElement> radiobutton_objName = driver.findElements(locator);
		radiobutton_objName.get(i).click();
		report.logTestInfo("radio button seleceted is:" + objName);
	}

	public static void switchWindow() {
		// System.out.println("Switch to new window");
		String baseWindownHandle = driver.getWindowHandle();
		Set<String> allWindownHandle = driver.getWindowHandles();
		//System.out.println("Number of windows found: " + allWindownHandle.size());
		//System.out.println("Before switching " + driver.getCurrentUrl());
		for (String handle : allWindownHandle) {
			if (!baseWindownHandle.equals(handle)) {
				driver.switchTo().window(handle);
				System.out.println("After switching " + driver.getCurrentUrl());
				break;
			}
		}
		sleep(2);
		driver.close();
		driver.switchTo().window(baseWindownHandle);
	}

	public static void alertAccept() {
		System.out.println("The Alert is accepetd");
		driver.switchTo().alert().accept();
	}

	public static void alertReject() {
		System.out.println("The Alert is accepetd");
		driver.switchTo().alert().dismiss();
	}

	public static void accountTabClick() {
		By accounttab_locator = By.linkText("Accounts");
		WebElement account_tab = findByVisibility(accounttab_locator, "accounttab_locator");
		clickButton(account_tab, "account_tab");
	}

	public static void popupclose() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tryLexDialogX")));
		WebElement pop_up = driver.findElement(By.id("tryLexDialogX"));
		clickButton(pop_up, "pop_up");
		report.logTestInfo("Popup windown is closed");
	}

	public static void newButtonClick() {
		By new_button_locator = By.xpath("//input[@name='new']");
		WebElement new_button = findByVisibility(new_button_locator, "new_button_locator");
		clickButton(new_button, "new_button");
	}

	public static void clickonTabkey(WebElement element) {
		element.sendKeys(Keys.TAB);
		report.logTestInfo("click on tab Key");
	}

	public static void opportunitiesTabClick() {
		By Opportunities_locator = By.linkText("Opportunities");
		WebElement Opportunities_tab = findByVisibility(Opportunities_locator, "Opportunities_locator");
		clickButton(Opportunities_tab, "Opportunities_tab");
	}

	public static void dropDownOptions(String value) {
		By dropdown_locator = By.id("fcf");
		WebElement dropdown_click = findByVisibility(dropdown_locator, "dropdown_locator");
		clickButton(dropdown_click, "dropdown_click");
		Select dropdown_select = new Select(dropdown_click);
		List<WebElement> dropdown_option = dropdown_select.getOptions();

		int i = 1;
		report.logTestInfo("Below option available in the dropdown " + value);
		for (WebElement e : dropdown_option) {

			report.logTestInfo("option " + i + "is  " + e.getText());
			i++;
		}
	}

	public static void selectInterval(String value) {
		By interval_locator = By.id("quarter_q");
		WebElement interval = findByVisibility(interval_locator, "interval_locator");
		Select interval_select = new Select(interval);
		interval_select.selectByVisibleText(value);
	}

	public static void selectInclude(String value) {
		By include_locator = By.id("open");
		WebElement include = findByVisibility(include_locator, "include_locator");
		Select include_select = new Select(include);
		include_select.selectByVisibleText(value);
	}

	public static void runReport() {
		By runReport_locator = By.xpath("//input[@title='Run Report']");
		WebElement runReport = findByVisibility(runReport_locator, "runReport_locator");
		clickButton(runReport, "runReport");
	}

	public static void leadTabClick() {
		By lead_locator = By.linkText("Leads");
		WebElement lead_tab = findByVisibility(lead_locator, "lead_locator");
		clickButton(lead_tab, "lead_tab");
	}

	public static void salesforceLogout() {
		By logout_locator = By.linkText("Logout");
		WebElement logout = findByVisibility(logout_locator, "logout_locator");
		clickButton(logout, "logout-button");
	}

	public static String validateDropdown() {
		By dropdowncheck_locator = By.id("fcf");
		WebElement dropdowncheck = findByVisibility(dropdowncheck_locator, "dropdowncheck_locator");
		Select dropdowncheck_select = new Select(dropdowncheck);
		WebElement option = dropdowncheck_select.getFirstSelectedOption();
		String actual = option.getText();
		return actual;
	}

	public static void contactTabClick() {
		By contcat_locator = By.linkText("Contacts");
		WebElement contcat_tab = findByVisibility(contcat_locator, "contcat_locator");
		clickButton(contcat_tab, "contcat_tab");
	}

	public static void cancelButtonClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cancel")));
		WebElement cancel_button = driver.findElement(By.name("cancel"));
		clickButton(cancel_button, "cancel_button");
	}

	public static void homeTabClick() {
		By home_locator = By.id("home_Tab");
		WebElement home_tab = findByVisibility(home_locator, "home_locator");
		clickButton(home_tab, "home_tab");
	}

	public static void windowSwitchComboBox() {
		String baseWindownHandle = driver.getWindowHandle();
		Set<String> allWindownHandle = driver.getWindowHandles();
		for (String handle : allWindownHandle) {
			if (!baseWindownHandle.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		By otherclick_locator = By.linkText("Other");
		WebElement otherclick = findByVisibility(otherclick_locator, "otherclick_locator");
		clickButton(otherclick, "otherclick");
		// driver.close();
		driver.switchTo().window(baseWindownHandle);
	}

	public static String getscreenshort(WebElement elementLogo) {
		
	    TakesScreenshot scrshot=((TakesScreenshot)driver);
		File src = elementLogo.getScreenshotAs(OutputType.FILE);
		
		//report.logTestInfo("web element screenshot captured at " + src.getAbsolutePath());
		File dest = new File(
				System.getProperty("user.dir") + "/extentReports/Screenshort/" + System.currentTimeMillis() + ".png");

		try {
			FileHandler.copy(src, dest);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		String project_root = System.getProperty("user.dir") + "/extentReports";
		String relative = ".".concat(dest.getAbsolutePath().substring(project_root.length()));
		//report.logTestInfo("Relative file path is " + relative);
		return relative;
	}

	public static String getscreenshortdriver() {
		
	    TakesScreenshot scrshot=((TakesScreenshot)driver);
		File src = scrshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(
				System.getProperty("user.dir") + "/extentReports/Screenshort/" + System.currentTimeMillis() + ".png");

		try {
			FileHandler.copy(src, dest);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		String project_root = System.getProperty("user.dir") + "/extentReports";
		String relative = ".".concat(dest.getAbsolutePath().substring(project_root.length()));
		//report.logTestInfo("Relative file path is " + relative);
		return relative;
	}
	
	public static void dateChecker(WebElement enddate1) {
		Calendar calculate = Calendar.getInstance();
		calculate.add(Calendar.DATE, 14);
		Date futuredate = calculate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		String stringFutureDate = sdf.format(futuredate);
		report.logTestInfo("Current Date = " + stringFutureDate);
		String[] SplitFuturedate = stringFutureDate.split("/");
		String futuredate1 = SplitFuturedate[0];
		String futureMonth = SplitFuturedate[1];
		String futureYear = SplitFuturedate[2];

		By calendarMonth_locator = By.id("calMonthPicker");
		WebElement monthView = findByVisibility(calendarMonth_locator, "calendarMonth_locator");
		selectElelmentByVisibleText(monthView, futureMonth);

		By calendarYear_locator = By.id("calYearPicker");
		WebElement yearView = findByVisibility(calendarYear_locator, "calendarYear_locator");
		selectElelmentByVisibleText(yearView, futureYear);

		WebElement calendar = findByVisibility(By.xpath("//*[@id=\"datePickerCalendar\"]"), "calendar");
		List<WebElement> rows = calendar.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				// System.out.println("Cell data is " + cell.getText());
				if (cell.getText().equals(futuredate1)) {
					cell.click();
					break;
				}
			}
		}
	}

}
