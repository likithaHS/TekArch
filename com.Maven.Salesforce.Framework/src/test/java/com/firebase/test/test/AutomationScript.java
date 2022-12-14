package com.firebase.test.test;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.firebase.test.base.BaseTest;
import com.firebase.test.utility.CommonUtilities;
import java.io.File;

@Listeners(com.firebase.test.utility.ListenerClass.class)
public class AutomationScript extends BaseTest {

	@Test

	public static void errorMessage01() {
		// logger.info("test case-errorMessage01");
		report.logTestInfo("test case-errorMessage01");
		defineWait();
		loginWithoutPassword();
		//String actual = "Please enter your password.";
		String actual = "Please enter your";
		By errorMessage_locator = By.id("error");
		WebElement errorMessage = findByVisibility(errorMessage_locator, "errorMessage_locator");
		String expected = errorMessage.getText();
		Assert.assertEquals(actual, expected);
		
	/*	By content_locator = By.id("content");
		WebElement content = findByVisibility(content_locator, "content_locator");
		String screenshortpath = getscreenshort(content);
		// System.out.println("Does file exist?" + new File(screenshortpath).isFile());
		report.logScreenshotCapture(screenshortpath, "errorMessage");*/
	}

	@Test
	public static void loginSalesForce2() {
		// logger.info("Testcase-loginSalesForce2");
		report.logTestInfo("Testcase-loginSalesForce2");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);

	}

	@Test
	public static void loginSalesForce3() {
		// logger.info("Testcase-loginSalesForce3");
		report.logTestInfo("Testcase-loginSalesForce3");

		defineWait();
		CommonUtilities cu = new CommonUtilities();
		Properties applicationPropertiesFile = cu.loadFile("applicationProperties");

		By username_locator = By.id("username");
		WebElement username = findByVisibility(username_locator, "username_locator");
		enterText(username, cu.getApplicationProperty("vaild_username", applicationPropertiesFile), "vaild-uname");
		By password_locator = By.id("password");
		WebElement password = findByVisibility(password_locator, "password_locator");
		enterText(password, cu.getApplicationProperty("valid_Password", applicationPropertiesFile), "valid_Password");

		By reminder_locator = By.id("rememberUn");
		WebElement reminder = findByVisibility(reminder_locator, "reminder_locator");
		clickButton(reminder, "reminder-button");

		By login_locator = By.id("Login");
		WebElement loginbutton = findByClickable(login_locator, "login_locator");
		clickButton(loginbutton, "login-button");

		By usermenu_locator = By.id("userNavLabel");
		WebElement usermenu_drpdown = findByClickable(usermenu_locator, "usermenu_locator");
		clickButton(usermenu_drpdown, "usermenu_drpdown");
		String actual = driver.getTitle();
		String expected = "Home Page ~ Salesforce - Developer Edition";
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce3");
		}
		Assert.assertEquals(actual, expected);
		salesforceLogout();
		By reminder_locator1 = By.id("rememberUn");
		WebElement reminder1 = findByVisibility(reminder_locator1, "reminder_locator1");
		verifyisSelected(reminder1, "reminder1");
	}

	@Test
	public static void loginSalesForce4b() {
		// logger.info("Testcase-loginSalesForce4b");
		report.logTestInfo("Testcase-loginSalesForce4b");
		defineWait();
		CommonUtilities cu = new CommonUtilities();
		Properties applicationPropertiesFile = cu.loadFile("applicationProperties");

		By username_locator = By.id("username");
		WebElement username = findByVisibility(username_locator, "username_locator");
		enterText(username, cu.getApplicationProperty("invaild_username", applicationPropertiesFile), "invaild-uname");

		By password_locator = By.id("password");
		WebElement password = findByVisibility(password_locator, "password_locator");
		enterText(password, cu.getApplicationProperty("invalid_Password", applicationPropertiesFile),
				"invalid_Password");

		By login_locator = By.id("Login");
		WebElement loginbutton = findByClickable(login_locator, "login_locator");
		clickButton(loginbutton, "login-button");

		String actual = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		By errorMessage_locator = By.id("error");
		WebElement errorMessage = findByVisibility(errorMessage_locator, "errorMessage_locator");
		String expected = errorMessage.getText();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce4b");
		}
		Assert.assertEquals(actual, expected);
	}

	@Test
	public static void loginSalesForce4a() {

		// logger.info("Testcase-loginSalesForce4a");
		report.logTestInfo("Testcase-loginSalesForce4a");
		defineWait();
		CommonUtilities cu = new CommonUtilities();
		Properties applicationPropertiesFile = cu.loadFile("applicationProperties");
		By forgotpwd_locator = By.id("forgot_password_link");
		WebElement forgotpwd = findByVisibility(forgotpwd_locator, "forgotpwd_locator");
		clickButton(forgotpwd, "forgotpwd-button");

		By username_locator = By.id("un");
		WebElement username = findByVisibility(username_locator, "username_locator");
		enterText(username, cu.getApplicationProperty("vaild_username", applicationPropertiesFile), "vaild-uname");

		By continue_locator = By.id("continue");
		WebElement continue1 = findByVisibility(continue_locator, "continue_locator");
		clickButton(continue1, "continue1-button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Return to Login")));

		String actual = "Check Your Email | Salesforce";
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce4a");
		}
		Assert.assertEquals(actual, expected);
	}

	@Test

	public static void userMenuTC05() {
		report.logTestInfo("userMenuTC05");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		UserMenuClick();
		By profile_locator = By.linkText("My Profile");
		WebElement profile = findByVisibility(profile_locator, "profile_locator");
		verifyisDisplayed(profile, "profile");
		By mysetting_locator = By.linkText("My Settings");
		WebElement mysetting = findByVisibility(mysetting_locator, "mysetting_locator");
		verifyisDisplayed(mysetting, "mysetting");
		By developer_locator = By.linkText("Developer Console");
		WebElement developer = findByVisibility(developer_locator, "developer_locator");
		verifyisDisplayed(developer, "developer");
		By switchtoLigthing_locator = By.linkText("Switch to Lightning Experience");
		WebElement switchtoLighting = findByVisibility(switchtoLigthing_locator, "switchtoLigthing_locator");
		verifyisDisplayed(switchtoLighting, "switchtoLighting");
		By logout_locator = By.linkText("Logout");
		WebElement logout = findByVisibility(logout_locator, "logout_locator");
		verifyisDisplayed(logout, "logout");

	}

	@Test
	public static void userMenuTC06() {
		report.logTestInfo("userMenuTC06");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		UserMenuClick();
		// my profile
		By profile_locator = By.linkText("My Profile");
		WebElement profile = findByVisibility(profile_locator, "profile_locator");
		clickButton(profile, "profile");

		// edit profile
		By editprofile_locator = By.xpath("//a[@class='contactInfoLaunch editLink']");
		WebElement editprofile = findByVisibility(editprofile_locator, "editprofile_locator");
		clickButton(editprofile, "editprofile");
		driver.switchTo().frame("contactInfoContentId");
		By about_locator = By.linkText("About");
		WebElement aboutClick = findByVisibility(about_locator, "about_locator");
		clickButton(aboutClick, "aboutClick");
		By lastname_locator = By.id("lastName");
		WebElement lastnameClick = findByVisibility(lastname_locator, "lastname_locator");
		enterText(lastnameClick, cud.getApplicationProperty("last_name", applicationdataFile), "lastnameClick");
		By saveall_locator = By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]");
		WebElement saveallClick = findByVisibility(saveall_locator, "saveall_locator");
		clickButton(saveallClick, "saveallClick");
		switchToDefault();

		// post link
		By postlink_locator = By.xpath("//*[@id=\"publisherAttachTextPost\"]");
		WebElement postlinkclick = findByVisibility(postlink_locator, "postlink_locator");
		clickButton(postlinkclick, "postlinkclick");
		By postframe_locator = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
		WebElement postframe = findByVisibility(postframe_locator, "postframe_locator");
		driver.switchTo().frame(postframe);
		By posttext_locator = By.xpath("//html/body");
		WebElement posttext = findByVisibility(posttext_locator, "posttext_locator");
		clickButton(posttext, "posttext");
		enterText(posttext, cud.getApplicationProperty("last_name", applicationdataFile), "posttext");
		switchToDefault();
		shareButtonClick();

		// file upload
		sleep(3);
		By fileupload_locator = By.xpath("//*[@id=\"publisherAttachContentPost\"]");
		WebElement fileupload = findByVisibility(fileupload_locator, "fileupload_locator");
		clickButton(fileupload, "fileupload");
		By uploadbutton_locator = By.id("chatterUploadFileAction");
		WebElement uploadbutton = findByVisibility(uploadbutton_locator, "uploadbutton_locator");
		clickButton(uploadbutton, "uploadbutton");
		By browse_locator = By.xpath("//*[@id=\"chatterFile\"]");
		WebElement browsebutton = findByVisibility(browse_locator, "browse_locator");
		browseText(browsebutton, cud.getApplicationProperty("file_upload", applicationdataFile), "browsebutton");
		shareButtonClick();

		// photo upload
		sleep(5);
		By photo_locator = By.id("photoSection");
		WebElement photo = findByVisibility(photo_locator, "photo_locator");
		actionMovetoElement(photo, "photo");
		By update_locator = By.linkText("Update");
		WebElement update = findByVisibility(update_locator, "update_locator");
		clickButton(update, "update");
		driver.switchTo().frame("uploadPhotoContentId");
		By photobrowse_locator = By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]");
		WebElement photobrowse = findByVisibility(photobrowse_locator, "photobrowse_locator");
		browseText(photobrowse, cud.getApplicationProperty("photo_upload", applicationdataFile), "photo_upload");
		By photosave_locator = By.name("j_id0:uploadFileForm:uploadBtn");
		WebElement photosave = findByVisibility(photosave_locator, "photosave_locator");
		clickButton(photosave, "photosave");
		By photosave1_locator = By.name("j_id0:j_id7:save");
		WebElement photosave1 = findByVisibility(photosave1_locator, "photosave1_locator");
		clickButton(photosave1, "photosave1");
		//switchToDefault();
		
		/*By screenshot_locator = By.className(" noSidebarCell");
		WebElement screenshot = findByVisibility(screenshot_locator, "screenshot_locator");
		
		String screenshortpath = getscreenshort(photosave);
		// System.out.println("Does file exist?" + new File(screenshortpath).isFile());
		report.logScreenshotCapture(screenshortpath, "photosave");*/

	}

	@Test
	public static void userMenuTC07() {
		report.logTestInfo("userMenuTC07");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		UserMenuClick();
		// my Setting
		By mysetting_locator = By.linkText("My Settings");
		WebElement mysetting = findByVisibility(mysetting_locator, "mysetting_locator");
		clickButton(mysetting, "mysetting");
		// login history
		By personal_locator = By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']");
		WebElement personal = findByVisibility(personal_locator, "personal_locator");
		clickButton(personal, "personal");

		By loginHistory_locator = By.id("LoginHistory_font");
		WebElement login_history = findByVisibility(loginHistory_locator, "loginHistory_locator");
		clickButton(login_history, "login_history");

		By historydownload_locator = By
				.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a");
		WebElement history_download = findByVisibility(historydownload_locator, "historydownload_locator");
		clickButton(history_download, "history_download");

		// Display and layout
		By displaylayout_locator = By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[3]/a");
		WebElement display_layout = findByVisibility(displaylayout_locator, "displaylayout_locator");
		clickButton(display_layout, "display_layout");
		By customize_locator = By.id("CustomizeTabs_font");
		WebElement customize = findByVisibility(customize_locator, "customize_locator");
		clickButton(customize, "customize");
		By custom_app_locator = By.id("p4");
		WebElement custom_app = findByVisibility(custom_app_locator, "custom_app_locator");
		selectElelmentByVisibleText(custom_app, "Salesforce Chatter");

		By availabletab_locator = By.id("duel_select_0");
		WebElement available_tab = findByVisibility(availabletab_locator, "availabletab_locator");
		selectElelmentByVisibleText(available_tab, "Reports");

		By addbutton_locator = By.id("duel_select_0_right");
		WebElement add_button = findByVisibility(addbutton_locator, "addbutton_locator");
		clickButton(add_button, "add_button");

		saveButtonClick();

		// email
		By email_locator = By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[4]/a");
		WebElement email = findByVisibility(email_locator, "email_locator");
		clickButton(email, "email");

		By emailsetting_locator = By.id("EmailSettings_font");
		WebElement email_setting = findByVisibility(emailsetting_locator, "emailsetting_locator");
		clickButton(email_setting, "email_setting");

		By emailname_locator = By.id("sender_name");
		WebElement email_name = findByVisibility(emailname_locator, "emailname_locator");
		enterText(email_name, cud.getApplicationProperty("sender_name", applicationdataFile), "email_name");

		By emailemail_locator = By.id("sender_email");
		WebElement email_email = findByVisibility(emailemail_locator, "emailemail_locator");
		enterText(email_email, cud.getApplicationProperty("email_email", applicationdataFile), "email_email");
		By radiobutton_locator = By.name("auto_bcc");
		selectRadiobutton(radiobutton_locator, "radiobutton", 0);

		saveButtonClick();

		// Calendar reminder
		By calenderReminder_locator = By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[6]/a");
		WebElement calender_reminder = findByVisibility(calenderReminder_locator, "calenderReminder_locator");
		clickButton(calender_reminder, "calender_reminder");

		By activityReminder_locator = By.id("Reminders_font");
		WebElement activity_reminder = findByVisibility(activityReminder_locator, "activityReminder_locator");
		clickButton(activity_reminder, "activity_reminder");

		By testReminder_locator = By.id("testbtn");
		WebElement test_reminder = findByVisibility(testReminder_locator, "testReminder_locator");
		clickButton(test_reminder, "test_reminder");
		sleep(3);
		switchWindow();
	}

	@Test

	public static void userMenuTC08() {
		report.logTestInfo("userMenuTC08");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		UserMenuClick();
		// Developer Console
		By developer_locator = By.linkText("Developer Console");
		WebElement developer_console = findByVisibility(developer_locator, "developer_locator");
		clickButton(developer_console, "developer_console");
		switchWindow();
	}

	@Test

	public static void userMenuTC09() {
		report.logTestInfo("userMenuTC09");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		UserMenuClick();
		// logoff
		salesforceLogout();
		String actual_logout = "Login | Salesforce";
		By login_locator = By.id("Login");
		WaitByLocator(login_locator);
		String expected_logout = driver.getTitle();
		if (!actual_logout.equals(expected_logout)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual_logout, expected_logout);

	}

	@Test
	public static void userMenuTC10() {
		report.logTestInfo("userMenuTC10");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		// account tab
		accountTabClick();
		popupclose();
		String actual_account = "Accounts: Home ~ Salesforce - Developer Edition";
		String expected_account = driver.getTitle();
		if (!actual_account.equals(expected_account)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual_account, expected_account);

		// new account
		newButtonClick();

		By accountname_locator = By.id("acc2");
		WebElement account_name = findByVisibility(accountname_locator, "accountname_locator");
		enterText(account_name, cud.getApplicationProperty("account_name", applicationdataFile), "account_name");

		By accounttype_locator = By.id("acc6");
		WebElement account_type = findByVisibility(accounttype_locator, "accounttype_locator");
		selectElelmentByVisibleText(account_type, "Technology Partner");

		By customerprority_locator = By.id("00N4x00000WQnk7");
		WebElement customer_prority = findByVisibility(customerprority_locator, "customerprority_locator");
		selectElelmentByVisibleText(customer_prority, "High");

		saveButtonClick();

	}

	@Test
	public static void userMenuTC11() {
		report.logTestInfo("userMenuTC11");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		// account tab
		accountTabClick();

		popupclose();

		// create new view
		By createNewView_locator = By.linkText("Create New View");
		WebElement createNewView_click = findByVisibility(createNewView_locator, "createNewView_locator");
		clickButton(createNewView_click, "createNewView_click");

		By viewName_locator = By.id("fname");
		WebElement viewName_enter = findByVisibility(viewName_locator, "viewName_locator");
		enterText(viewName_enter, cud.getApplicationProperty("viewName_enter", applicationdataFile), "viewName_enter");
		clickonTabkey(viewName_enter);

		saveButtonClick();

	}

	@Test

	public static void userMenuTC12() {
		report.logTestInfo("userMenuTC12");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		// account tab
		accountTabClick();

		popupclose();

		// edit the view
		By viewdropdown_locator = By.id("fcf");
		WebElement View_dropdown = findByVisibility(viewdropdown_locator, "viewdropdown_locator");
		selectElelmentByVisibleText(View_dropdown, "NewViewCreate");

		By editview_locator = By.linkText("Edit");
		WebElement edit_viewName = findByVisibility(editview_locator, "editview_locator");
		clickButton(edit_viewName, "edit_viewName");

		By viewName_locator = By.id("fname");
		WebElement viewName_enter = findByVisibility(viewName_locator, "viewName_locator");
		enterText(viewName_enter, cud.getApplicationProperty("update_viewName_enter", applicationdataFile),
				"viewName_enter");
		clickonTabkey(viewName_enter);

		By filterfield_locator = By.id("fcol1");
		WebElement filter_field = findByVisibility(filterfield_locator, "filterfield_locator");
		selectElelmentByVisibleText(filter_field, "Account Name");

		By filteroperator_locator = By.id("fop1");
		WebElement filter_operator = findByVisibility(filteroperator_locator, "filteroperator_locator");
		selectElelmentByVisibleText(filter_operator, "contains");

		By filtervalue_locator = By.id("fval1");
		WebElement filter_value = findByVisibility(filtervalue_locator, "filtervalue_locator");
		enterText(filter_value, cud.getApplicationProperty("filter_value", applicationdataFile), "filter_value");

		By displaycolumn_locator = By.id("colselector_select_0");
		WebElement display_column = findByVisibility(displaycolumn_locator, "displaycolumn_locator");
		selectElelmentByVisibleText(display_column, "Last Activity");

		By addbutton_locator = By.id("colselector_select_0_right");
		WebElement add_button = findByVisibility(addbutton_locator, "addbutton_locator");
		clickButton(add_button, "add_button");

		saveButtonClick();

	}

	@Test
	public static void userMenuTC13() {
		report.logTestInfo("userMenuTC13");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		// account tab
		accountTabClick();
		popupclose();
		// clickon merge account link
		By mergeaccount_locator = By.linkText("Merge Accounts");
		WebElement mergeAccount_button = findByVisibility(mergeaccount_locator, "mergeaccount_locator");
		clickButton(mergeAccount_button, "mergeAccount_button");
		// Enter the account name to be found in input
		By accountname_locator = By.id("srch");
		WebElement enter_accountname = findByVisibility(accountname_locator, "accountname_locator");
		enterText(enter_accountname, cud.getApplicationProperty("enter_accountname", applicationdataFile),
				"enter_accountname");
		// click on find button
		By findaccount_locator = By.name("srchbutton");
		WebElement find_account = findByVisibility(findaccount_locator, "findaccount_locator");
		clickButton(find_account, "find_account");
		// select the account that you want to merge
		By clickthirdcheckbox_locator = By.id("cid2");
		WebElement click_third_checkbox = findByVisibility(clickthirdcheckbox_locator, "clickthirdcheckbox_locator");
		clickButton(click_third_checkbox, "click_Second_checkbox");
		// click on next button
		By nextbutton_locator = By.name("goNext");
		WebElement next_button = findByVisibility(nextbutton_locator, "nextbutton_locator");
		clickButton(next_button, "next_button");

		saveButtonClick();
		alertAccept();
	}

	@Test

	public static void userMenuTC14() {
		report.logTestInfo("userMenuTC14");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		// account tab
		accountTabClick();
		popupclose();

		By lastActivity_30Days_locator = By.linkText("Accounts with last activity > 30 days");
		WebElement lastActivity_30Days = findByVisibility(lastActivity_30Days_locator, "lastActivity_30Days_locator");
		clickButton(lastActivity_30Days, "lastActivity_30Days");

		By dateField_locator = By.id("ext-gen20");
		WebElement date_field = findByVisibility(dateField_locator, "dateField_locator");
		clickButton(date_field, "date_field");

		By createdate_locator = By.xpath("//div[15]/div/div[3]");
		WebElement created_date = findByVisibility(createdate_locator, "createdate_locator");
		clickButton(created_date, "created_date");

		By fromdate_locator = By.id("ext-gen152");
		WebElement fromDate_field = findByVisibility(fromdate_locator, "fromdate_locator");
		clickButton(fromDate_field, "fromDate_field");

		By fromdatetoday_locator = By.id("ext-gen281");
		WebElement fromDate_today = findByVisibility(fromdatetoday_locator, "fromdatetoday_locator");
		actionMovetoElement(fromDate_today, "fromDate_today");
		clickButton(fromDate_today, "fromDate_today");

		By todate_locator = By.id("ext-gen154");
		WebElement toDate_field = findByVisibility(todate_locator, "todate_locator");
		actionMovetoElement(toDate_field, "toDate_field");
		clickButton(toDate_field, "toDate_field");

		By todatetoday_locator = By.xpath("//table[@id='ext-comp-1114']/tbody/tr[2]/td[2]/em/button");
		WebElement toDate_today = findByVisibility(todatetoday_locator, "todatetoday_locator");
		actionMovetoElement(toDate_today, "toDate_today");
		clickButton(toDate_today, "toDate_today");

		By savereport_locator = By.id("ext-gen49");
		WebElement save_report = findByVisibility(savereport_locator, "savereport_locator");
		clickButton(save_report, "save_report");

		By enterReportName_locator = By.id("saveReportDlg_reportNameField");
		WebElement enter_reportName = findByVisibility(enterReportName_locator, "enterReportName_locator");
		enterText(enter_reportName, cud.getApplicationProperty("enter_reportName", applicationdataFile),
				"enter_reportName");
		clickonTabkey(enter_reportName);
		sleep(2);

		By saveRunReport_locator = By.xpath("//table[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]/em/button");
		WebElement run_save_report = findByVisibility(saveRunReport_locator, "saveRunReport_locator");
		clickButton(run_save_report, "run_save_report");
	}

	@Test

	public static void createOpty15() {
		report.logTestInfo("createOpty15");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		opportunitiesTabClick();
		popupclose();
		dropDownOptions("opportunities");
	}

	@Test
	public static void createOpty16() {
		report.logTestInfo("createOpty16");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual, expected);
		opportunitiesTabClick();
		popupclose();
		newButtonClick();

		By opportunities_name_locator = By.id("opp3");
		WebElement opportunities_name = findByVisibility(opportunities_name_locator, "opportunities_name_locator");
		enterText(opportunities_name, cud.getApplicationProperty("opportunities_name", applicationdataFile),
				"opportunities_name");

		By accountname_locator = By.id("opp4");
		WebElement accountname = findByVisibility(accountname_locator, "accountname_locator");
		enterText(accountname, cud.getApplicationProperty("enter_accountname", applicationdataFile),
				"opportunities_name");

		By leadsource_locator = By.id("opp6");
		WebElement leadsource = findByVisibility(leadsource_locator, "leadsource_locator");
		selectElelmentByVisibleText(leadsource, "Phone Inquiry");

		By closedate_locator = By.xpath(
				"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a");
		WebElement closedate = findByVisibility(closedate_locator, "closedate_locator");
		clickButton(closedate, "closedate");

		By stage_locator = By.id("opp11");
		WebElement stage = findByVisibility(stage_locator, "stage_locator");
		selectElelmentByVisibleText(stage, "Prospecting");

		By probability_locator = By.id("opp12");
		WebElement probability = findByVisibility(probability_locator, "probability_locator");
		enterText(probability, cud.getApplicationProperty("probability", applicationdataFile), "probability");

		saveButtonClick();

	}

	@Test

	public static void createOpty17() {
		report.logTestInfo("createOpty17");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}

		Assert.assertEquals(actual, expected);
		opportunitiesTabClick();
		popupclose();

		By opipeline_locator = By.linkText("Opportunity Pipeline");
		WebElement opipeline = findByVisibility(opipeline_locator, "opipeline_locator");
		clickButton(opipeline, "opipeline");

		String actual_optpipeline = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		String expected_optpipeline = driver.getTitle();
		if (!actual_optpipeline.equals(expected_optpipeline)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual_optpipeline, expected_optpipeline);

	}

	@Test

	public static void createOpty18() {
		report.logTestInfo("createOpty18");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}

		Assert.assertEquals(actual, expected);
		opportunitiesTabClick();
		popupclose();

		By ostuck_locator = By.linkText("Stuck Opportunities");
		WebElement ostuck = findByVisibility(ostuck_locator, "ostuck_locator");
		clickButton(ostuck, "ostuck");

		String actual_optstuck = "Stuck Opportunities ~ Salesforce - Developer Edition";
		String expected_optstuck = driver.getTitle();
		if (!actual_optstuck.equals(expected_optstuck)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}
		Assert.assertEquals(actual_optstuck, expected_optstuck);

	}

	@Test

	public static void createOpty19() {
		report.logTestInfo("createOpty19");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC loginSalesForce2");
		}

		Assert.assertEquals(actual, expected);
		opportunitiesTabClick();
		popupclose();
		By newbutton_locator = By.xpath("//input[@name='new']");
		By datefield_locator = By.id("quarter_c");

		WaitByLocator(newbutton_locator);
		selectInterval("Current FQ");
		selectInclude("All Opportunities");
		runReport();
		WaitByLocator(datefield_locator);
		driver.navigate().back();

		WaitByLocator(newbutton_locator);
		selectInterval("Next FQ");
		selectInclude("Closed Opportunities");
		runReport();
		WaitByLocator(datefield_locator);
		driver.navigate().back();

		WaitByLocator(newbutton_locator);
		selectInterval("Next FQ");
		selectInclude("All Opportunities");
		runReport();
		WaitByLocator(datefield_locator);
		driver.navigate().back();

		WaitByLocator(newbutton_locator);
		selectInterval("Current FQ");
		selectInclude("Closed Opportunities");
		runReport();

	}

	@Test
	public static void leads20() {
		report.logTestInfo("leads20");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC leads20 after login");
		}
		Assert.assertEquals(actual, expected);

		leadTabClick();
		popupclose();
		String actual_lead = "Leads: Home ~ Salesforce - Developer Edition";
		String expected_lead = driver.getTitle();
		if (!actual_lead.equals(expected_lead)) {
			report.logTestFailed("Assertion failed in TC leads20 after lead tab click");
		}
		Assert.assertEquals(actual_lead, expected_lead);
	}

	@Test
	public static void leads21() {
		report.logTestInfo("leads20");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC leads21 after login");
		}
		Assert.assertEquals(actual, expected);
		leadTabClick();
		String actual_lead = "Leads: Home ~ Salesforce - Developer Edition";
		String expected_lead = driver.getTitle();
		if (!actual_lead.equals(expected_lead)) {
			report.logTestFailed("Assertion failed in TC leads21 after lead tab click");
		}
		Assert.assertEquals(actual_lead, expected_lead);
		popupclose();
		dropDownOptions("leads");
	}

	@Test
	public static void leads22() {
		report.logTestInfo("leads22");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC leads22 after login");
		}
		Assert.assertEquals(actual, expected);
		leadTabClick();
		String actual_lead = "Leads: Home ~ Salesforce - Developer Edition";
		String expected_lead = driver.getTitle();
		if (!actual_lead.equals(expected_lead)) {
			report.logTestFailed("Assertion failed in TC leads22 after lead tab click");
		}
		Assert.assertEquals(actual_lead, expected_lead);
		popupclose();
		By dropdown_locator = By.id("fcf");
		WebElement dropdown_click = findByVisibility(dropdown_locator, "dropdown_locator");
		selectElelmentByVisibleText(dropdown_click, "Today's Leads");

		UserMenuClick();
		salesforceLogout();
		vaildLogin();
		leadTabClick();
		String expected_dropdown = "Today's Leads";
		String actual_dropdown = validateDropdown();
		if (!actual_dropdown.equals(expected_dropdown)) {
			report.logTestFailed("Assertion failed in TC leads22 dropdown for todays leads");
		}
		Assert.assertEquals(actual_dropdown, expected_dropdown);

		By goButton_locator = By.xpath("//input[@name='go' and @value=' Go! ']");
		WebElement goButton_click = findByVisibility(goButton_locator, "goButton_locator");
		clickButton(goButton_click, "goButton_click");
	}

	@Test
	public static void leads23() {
		report.logTestInfo("leads23");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC leads23 after login");
		}
		Assert.assertEquals(actual, expected);
		leadTabClick();
		String actual_lead = "Leads: Home ~ Salesforce - Developer Edition";
		String expected_lead = driver.getTitle();
		if (!actual_lead.equals(expected_lead)) {
			report.logTestFailed("Assertion failed in TC leads23 after lead tab click");
		}
		Assert.assertEquals(actual_lead, expected_lead);
		popupclose();

		By dropdown_locator = By.id("fcf");
		WebElement dropdown_click = findByVisibility(dropdown_locator, "dropdown_locator");
		selectElelmentByVisibleText(dropdown_click, "Today's Leads");

		By goButton_locator = By.xpath("//input[@name='go' and @value=' Go! ']");
		WebElement goButton_click = findByVisibility(goButton_locator, "goButton_locator");
		clickButton(goButton_click, "goButton_click");
	}

	@Test

	public static void leads24() {
		report.logTestInfo("leads24");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC leads24 after login");
		}
		Assert.assertEquals(actual, expected);
		leadTabClick();
		String actual_lead = "Leads: Home ~ Salesforce - Developer Edition";
		String expected_lead = driver.getTitle();
		if (!actual_lead.equals(expected_lead)) {
			report.logTestFailed("Assertion failed in TC leads24 after lead tab click");
		}
		Assert.assertEquals(actual_lead, expected_lead);
		popupclose();
		newButtonClick();
		By lastname_locator = By.id("name_lastlea2");
		WebElement lastname = findByVisibility(lastname_locator, "lastname_locator");
		enterText(lastname, cud.getApplicationProperty("lead_lastname", applicationdataFile), "lastname");
		By company_locator = By.id("lea3");
		WebElement company = findByVisibility(company_locator, "company_locator");
		enterText(company, cud.getApplicationProperty("lead_company", applicationdataFile), "company");
		saveButtonClick();
		String actual_leadnew = "Lead: ABCD ~ Salesforce - Developer Edition";
		String expected_leadnew = driver.getTitle();
		if (!actual_leadnew.equals(expected_leadnew)) {
			report.logTestFailed("Assertion failed in TC leads24 after lead tab click");
		}
		Assert.assertEquals(actual_leadnew, expected_leadnew);

	}

	@Test
	public static void contacts25() {
		report.logTestInfo("contacts25");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC contacts25 after login");
		}
		Assert.assertEquals(actual, expected);
		contactTabClick();
		popupclose();
		newButtonClick();
		By lastname_locator = By.id("name_lastcon2");
		WebElement lastname = findByVisibility(lastname_locator, "lastname_locator");
		enterText(lastname, cud.getApplicationProperty("contacts_name", applicationdataFile), "lastname");
		By accountname_locator = By.id("con4");
		WebElement accountname = findByVisibility(accountname_locator, "accountname_locator");
		enterText(accountname, cud.getApplicationProperty("account_name", applicationdataFile), "accountname");
		saveButtonClick();
		String actual_contact = "Contact: NewContact ~ Salesforce - Developer Edition";
		String expected_contact = driver.getTitle();
		if (!actual_contact.equals(expected_contact)) {
			report.logTestFailed("Assertion failed in TC contacts25 while creating new contact");
		}
		Assert.assertEquals(actual_contact, expected_contact);

	}

	@Test

	public static void contacts26() {
		report.logTestInfo("contacts26");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC contacts26 after login");
		}
		Assert.assertEquals(actual, expected);
		contactTabClick();
		popupclose();
		By createNewView_locator = By.linkText("Create New View");
		WebElement createNewView = findByVisibility(createNewView_locator, "createNewView_locator");
		clickButton(createNewView, "createNewView");
		By viewname_locator = By.id("fname");
		WebElement viewname = findByVisibility(viewname_locator, "viewname_locator");
		enterText(viewname, cud.getApplicationProperty("contactviewname", applicationdataFile), "viewname");
		clickonTabkey(viewname);
		saveButtonClick();
		contactTabClick();
		String actual_dropdown = "NewcontactView";
		String expected_dropdown = validateDropdown();
		if (!actual_dropdown.equals(expected_dropdown)) {
			report.logTestFailed("Assertion failed in TC contacts26 after login");
		}
		Assert.assertEquals(actual_dropdown, expected_dropdown);
	}

	@Test
	public static void contacts27() {
		report.logTestInfo("contacts27");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC contacts27 after login");
		}
		Assert.assertEquals(actual, expected);
		contactTabClick();
		popupclose();
		By recentContact_locator = By.id("hotlist_mode");
		WebElement recentContact = findByVisibility(recentContact_locator, "recentContact_locator");
		selectElelmentByVisibleText(recentContact, "Recently Created");
	}

	@Test
	public static void contacts28() {
		report.logTestInfo("contacts28");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC contacts28 after login");
		}
		Assert.assertEquals(actual, expected);
		contactTabClick();
		popupclose();
		By dropdowncheck_locator = By.id("fcf");
		WebElement dropdowncheck = findByVisibility(dropdowncheck_locator, "dropdowncheck_locator");
		selectElelmentByVisibleText(dropdowncheck, "My Contacts");
	}

	@Test
	public static void contacts29() {
		report.logTestInfo("contacts29");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC contacts29 after login");
		}
		Assert.assertEquals(actual, expected);
		contactTabClick();
		popupclose();
		By contactname_locator = By.linkText("NewContact");
		WebElement contactname = findByVisibility(contactname_locator, "contactname_locator");
		clickButton(contactname, "contactname");
		String expected_contact = "Contact: NewContact ~ Salesforce - Developer Edition";
		String actual_contact = driver.getTitle();
		if (!actual_contact.equals(expected_contact)) {
			report.logTestFailed("Assertion failed in TC contacts29 after slecting contact name");
		}
		Assert.assertEquals(actual_contact, expected_contact);

	}

	@Test
	public static void contacts30() {
		report.logTestInfo("contacts29");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC contacts29 after login");
		}
		Assert.assertEquals(actual, expected);
		contactTabClick();
		popupclose();
		By createNewView_locator = By.linkText("Create New View");
		WebElement createNewView = findByVisibility(createNewView_locator, "createNewView_locator");
		clickButton(createNewView, "createNewView");
		By viewuniquename_locator = By.id("devname");
		WebElement viewuniquename = findByVisibility(viewuniquename_locator, "viewuniquename_locator");
		enterText(viewuniquename, "EFGH", "viewuniquename");
		saveButtonClick();
		String actual_error = "Error: You must enter a value";
		By error_locator = By.xpath("//div[@class='errorMsg']");
		WebElement error = findByVisibility(error_locator, "error_locator");
		String expected_error = error.getText();
		if (!actual_error.equals(expected_error)) {
			report.logTestFailed("Assertion failed in TC contacts30 not throwing error message during save");
		}
		Assert.assertEquals(actual_error, expected_error);

	}

	@Test
	public static void contacts31() {
		report.logTestInfo("contacts31");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC contacts31 after login");
		}
		Assert.assertEquals(actual, expected);
		contactTabClick();
		popupclose();
		By createNewView_locator = By.linkText("Create New View");
		WebElement createNewView = findByVisibility(createNewView_locator, "createNewView_locator");
		clickButton(createNewView, "createNewView");
		By viewname_locator = By.id("fname");
		WebElement viewname = findByVisibility(viewname_locator, "viewname_locator");
		enterText(viewname, cud.getApplicationProperty("lead_lastname", applicationdataFile), "viewname");
		By viewuniquename_locator = By.id("devname");
		WebElement viewuniquename = findByVisibility(viewuniquename_locator, "viewuniquename_locator");
		enterText(viewuniquename, cud.getApplicationProperty("uniqueViewName", applicationdataFile), "viewuniquename");
		cancelButtonClick();
		String expected_dropdown = "ABCD";
		String actual_dropdown = validateDropdown();
		if (actual_dropdown.equals(expected_dropdown)) {
			report.logTestFailed("Assertion failed in TC contacts31 after cancel is selected in createnewview");
		}
		boolean check = actual_dropdown.equals(expected_dropdown);
		Assert.assertFalse(check);

	}

	@Test
	public static void contacts32() {
		report.logTestInfo("contacts32");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC contacts32 after login");
		}
		Assert.assertEquals(actual, expected);
		contactTabClick();
		popupclose();
		newButtonClick();
		By lastname_locator = By.id("name_lastcon2");
		WebElement lastname = findByVisibility(lastname_locator, "lastname_locator");
		enterText(lastname, cud.getApplicationProperty("contactlastname", applicationdataFile), "lastname");
		By accountname_locator = By.id("con4");
		WebElement accountname = findByVisibility(accountname_locator, "accountname_locator");
		enterText(accountname, cud.getApplicationProperty("contactaccountname", applicationdataFile), "accountname");
		By savenew_locator = By.name("save_new");
		WebElement savenew = findByVisibility(savenew_locator, "savenew_locator");
		clickButton(savenew, "savenew");
		cancelButtonClick();
		String actual_contact = "Contact: India ~ Salesforce - Developer Edition";
		String expected_contact = driver.getTitle();
		if (!actual_contact.equals(expected_contact)) {
			report.logTestFailed("Assertion failed in TC contacts32 after saving the new contact");
		}
		Assert.assertEquals(actual_contact, expected_contact);
	}

	@Test

	public static void RandomScenarios33() {
		report.logTestInfo("RandomScenarios33");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC RandomScenarios33 after login");
		}
		Assert.assertEquals(actual, expected);
		homeTabClick();
		popupclose();
		By FirstLastname_locator = By.id("mru0054x000006T6vy");
		WebElement FirstLastname_tab = findByVisibility(FirstLastname_locator, "FirstLastname_locator");
		clickButton(FirstLastname_tab, "FirstLastname_tab");

	}

	@Test
	public static void RandomScenarios34() {
		report.logTestInfo("RandomScenarios34");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC RandomScenarios34 after login");
		}
		Assert.assertEquals(actual, expected);
		homeTabClick();
		popupclose();
		By FirstLastname_locator = By.id("mru0054x000006T6vy");
		WebElement FirstLastname_tab = findByVisibility(FirstLastname_locator, "FirstLastname_locator");
		clickButton(FirstLastname_tab, "FirstLastname_tab");
		By editprofile_locator = By.xpath("//a[@class='contactInfoLaunch editLink']");
		WebElement editprofile = findByVisibility(editprofile_locator, "editprofile_locator");
		clickButton(editprofile, "editprofile");
		driver.switchTo().frame("contactInfoContentId");
		By about_locator = By.linkText("About");
		WebElement aboutClick = findByVisibility(about_locator, "about_locator");
		clickButton(aboutClick, "aboutClick");
		By firstname_locator = By.id("firstName");
		WebElement firstnameClick = findByVisibility(firstname_locator, "firstname_locator");
		clickButton(firstnameClick, "firstnameClick");
		By lastname_locator = By.id("lastName");
		WebElement lastnameClick = findByVisibility(lastname_locator, "lastname_locator");
		enterText(lastnameClick, cud.getApplicationProperty("updatelastname", applicationdataFile), "lastnameClick");
		By saveall_locator = By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]");
		WebElement saveallClick = findByVisibility(saveall_locator, "saveall_locator");
		clickButton(saveallClick, "saveallClick");
		driver.switchTo().defaultContent();
		String updateActual = "Likitha Abcd";
		By update_locator = By.id("tailBreadcrumbNode");
		WebElement updatename = findByVisibility(update_locator, "update_locator");
		String updateExpected = updatename.getText().replace('\u00A0', ' ').trim();
		if (!updateActual.equals(updateExpected)) {
			report.logTestFailed("Assertion failed in TC RandomScenarios34 first and last name");
		}
		Assert.assertEquals(updateActual, updateExpected);
		String userupdateActual = "Likitha Abcd";
		By userupdate_locator = By.id("userNavLabel");
		WebElement userupdatename = findByVisibility(userupdate_locator, "userupdate_locator");
		String userupdateExpected = userupdatename.getText();
		if (!userupdateActual.equals(userupdateExpected)) {
			report.logTestFailed("Assertion failed in TC RandomScenarios34 for usermenu name");
		}
		Assert.assertEquals(userupdateActual, userupdateExpected);
	}

	@Test

	public static void RandomScenarios35() {
		report.logTestInfo("RandomScenarios35");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC RandomScenarios35 after login");
		}
		Assert.assertEquals(actual, expected);
		By plusTab_locator = By.id("AllTab_Tab");
		WebElement plusTabClick = findByVisibility(plusTab_locator, "plusTab_locator");
		clickButton(plusTabClick, "plusTabClick");
		By customize_locator = By.xpath("//input[@name='customize' and @value='Customize My Tabs']");
		WebElement customizeClick = findByVisibility(customize_locator, "customize_locator");
		clickButton(customizeClick, "customizeClick");
		By selectedtab_locator = By.id("duel_select_1");
		WebElement selectedtab = findByVisibility(selectedtab_locator, "selectedtab_locator");
		selectElelmentByVisibleText(selectedtab, "Campaigns");
		By remove_locator = By.id("duel_select_0_left");
		WebElement remove = findByVisibility(remove_locator, "remove_locator");
		clickButton(remove, "remove");
		saveButtonClick();
		
		By tabBar_locator = By.id("tabBar");
		WebElement tabBar = findByVisibility(tabBar_locator, "tabBar_locator");
		String screenshortpath = getscreenshort(tabBar);
		report.logScreenshotCapture(screenshortpath, "tabBar");

	}

	@Test
	public static void RandomScenarios36() {
		report.logTestInfo("RandomScenarios36");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC RandomScenarios36 after login");
		}
		Assert.assertEquals(actual, expected);
		homeTabClick();
		popupclose();
		By currentdate_locator = By.xpath("//table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[2]/a");
		WebElement currentdate = findByVisibility(currentdate_locator, "currentdate_locator");
		clickButton(currentdate, "currentdate");

		By eightPM_locator = By.xpath("//table/tbody/tr[2]/td[1]/div[29]/a");
		WebElement eightPM = findByVisibility(eightPM_locator, "eightPM_locator");
		clickButton(eightPM, "eightPM");
		By combobox_locator = By.xpath("//img[@class='comboboxIcon']");
		WebElement comboBox = findByVisibility(combobox_locator, "combobox_locator");
		clickButton(comboBox, "comboBox");
		//WaitByLocator(combobox_locator);

		windowSwitchComboBox();

		By enddate_locator = By.id("EndDateTime_time");
		WebElement enddate = findByVisibility(enddate_locator, "enddate_locator");
		clickButton(enddate, "enddate");
		enterText(enddate, cud.getApplicationProperty("case36time", applicationdataFile), "EndDateTime_time");
		saveButtonClick();
		
		By calendardayview_locator = By.id("p:f:j_id25");
		WebElement dayViewCalander = findByVisibility(calendardayview_locator, "calendardayview_locator");
		String screenshortpath = getscreenshort(dayViewCalander);
		report.logScreenshotCapture(screenshortpath, "monthCalander");
	}

	@Test
	public static void RandomScenarios37() {
		report.logTestInfo("RandomScenarios37");
		CommonUtilities cud = new CommonUtilities();
		Properties applicationdataFile = cud.loadFile("applicationDataField");
		defineWait();
		vaildLogin();
		String actual = "Home Page ~ Salesforce - Developer Edition";
		By home_locator = By.linkText("Home");
		WaitByLocator(home_locator);
		String expected = driver.getTitle();
		if (!actual.equals(expected)) {
			report.logTestFailed("Assertion failed in TC RandomScenarios37 after login");
		}
		Assert.assertEquals(actual, expected);
		homeTabClick();
		popupclose();
		By currentdate_locator = By.xpath("//table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[2]/a");
		WebElement currentdate = findByVisibility(currentdate_locator, "currentdate_locator");
		clickButton(currentdate, "currentdate");

		By fourPM_locator = By.xpath("//table/tbody/tr[2]/td[1]/div[21]/a");
		WebElement fourPM = findByVisibility(fourPM_locator, "fourPM_locator");
		clickButton(fourPM, "fourPM");
		By combobox_locator = By.xpath("//img[@class='comboboxIcon']");
		WebElement comboBox = findByVisibility(combobox_locator, "combobox_locator");
		clickButton(comboBox, "comboBox");
		//WaitByLocator(combobox_locator);
		windowSwitchComboBox();

		By enddate_locator = By.id("EndDateTime_time");
		WebElement enddate = findByVisibility(enddate_locator, "enddate_locator");
		clickButton(enddate, "enddate");
		enterText(enddate, cud.getApplicationProperty("case37time", applicationdataFile), "EndDateTime_time");
		By reccurrence_locator = By.id("IsRecurrence");
		WebElement reccurrence = findByVisibility(reccurrence_locator, "reccurrence_locator");
		clickButton(reccurrence, "reccurrence");

		if (reccurrence.isSelected()) {
			By radiobutton_week = By.name("rectype");
			selectRadiobutton(radiobutton_week, "radiobutton_week", 1);

			By enddate1_locator = By.id("RecurrenceEndDateOnly");
			WebElement enddate1 = findByVisibility(enddate1_locator, "enddate1_locator");
			//enterText(enddate1, cud.getApplicationProperty("case37date", applicationdataFile), "EndDate_date");
			clickButton(enddate1, "enddate1");
			dateChecker(enddate1);
		}

		saveButtonClick();

		By monthView_locator = By.xpath("//img[@class='monthViewIcon']");
		WebElement monthView = findByVisibility(monthView_locator, "monthView_locator");
		clickButton(monthView, "monthView");
		
		
		By monthCalander_locator = By.id("bodyCell");
		WebElement monthCalander = findByVisibility(monthCalander_locator, "monthCalander_locator");
		String screenshortpath = getscreenshort(monthCalander);
		report.logScreenshotCapture(screenshortpath, "monthCalander");

	}

}
