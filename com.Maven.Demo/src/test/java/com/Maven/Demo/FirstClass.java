package com.Maven.Demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstClass extends ReadProperties {

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

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

	public static void webPageLaunch(String browser) throws IOException, InterruptedException {
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}

	public static void vaildLogin() throws IOException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");
	}

	public static void accountTabClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Accounts")));
		WebElement account_tab = driver.findElement(By.linkText("Accounts"));
		clickButton(account_tab, "account_tab");
	}

	public static void enterText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			clearElement(element, objName);
			element.sendKeys(text);
			System.out.println("Text enterted in " + objName + " field");
		} else {
			System.out.println("Fail:" + objName + " element not displayed");
		}
	}

	public static void browseText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			element.sendKeys(text);
			System.out.println("Text enterted in " + objName + " field");
		} else {
			System.out.println("Fail:" + objName + " element not displayed");
		}
	}

	public static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			System.out.println("Pass:" + objName + " element cleared");
		} else {
			System.out.println("Fail:" + objName + " element not cleared");
		}
	}

	public static void clickButton(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			System.out.println("Click-pass: " + objName + " field");
		} else {
			System.out.println("Click-Fail:" + objName + " element not displayed");
		}
	}

	public static void waitElement(WebElement element, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("Wait element for :" + objName);
	}

	public static void WaitDriver() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
	}

	public static void popupclose() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tryLexDialogX")));
		WebElement pop_up = driver.findElement(By.id("tryLexDialogX"));
		clickButton(pop_up, "pop_up");
		System.out.println("Popup windown is closed");
	}

	public static void saveButtonClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("save")));
		WebElement save_button = driver.findElement(By.name("save"));
		clickButton(save_button, "save_button");
	}

	public static void cancelButtonClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cancel")));
		WebElement cancel_button = driver.findElement(By.name("cancel"));
		clickButton(cancel_button, "cancel_button");
	}

	public static void alertAccept() {
		System.out.println("The Alert is accepetd");
		driver.switchTo().alert().accept();
	}

	public static void clickMergeAccount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Merge Accounts")));
		WebElement mergeAccount_button = driver.findElement(By.linkText("Merge Accounts"));
		clickButton(mergeAccount_button, "mergeAccount_button");
	}

	public static void findAccount() throws IOException {
		// Enter the account name to be found in input
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("srch")));
		WebElement enter_accountname = driver.findElement(By.id("srch"));
		enterText(enter_accountname, readPropertyData("enter_accountname"), "enter_accountname");
		// click on find button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("srchbutton")));
		WebElement find_account = driver.findElement(By.name("srchbutton"));
		clickButton(find_account, "find_account");
	}

	public static void SelectAccountNext() {
		// select the account that you want to merge
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cid2")));
		WebElement click_third_checkbox = driver.findElement(By.id("cid2"));
		clickButton(click_third_checkbox, "click_Second_checkbox");
		// click on next button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("goNext")));
		WebElement next_button = driver.findElement(By.name("goNext"));
		clickButton(next_button, "next_button");

	}

	public static WebElement findByVisibility(By locator, String objName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("Found Element by Visibility:" + objName);
		return driver.findElement(locator);
	}

	public static void actionMovetoElement(WebElement element, String objName) {
		Actions moveto_objName = new Actions(driver);
		moveto_objName.moveToElement(element).perform();
		System.out.println("Mouse moved to element :" + objName);

	}

	public static void lastActivity_30days() {
		By lastActivity_30Days_locator = By.linkText("Accounts with last activity > 30 days");
		WebElement lastActivity_30Days = findByVisibility(lastActivity_30Days_locator, "lastActivity_30Days_locator");
		clickButton(lastActivity_30Days, "lastActivity_30Days");
	}

	public static void selectCreateDate() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen20")));
		WebElement date_field = driver.findElement(By.id("ext-gen20"));
		clickButton(date_field, "date_field");

		// wait.until(ExpectedConditions.elementToBeClickable(By.id("ext-gen249")));
		// WebElement date_field_dropdown = driver.findElement(By.id("ext-gen249"));
		// Actions date_field_dropdown_action = new Actions(driver);
		// date_field_dropdown_action.moveToElement(date_field_dropdown).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[15]/div/div[3]")));
		WebElement created_date = driver.findElement(By.xpath("//div[15]/div/div[3]"));
		clickButton(created_date, "created_date");
	}

	public static void selectFromDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen152")));
		WebElement fromDate_field = driver.findElement(By.id("ext-gen152"));

		clickButton(fromDate_field, "fromDate_field");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen281")));
		WebElement fromDate_today = driver.findElement(By.id("ext-gen281"));
		actionMovetoElement(fromDate_today, "fromDate_today");
		clickButton(fromDate_today, "fromDate_today");
	}

	public static void selectTodate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen154")));
		WebElement toDate_field = driver.findElement(By.id("ext-gen154"));
		actionMovetoElement(toDate_field, "toDate_field");
		clickButton(toDate_field, "toDate_field");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@id='ext-comp-1114']/tbody/tr[2]/td[2]/em/button")));
		WebElement toDate_today = driver
				.findElement(By.xpath("//table[@id='ext-comp-1114']/tbody/tr[2]/td[2]/em/button"));
		actionMovetoElement(toDate_today, "toDate_today");
		clickButton(toDate_today, "toDate_today");

	}

	public static void clickSave() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen49")));
		WebElement save_report = driver.findElement(By.id("ext-gen49"));
		clickButton(save_report, "save_report");
	}

	public static void saveRun() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveReportDlg_reportNameField")));
		WebElement enter_reportName = driver.findElement(By.id("saveReportDlg_reportNameField"));
		enterText(enter_reportName, readPropertyData("enter_reportName"), "enter_reportName");
		enter_reportName.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//table[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]/em/button")));
		WebElement run_save_report = driver
				.findElement(By.xpath("//table[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]/em/button"));
		clickButton(run_save_report, "run_save_report");
	}

	public static void opportunitiesTabClick() {
		By Opportunities_locator = By.linkText("Opportunities");
		WebElement Opportunities_tab = findByVisibility(Opportunities_locator, "Opportunities_locator");
		clickButton(Opportunities_tab, "Opportunities_tab");
	}
	/*
	 * public static void opportunitiesDropDownOptions() { By
	 * Opportunities_dropdown_locator = By.id("fcf"); WebElement
	 * Opportunities_dropdown_click =
	 * findByVisibility(Opportunities_dropdown_locator,
	 * "Opportunities_dropdown_locator"); clickButton(Opportunities_dropdown_click,
	 * "Opportunities_dropdown_click"); Select Opportunities_dropdown_select = new
	 * Select(Opportunities_dropdown_click); List <WebElement>
	 * Opportunities_dropdown_option = Opportunities_dropdown_select.getOptions();
	 * 
	 * System.out.println("Below option available in the dropdown opportunities");
	 * for (WebElement e:Opportunities_dropdown_option) {
	 * 
	 * System.out.println(e.getText()); } }
	 */

	public static void newButtonClick() {
		By new_button_locator = By.xpath("//input[@name='new']");
		WebElement new_button = findByVisibility(new_button_locator, "new_button_locator");
		clickButton(new_button, "new_button");
	}

	public static void switchWindow() throws InterruptedException {
		// System.out.println("Switch to new window");
		String baseWindownHandle = driver.getWindowHandle();
		Set<String> allWindownHandle = driver.getWindowHandles();
		System.out.println("Number of windows found: " + allWindownHandle.size());
		System.out.println("Before switching " + driver.getCurrentUrl());
		for (String handle : allWindownHandle) {
			if (!baseWindownHandle.equals(handle)) {
				driver.switchTo().window(handle);
				Thread.sleep(3000);
				System.out.println("Switch to new window2 " + driver.getCurrentUrl());
				break;

			}
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

	public static void dropDownOptions(String value) {
		By dropdown_locator = By.id("fcf");
		WebElement dropdown_click = findByVisibility(dropdown_locator, "dropdown_locator");
		clickButton(dropdown_click, "dropdown_click");
		Select dropdown_select = new Select(dropdown_click);
		List<WebElement> dropdown_option = dropdown_select.getOptions();

		System.out.println("Below option available in the dropdown " + value);
		for (WebElement e : dropdown_option) {

			System.out.println(e.getText());
		}
	}

	public static void contactTabClick() {
		By contcat_locator = By.linkText("Contacts");
		WebElement contcat_tab = findByVisibility(contcat_locator, "contcat_locator");
		clickButton(contcat_tab, "contcat_tab");
	}

	public static void selectElelmentByVisibleText(WebElement element, String value) {
		Select element_select = new Select(element);
		element_select.selectByVisibleText(value);
		System.out.println(value + " selected from dropdown");
	}

	public static void validateDropdown() {
		By dropdowncheck_locator = By.id("fcf");
		WebElement dropdowncheck = findByVisibility(dropdowncheck_locator, "dropdowncheck_locator");
		Select dropdowncheck_select = new Select(dropdowncheck);
		WebElement option = dropdowncheck_select.getFirstSelectedOption();
		System.out.println("display First Selected option is  " + option.getText());
	}

	public static void validateTitle(String expected, String actual) {
		if (expected.equals(actual)) {
			System.out.println("validation by title PASSED :: \"" + expected + "\" and actual is \"" + actual + "\"");
		} else {
			System.out.println("validation by title FAILED :: \"" + expected + "\" and actual is \"" + actual + "\"");
			// System.out.println("The last character in expected is " +
			// (int)expected.charAt(expected.length()-1));
			// System.out.println("The last character in actual is " +
			// (int)actual.charAt(actual.length()-1));
		}
	}

	public static void homeTabClick() {
		By home_locator = By.id("home_Tab");
		WebElement home_tab = findByVisibility(home_locator, "home_locator");
		clickButton(home_tab, "home_tab");
	}

	public static void getIframe(final WebDriver driver) {
		// Assume driver is initialized properly.
		List<WebElement> ele = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in a page :" + ele.size());
		for (WebElement el : ele) {
			// Returns the Id of a frame.
			System.out.println("Frame Id :" + el.getAttribute("id"));
			// Returns the Name of a frame.
			System.out.println("Frame name :" + el.getAttribute("name"));
		}
	}

	public static void dateChecker(WebElement enddate1) {
		Calendar calculate = Calendar.getInstance();
		calculate.add(Calendar.DATE, 14);
		Date futuredate = calculate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		String stringFutureDate = sdf.format(futuredate);
		System.out.println("Current Date = " + stringFutureDate);
		String[] SplitFuturedate = stringFutureDate.split("/");
		String futuredate1 = SplitFuturedate[0];
		String futureMonth = SplitFuturedate[1];
		String futureYear = SplitFuturedate[2];

		/*By calendarMonth_locator = By.id("calMonthPicker");
		WebElement monthView = findByVisibility(calendarMonth_locator, "calendarMonth_locator");
		Select element_select = new Select(monthView);
		element_select.selectByVisibleText(futureMonth);*/
		
		By calendarMonth_locator = By.id("calMonthPicker");
		WebElement monthView = findByVisibility(calendarMonth_locator, "calendarMonth_locator");
		selectElelmentByVisibleText(monthView, futureMonth);
		
		By calendarYear_locator = By.id("calYearPicker");
		WebElement yearView = findByVisibility(calendarYear_locator, "calendarYear_locator");
		selectElelmentByVisibleText(yearView, futureYear);
		
		WebElement calendar = findByVisibility(By.xpath("//*[@id=\"datePickerCalendar\"]"), "calemdar");
		List<WebElement> rows = calendar.findElements(By.tagName("tr"));
		for (WebElement row: rows) {
		    List<WebElement> cells = row.findElements(By.tagName("td"));
		    for (WebElement cell: cells) {
		    	//System.out.println("Cell data is " + cell.getText());
		        if(cell.getText().equals(futuredate1)) {
		        	cell.click();
		        	break;
		        }
		    }
		}
	}

}
