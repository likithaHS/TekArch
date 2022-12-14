package com.Maven.Demo;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
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
import org.openqa.selenium.JavascriptExecutor;

public class FirstScript extends FirstClass {

	public static void errorMessage01(String browser) throws InterruptedException, IOException {
		System.out.println("test case-errorMessage01");

		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
        Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		clearElement(password, "vaild-password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");
		By error_locator = By.id("error");
		WebElement error_tab = findByVisibility(error_locator,"error_locator");
		String actual= error_tab.getText();
		String expected = "Please enter your password.";
		validateTitle(expected, actual);

		driver.close();

	}

	public static void loginSalesForce2(String browser) throws InterruptedException, IOException {
		System.out.println("Testcase-loginSalesForce2");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		driver.close();

	}

	public static void loginSalesForce3(String browser) throws InterruptedException, IOException {
		System.out.println("Testcase-loginSalesForce3");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rememberUn")));
		WebElement reminder = driver.findElement(By.id("rememberUn"));
		// waitElement(reminder,"reminder-button");
		clickButton(reminder, "reminder-button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavLabel")));
		WebElement drpdown = driver.findElement(By.id("userNavLabel"));
		clickButton(drpdown, "drpdown-button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		WebElement logout = driver.findElement(By.linkText("Logout"));
		clickButton(logout, "logout-button");

		Thread.sleep(2000);
		driver.close();
	}

	public static void loginSalesForce4b(String browser) throws InterruptedException, IOException {
		System.out.println("Testcase-loginSalesForce4b");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("invaild_username"), "invaild-uname");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("invalid_Password"), "invaild-password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		driver.close();
	}

	public static void loginSalesForce4a(String browser) throws InterruptedException, IOException {
		System.out.println("Testcase-loginSalesForce4a");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forgot_password_link")));
		WebElement forgotpwd = driver.findElement(By.id("forgot_password_link"));
		clickButton(forgotpwd, "forgotpwd-button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("un")));
		WebElement username = driver.findElement(By.id("un"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
		WebElement continue1 = driver.findElement(By.id("continue"));
		clickButton(continue1, "continue1-button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Return to Login")));
		driver.close();

	}

	public static void userMenuTC05(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC05");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavLabel")));
		WebElement drpdown = driver.findElement(By.id("userNavLabel"));
		clickButton(drpdown, "drpdown-button");

		Thread.sleep(2000);
		driver.close();
	}

	public static void userMenuTC06(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC06");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		// login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");

		// user navigation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavLabel")));
		WebElement drpdown = driver.findElement(By.id("userNavLabel"));
		clickButton(drpdown, "drpdown-button");
		// my profile
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Profile")));
		WebElement my_profile = driver.findElement(By.linkText("My Profile"));
		clickButton(my_profile, "my_profile");

		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "moderatorMutton"))); WebElement profile_dropdown =
		 * driver.findElement(By.id("moderatorMutton"));
		 * ClickButton(profile_dropdown,"profile_dropdown");
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * linkText("Edit Profile"))); WebElement edit_profile =
		 * driver.findElement(By.linkText("Edit Profile"));
		 * ClickButton(edit_profile,"Edit_Profile");
		 * driver.switchTo().frame("aboutMeContentId");
		 */
		// edit profile
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='contactInfoLaunch editLink']")));
		WebElement profile_dropdown = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		clickButton(profile_dropdown, "profile_dropdown");
		driver.switchTo().frame("contactInfoContentId");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("About")));
		WebElement About = driver.findElement(By.linkText("About"));
		clickButton(About, "About");
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))));
		WebElement last_name = driver.findElement(By.id("lastName"));
		enterText(last_name, readPropertyData("last_name"), "last_name");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]")));
		WebElement save_allbutton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]"));
		clickButton(save_allbutton, "save_allbutton");
		driver.switchTo().defaultContent();

		// post link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"publisherAttachTextPost\"]")));
		WebElement Post_link = driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]"));
		clickButton(Post_link, "Post_link");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(frame);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body")));
		WebElement Post_text = driver.findElement(By.xpath("//html/body"));
		clickButton(Post_text, "Post_text");
		enterText(Post_text, readPropertyData("vaild_username"), "Post_text");
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("publishersharebutton")));
		WebElement Share_button = driver.findElement(By.id("publishersharebutton"));
		clickButton(Share_button, "Share_button");

		// file upload
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"publisherAttachContentPost\"]")));
		WebElement File_upload = driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]"));
		clickButton(File_upload, "File_upload");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chatterUploadFileAction")));
		WebElement click_uploadbutton = driver.findElement(By.id("chatterUploadFileAction"));
		clickButton(click_uploadbutton, "click_uploadbutton");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"chatterFile\"]")));
		WebElement click_browse = driver.findElement(By.xpath("//*[@id=\"chatterFile\"]"));
		browseText(click_browse, readPropertyData("file_upload"), "click_browse");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("publishersharebutton")));
		WebElement Share_button2 = driver.findElement(By.id("publishersharebutton"));
		clickButton(Share_button2, "Share_button2");

		// photo upload
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("photoSection")));
		WebElement photo_section = driver.findElement(By.id("photoSection"));
		Actions photo = new Actions(driver);
		photo.moveToElement(photo_section).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Update")));
		WebElement click_update = driver.findElement(By.linkText("Update"));
		clickButton(click_update, "click_update");
		driver.switchTo().frame("uploadPhotoContentId");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]")));
		WebElement photo_browse = driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]"));
		photo_browse.sendKeys(readPropertyData("photo_upload"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("j_id0:uploadFileForm:uploadBtn")));
		WebElement photo_save = driver.findElement(By.name("j_id0:uploadFileForm:uploadBtn"));
		clickButton(photo_save, "photo_save");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("j_id0:j_id7:save")));
		WebElement photo_save1 = driver.findElement(By.name("j_id0:j_id7:save"));
		clickButton(photo_save1, "photo_save1");
		driver.switchTo().defaultContent();

		// Thread.sleep(10000);
		// driver.close();
	}

	public static void userMenuTC07(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC07");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		// login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");

		// user navigation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavLabel")));
		WebElement drpdown = driver.findElement(By.id("userNavLabel"));
		clickButton(drpdown, "drpdown-button");
		// my Setting
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Settings")));
		WebElement my_setting = driver.findElement(By.linkText("My Settings"));
		clickButton(my_setting, "my_setting");
		// login history
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']")));
		WebElement personal = driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']"));
		clickButton(personal, "personal");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginHistory_font")));
		WebElement login_history = driver.findElement(By.id("LoginHistory_font"));
		clickButton(login_history, "login_history");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a")));
		WebElement history_download = driver
				.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
		clickButton(history_download, "history_download");

		// Display and layout
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[3]/a")));
		WebElement display_layout = driver
				.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[3]/a"));
		clickButton(display_layout, "display_layout");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomizeTabs_font")));
		WebElement customize = driver.findElement(By.id("CustomizeTabs_font"));
		clickButton(customize, "customize");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("p4")));
		WebElement custom_app = driver.findElement(By.id("p4"));
		Select custom_app_select = new Select(custom_app);
		custom_app_select.selectByVisibleText("Salesforce Chatter");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("duel_select_0")));
		WebElement available_tab = driver.findElement(By.id("duel_select_0"));
		Select available_tab_select = new Select(available_tab);
		available_tab_select.selectByVisibleText("Reports");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("duel_select_0_right")));
		WebElement add_button = driver.findElement(By.id("duel_select_0_right"));
		clickButton(add_button, "add_button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("save")));
		WebElement display_save = driver.findElement(By.name("save"));
		clickButton(display_save, "display_save");

		// email
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[4]/a")));
		WebElement email = driver
				.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[4]/a"));
		clickButton(email, "email");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EmailSettings_font")));
		WebElement email_setting = driver.findElement(By.id("EmailSettings_font"));
		clickButton(email_setting, "email_setting");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sender_name")));
		WebElement email_name = driver.findElement(By.id("sender_name"));
		enterText(email_name, readPropertyData("sender_name"), "email_name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sender_email")));
		WebElement email_email = driver.findElement(By.id("sender_email"));
		enterText(email_email, readPropertyData("email_email"), "email_email");
		List<WebElement> radio_button = driver.findElements(By.name("auto_bcc"));
		radio_button.get(0).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("save")));
		WebElement email_save = driver.findElement(By.name("save"));
		clickButton(email_save, "email_save");

		// Calendar reminder
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[6]/a")));
		WebElement calender_reminder = driver
				.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[6]/a"));
		clickButton(calender_reminder, "calender_reminder");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Reminders_font")));
		WebElement activity_reminder = driver.findElement(By.id("Reminders_font"));
		clickButton(activity_reminder, "activity_reminder");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("testbtn")));
		WebElement test_reminder = driver.findElement(By.id("testbtn"));
		clickButton(test_reminder, "test_reminder");
	}

	public static void userMenuTC08(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC08");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		// login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");

		// user navigation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavLabel")));
		WebElement drpdown = driver.findElement(By.id("userNavLabel"));
		clickButton(drpdown, "drpdown-button");
		// Developer Console
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Developer Console")));
		WebElement developer_console = driver.findElement(By.linkText("Developer Console"));
		clickButton(developer_console, "developer_console");
		String baseWindownHandle = driver.getWindowHandle();
		Set<String> allWindownHandle = driver.getWindowHandles();
		for (String handle : allWindownHandle) {
			if (!baseWindownHandle.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1170")));
		driver.close();
		driver.switchTo().window(baseWindownHandle);
		Thread.sleep(3000);
		driver.close();
	}

	public static void userMenuTC09(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC09");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		// login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");

		// user navigation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNavLabel")));
		WebElement drpdown = driver.findElement(By.id("userNavLabel"));
		clickButton(drpdown, "drpdown-button");
		// logoff
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		WebElement logout = driver.findElement(By.linkText("Logout"));
		clickButton(logout, "logout-button");

		Thread.sleep(2000);
		driver.close();

	}

	public static void userMenuTC10(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC10");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		// login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");
		// account tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Accounts")));
		WebElement account_tab = driver.findElement(By.linkText("Accounts"));
		clickButton(account_tab, "account_tab");

		popupclose();

		// new account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='new']")));
		WebElement new_button = driver.findElement(By.xpath("//input[@name='new']"));
		clickButton(new_button, "new_button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc2")));
		WebElement account_name = driver.findElement(By.id("acc2"));
		enterText(account_name, readPropertyData("account_name"), "account_name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc6")));
		WebElement account_type = driver.findElement(By.id("acc6"));
		Select account_type_select = new Select(account_type);
		account_type_select.selectByVisibleText("Technology Partner");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("00N4x00000WQnk7")));
		WebElement customer_prority = driver.findElement(By.id("00N4x00000WQnk7"));
		Select customer_prority_select = new Select(customer_prority);
		customer_prority_select.selectByVisibleText("High");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("save")));
		WebElement save_button = driver.findElement(By.name("save"));
		clickButton(save_button, "save_button");
	}

	public static void userMenuTC11(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC11");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		WaitDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		// login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");
		// account tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Accounts")));
		WebElement account_tab = driver.findElement(By.linkText("Accounts"));
		clickButton(account_tab, "account_tab");

		popupclose();

		// create new view
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create New View")));
		WebElement createNewView_click = driver.findElement(By.linkText("Create New View"));
		clickButton(createNewView_click, "createNewView_click");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname")));
		WebElement viewName_enter = driver.findElement(By.id("fname"));
		enterText(viewName_enter, readPropertyData("viewName_enter"), "viewName_enter");
		viewName_enter.sendKeys(Keys.TAB);
		saveButtonClick();

	}

	public static void userMenuTC12(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC12");
		getDriver(browser);
		WaitDriver();
		driver.get(readPropertyData("url"));
		WaitDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		// login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, readPropertyData("vaild_username"), "vaild-uname");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, readPropertyData("valid_Password"), "vaild-password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login")));
		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickButton(loginbutton, "login-button");
		// account tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Accounts")));
		WebElement account_tab = driver.findElement(By.linkText("Accounts"));
		clickButton(account_tab, "account_tab");

		popupclose();

		// edit the view
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fcf")));
		WebElement editView_dropdown = driver.findElement(By.id("fcf"));
		Select editView_dropdown_select = new Select(editView_dropdown);
		editView_dropdown_select.selectByVisibleText("NewViewCreate");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
		WebElement edit_viewName = driver.findElement(By.linkText("Edit"));
		clickButton(edit_viewName, "edit_viewName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname")));
		WebElement update_viewName_enter = driver.findElement(By.id("fname"));
		enterText(update_viewName_enter, readPropertyData("update_viewName_enter"), "update_viewName_enter");
		update_viewName_enter.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fcol1")));
		WebElement filter_field = driver.findElement(By.id("fcol1"));
		Select filter_field_select = new Select(filter_field);
		filter_field_select.selectByVisibleText("Account Name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fop1")));
		WebElement filter_operator = driver.findElement(By.id("fop1"));
		Select filter_operator_select = new Select(filter_operator);
		filter_operator_select.selectByVisibleText("contains");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fval1")));
		WebElement filter_value = driver.findElement(By.id("fval1"));
		enterText(filter_value, readPropertyData("filter_value"), "filter_value");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("colselector_select_0")));

		WebElement display_column = driver.findElement(By.id("colselector_select_0"));
		Select display_column_select = new Select(display_column);
		display_column_select.selectByVisibleText("Last Activity");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("colselector_select_0_right")));
		WebElement add_button = driver.findElement(By.id("colselector_select_0_right"));
		clickButton(add_button, "add_button");

		saveButtonClick();

	}
	public static void userMenuTC13(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC13");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		accountTabClick();
		popupclose();
		clickMergeAccount();
		findAccount();
		SelectAccountNext();
		saveButtonClick();
		alertAccept();
}
	public static void userMenuTC14(String browser) throws InterruptedException, IOException {
		System.out.println("userMenuTC14");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		accountTabClick();
		popupclose();
		lastActivity_30days();  
		selectCreateDate();
		selectFromDate();
		selectTodate();
		clickSave();
		saveRun();
}
	
	public static void createOpty15(String browser) throws InterruptedException, IOException {
		System.out.println("createOpty15");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		opportunitiesTabClick();
		popupclose();
		dropDownOptions("opportunities");
		
		
	}
	
	public static void createOpty16(String browser) throws InterruptedException, IOException {
		System.out.println("createOpty16");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		opportunitiesTabClick();
		popupclose();
		newButtonClick();
		By opportunities_name_locator	= By.id("opp3");
		WebElement opportunities_name = findByVisibility(opportunities_name_locator,"opportunities_name_locator");
		enterText(opportunities_name, readPropertyData("opportunities_name"), "opportunities_name");
		
		/*By accountname_locator = By.id("opp4_lkwgt");
		WebElement accountname = findByVisibility(accountname_locator,"accountname_locator");
		clickButton(accountname, "accountname");
		switchWindow();
		Thread.sleep(3000);
		By selectname_locator = By.xpath("/html/body/form/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a");
		System.out.println("URL is " + driver.getCurrentUrl()+ " title is " + driver.getTitle());
		WebElement selectname = findByVisibility(selectname_locator,"selectname_locator");
		actionMovetoElement(selectname, "selectname");
		clickButton(selectname, "selectname");
		driver.close();
		driver.switchTo().defaultContent();*/
		
		By accountname_locator	= By.id("opp4");
		WebElement accountname = findByVisibility(accountname_locator,"accountname_locator");
		enterText(accountname, "accountNew" , "opportunities_name");
		
		By leadsource_locator	= By.id("opp6");
		WebElement leadsource = findByVisibility(leadsource_locator,"leadsource_locator");
		Select leadsource_select = new Select(leadsource);
		leadsource_select.selectByVisibleText("Phone Inquiry");
		
		By closedate_locator	= By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a");
		WebElement closedate = findByVisibility(closedate_locator,"closedate_locator");
		clickButton(closedate, "closedate");
		
		By stage_locator	= By.id("opp11");
		WebElement stage = findByVisibility(stage_locator,"stage_locator");
		Select stage_select = new Select(stage);
		stage_select.selectByVisibleText("Prospecting");
		
		By probability_locator	= By.id("opp12");
		WebElement probability = findByVisibility(probability_locator,"probability_locator");
		enterText(probability, "50" , "probability");
		
		saveButtonClick();
		
	}
	
	public static void createOpty17(String browser) throws InterruptedException, IOException {
		System.out.println("createOpty17");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		opportunitiesTabClick();
		popupclose();
		
		By opipeline_locator	= By.linkText("Opportunity Pipeline");
		WebElement opipeline = findByVisibility(opipeline_locator,"opipeline_locator");
		clickButton(opipeline, "opipeline");
		
	}
	
	public static void createOpty18(String browser) throws InterruptedException, IOException {
		System.out.println("createOpty18");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		opportunitiesTabClick();
		popupclose();
		
		By ostuck_locator = By.linkText("Stuck Opportunities");
		WebElement ostuck = findByVisibility(ostuck_locator,"ostuck_locator");
		clickButton(ostuck, "ostuck");
		
	}
	
	public static void createOpty19(String browser) throws InterruptedException, IOException {
		System.out.println("createOpty19");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		opportunitiesTabClick();
		popupclose();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='new']")));
		selectInterval("Current FQ");
		selectInclude("All Opportunities");
		runReport();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quarter_c")));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='new']")));
		selectInterval("Next FQ");
		selectInclude("Closed Opportunities");
		runReport();
		
		
	}
	
	public static void leads20(String browser) throws InterruptedException, IOException {
		System.out.println("leads20");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		leadTabClick();
		popupclose();
	}
	
	public static void leads21(String browser) throws InterruptedException, IOException {
		System.out.println("leads21");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		leadTabClick();
		popupclose();
		dropDownOptions("leads");
	}
	
	public static void leads22(String browser) throws InterruptedException, IOException {
		System.out.println("leads22");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		leadTabClick();
		popupclose();
		By dropdown_locator = By.id("fcf");
		WebElement dropdown_click = findByVisibility(dropdown_locator,"dropdown_locator");
		Select dropdown_select = new Select(dropdown_click);
		dropdown_select.selectByVisibleText("Today's Leads");
		
		By userdropdown_locator=By.id("userNavLabel");
	    WebElement userdropdown = findByVisibility(userdropdown_locator,"userdropdown_locator");
		clickButton(userdropdown, "userdropdown");
        
		By logout_locator = By.linkText("Logout");
		WebElement logout = findByVisibility(logout_locator,"logout_locator");
		clickButton(logout, "logout-button");
		vaildLogin();
		leadTabClick();
		//popupclose();
		validateDropdown();
		By goButton_locator = By.xpath("//input[@name='go' and @value=' Go! ']");
		WebElement goButton_click = findByVisibility(goButton_locator,"goButton_locator");
		clickButton(goButton_click, "goButton_click");
	}
	
	public static void leads23(String browser) throws InterruptedException, IOException {
		System.out.println("leads23");
		webPageLaunch(browser);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		vaildLogin();
		leadTabClick();
		popupclose();
		By dropdown_locator = By.id("fcf");
		WebElement dropdown_click = findByVisibility(dropdown_locator,"dropdown_locator");
		//clickButton(dropdown_click, "dropdown_click");
		Select dropdown_select = new Select(dropdown_click);
		dropdown_select.selectByVisibleText("Today's Leads");
		
		By goButton_locator = By.xpath("//input[@name='go' and @value=' Go! ']");
		WebElement goButton_click = findByVisibility(goButton_locator,"goButton_locator");
		clickButton(goButton_click, "goButton_click");
	}


public static void leads24(String browser) throws InterruptedException, IOException {
	System.out.println("leads24");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	leadTabClick();
	popupclose();
	newButtonClick();
	By lastname_locator	= By.id("name_lastlea2");
	WebElement lastname = findByVisibility(lastname_locator,"lastname_locator");
	enterText(lastname, "ABCD" , "lastname");
	By company_locator	= By.id("lea3");
	WebElement company = findByVisibility(company_locator,"company_locator");
	enterText(company, "ABCD" , "company");
	saveButtonClick();
	
}

public static void contacts25(String browser) throws InterruptedException, IOException {
	System.out.println("contacts25");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	contactTabClick();
	popupclose();
	newButtonClick();
	By lastname_locator	= By.id("name_lastcon2");
	WebElement lastname = findByVisibility(lastname_locator,"lastname_locator");
	enterText(lastname, "NewContact" , "lastname");
	By accountname_locator	= By.id("con4");
	WebElement accountname = findByVisibility(accountname_locator,"accountname_locator");
	enterText(accountname, "accountNew" , "accountname");
	saveButtonClick();
	
}

public static void contacts26(String browser) throws InterruptedException, IOException {
	System.out.println("contacts26");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	contactTabClick();
	popupclose();
	By createNewView_locator	= By.linkText("Create New View");
	WebElement createNewView = findByVisibility(createNewView_locator,"createNewView_locator");
	clickButton(createNewView, "createNewView");
	By viewname_locator	= By.id("fname");
	WebElement viewname = findByVisibility(viewname_locator,"viewname_locator");
	enterText(viewname, "tekarch" , "viewname");
	viewname.sendKeys(Keys.TAB);
	saveButtonClick();
	contactTabClick();
	validateDropdown();	
}

public static void contacts27(String browser) throws InterruptedException, IOException {
	System.out.println("contacts27");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	contactTabClick();
	popupclose();
	By recentContact_locator = By.id("hotlist_mode");
	WebElement recentContact = findByVisibility(recentContact_locator,"recentContact_locator");
	selectElelmentByVisibleText(recentContact,"Recently Created");
}

public static void contacts28(String browser) throws InterruptedException, IOException {
	System.out.println("contacts28");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	contactTabClick();
	popupclose();
	By dropdowncheck_locator = By.id("fcf");
	WebElement dropdowncheck = findByVisibility(dropdowncheck_locator,"dropdowncheck_locator");
	selectElelmentByVisibleText(dropdowncheck,"My Contacts");
}

public static void contacts29(String browser) throws InterruptedException, IOException {
	System.out.println("contacts29");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	contactTabClick();
	popupclose();
	By contactname_locator = By.linkText("NewContact");
	WebElement contactname = findByVisibility(contactname_locator,"contactname_locator");
	clickButton(contactname, "contactname");
	String expected ="Contact: NewContact ~ Salesforce - Developer Edition";
	String actual =driver.getTitle();
	validateTitle(expected,actual);
	
}

public static void contacts30(String browser) throws InterruptedException, IOException {
	System.out.println("contacts30");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	contactTabClick();
	popupclose();
	By createNewView_locator	= By.linkText("Create New View");
	WebElement createNewView = findByVisibility(createNewView_locator,"createNewView_locator");
	clickButton(createNewView, "createNewView");
	By viewuniquename_locator	= By.id("devname");
	WebElement viewuniquename = findByVisibility(viewuniquename_locator,"viewuniquename_locator");
	enterText(viewuniquename, "EFGH" , "viewuniquename");
	saveButtonClick();
}

public static void contacts31(String browser) throws InterruptedException, IOException {
	System.out.println("contacts31");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	contactTabClick();
	popupclose();
	By createNewView_locator	= By.linkText("Create New View");
	WebElement createNewView = findByVisibility(createNewView_locator,"createNewView_locator");
	clickButton(createNewView, "createNewView");
	By viewname_locator	= By.id("fname");
	WebElement viewname = findByVisibility(viewname_locator,"viewname_locator");
	enterText(viewname, "ABCD" , "viewname");
	By viewuniquename_locator	= By.id("devname");
	WebElement viewuniquename = findByVisibility(viewuniquename_locator,"viewuniquename_locator");
	enterText(viewuniquename, "EFGH" , "viewuniquename");
	cancelButtonClick();
	By dropdowncheck_locator = By.id("fcf");
	WebElement dropdowncheck = findByVisibility(dropdowncheck_locator,"dropdowncheck_locator");
	Select dropdowncheck_select = new Select(dropdowncheck);
	WebElement option = dropdowncheck_select.getFirstSelectedOption();
	String expected ="ABCD";
	String actual=option.getText();
	if(!expected.equals(actual)) {
		System.out.println("New view is not created with view name "+expected);	
	}
	else
	{
		System.out.println("New view is created with view name "+expected);	
	}
	
}

public static void contacts32(String browser) throws InterruptedException, IOException {
	System.out.println("contacts32");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	contactTabClick();
	popupclose();
	newButtonClick();
	By lastname_locator	= By.id("name_lastcon2");
	WebElement lastname = findByVisibility(lastname_locator,"lastname_locator");
	enterText(lastname, "India" , "lastname");
	By accountname_locator	= By.id("con4");
	WebElement accountname = findByVisibility(accountname_locator,"accountname_locator");
	enterText(accountname, "Global Media" , "accountname");
	By savenew_locator	= By.name("save_new");
	WebElement savenew = findByVisibility(savenew_locator,"savenew_locator");
	clickButton(savenew, "savenew");
	cancelButtonClick();
	String actual ="Contact: India ~ Salesforce - Developer Edition";
	String expected = driver.getTitle();
	validateTitle(expected, actual);
}
public static void contacts33(String browser) throws InterruptedException, IOException {
	System.out.println("contacts33");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	homeTabClick();
	popupclose();
	By FirstLastname_locator = By.id("mru0054x000006T6vy");
	WebElement FirstLastname_tab = findByVisibility(FirstLastname_locator,"FirstLastname_locator");
	clickButton(FirstLastname_tab, "FirstLastname_tab");
	Thread.sleep(5000);
	driver.close();
}

public static void contacts34(String browser) throws InterruptedException, IOException {
	System.out.println("contacts34");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	homeTabClick();
	popupclose();
	By FirstLastname_locator = By.id("mru0054x000006T6vy");
	WebElement FirstLastname_tab = findByVisibility(FirstLastname_locator,"FirstLastname_locator");
	clickButton(FirstLastname_tab, "FirstLastname_tab");
	By editprofile_locator=By.xpath("//a[@class='contactInfoLaunch editLink']");
	WebElement editprofile = findByVisibility(editprofile_locator,"editprofile_locator");
	clickButton(editprofile, "editprofile");
	driver.switchTo().frame("contactInfoContentId");
	By about_locator = By.linkText("About");
	WebElement aboutClick = findByVisibility(about_locator,"about_locator");
	clickButton(aboutClick, "aboutClick");
	By firstname_locator= By.id("firstName");
    WebElement firstnameClick = findByVisibility(firstname_locator,"firstname_locator");
    clickButton(firstnameClick, "firstnameClick");
	By lastname_locator= By.id("lastName");
	WebElement lastnameClick = findByVisibility(lastname_locator,"lastname_locator");
	enterText(lastnameClick, "Abcd", "lastnameClick");
	By saveall_locator = By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]");
	WebElement saveallClick = findByVisibility(saveall_locator,"saveall_locator");
	clickButton(saveallClick, "saveallClick");
	driver.switchTo().defaultContent();
	//Thread.sleep(2000);
	String updateActual = "Likitha Abcd";
	By update_locator = By.id("tailBreadcrumbNode");
	WebElement updatename = findByVisibility(update_locator,"update_locator");
	String updateExpected=updatename.getText().replace('\u00A0',' ').trim();
	
	validateTitle(updateExpected, updateActual);
	
	String userupdateActual = "Likitha Abcd";
	By userupdate_locator = By.id("userNavLabel");
	WebElement userupdatename = findByVisibility(userupdate_locator,"userupdate_locator");
	String userupdateExpected=userupdatename.getText();
	validateTitle(userupdateExpected, userupdateActual);

	Thread.sleep(5000);
	driver.close();
	
}

public static void RandomScenarios35(String browser) throws InterruptedException, IOException {
	System.out.println("RandomScenarios35");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	By plusTab_locator = By.id("AllTab_Tab");
	WebElement plusTabClick = findByVisibility(plusTab_locator,"plusTab_locator");
	clickButton(plusTabClick, "plusTabClick");
	By customize_locator = By.xpath("//input[@name='customize' and @value='Customize My Tabs']");
	WebElement customizeClick = findByVisibility(customize_locator,"customize_locator");
	clickButton(customizeClick, "customizeClick");
	By selectedtab_locator = By.id("duel_select_1");
	WebElement selectedtab = findByVisibility(selectedtab_locator,"selectedtab_locator");
	selectElelmentByVisibleText(selectedtab,"Campaigns");
	By remove_locator = By.id("duel_select_0_left");
	WebElement remove = findByVisibility(remove_locator,"remove_locator");
	clickButton(remove, "remove");
	saveButtonClick();
	Thread.sleep(5000);
	driver.close();
	
}

public static void RandomScenarios36(String browser) throws InterruptedException, IOException {
	System.out.println("RandomScenarios36");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	homeTabClick();
	popupclose();
	By currentdate_locator = By.xpath("//table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[2]/a");
	WebElement currentdate = findByVisibility(currentdate_locator,"currentdate_locator");
	clickButton(currentdate, "currentdate");
	
	By eightPM_locator = By.xpath("//table/tbody/tr[2]/td[1]/div[29]/a");
	WebElement eightPM = findByVisibility(eightPM_locator,"eightPM_locator");
	clickButton(eightPM, "eightPM");
	By combobox_locator = By.xpath("//img[@class='comboboxIcon']");
	WebElement comboBox = findByVisibility(combobox_locator,"combobox_locator");
	clickButton(comboBox, "comboBox");
	Thread.sleep(2000);
	String baseWindownHandle = driver.getWindowHandle();
	Set<String> allWindownHandle = driver.getWindowHandles();
	for (String handle : allWindownHandle) {
		if (!baseWindownHandle.equals(handle)) {
			driver.switchTo().window(handle);
			break;
		}
	}
	By otherclick_locator = By.linkText("Other");
	WebElement otherclick = findByVisibility(otherclick_locator,"otherclick_locator");
	clickButton(otherclick, "otherclick");
	//driver.close();
	driver.switchTo().window(baseWindownHandle);

	By enddate_locator = By.id("EndDateTime_time");
	WebElement enddate = findByVisibility(enddate_locator,"enddate_locator");
	clickButton(enddate, "enddate");
	enterText(enddate,"9:00 PM", "EndDateTime_time");
	saveButtonClick();
	
}

public static void RandomScenarios37(String browser) throws InterruptedException, IOException {
	System.out.println("RandomScenarios37");
	webPageLaunch(browser);
	wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	vaildLogin();
	homeTabClick();
	popupclose();
	By currentdate_locator = By.xpath("//table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[2]/a");
	WebElement currentdate = findByVisibility(currentdate_locator,"currentdate_locator");
	clickButton(currentdate, "currentdate");
	
	By fourPM_locator = By.xpath("//table/tbody/tr[2]/td[1]/div[21]/a");
	WebElement fourPM = findByVisibility(fourPM_locator,"fourPM_locator");
	clickButton(fourPM, "fourPM");
	By combobox_locator = By.xpath("//img[@class='comboboxIcon']");
	WebElement comboBox = findByVisibility(combobox_locator,"combobox_locator");
	clickButton(comboBox, "comboBox");
	//Thread.sleep(2000);
	String baseWindownHandle = driver.getWindowHandle();
	Set<String> allWindownHandle = driver.getWindowHandles();
	for (String handle : allWindownHandle) {
		if (!baseWindownHandle.equals(handle)) {
			driver.switchTo().window(handle);
			break;
		}
	}
	By otherclick_locator = By.linkText("Other");
	WebElement otherclick = findByVisibility(otherclick_locator,"otherclick_locator");
	clickButton(otherclick, "otherclick");
	//driver.close();
	driver.switchTo().window(baseWindownHandle);

	By enddate_locator = By.id("EndDateTime_time");
	WebElement enddate = findByVisibility(enddate_locator,"enddate_locator");
	clickButton(enddate, "enddate");
	enterText(enddate,"7:00 PM", "EndDateTime_time");
	//Thread.sleep(8000);
	By reccurrence_locator = By.id("IsRecurrence");
	WebElement reccurrence = findByVisibility(reccurrence_locator,"reccurrence_locator");
	clickButton(reccurrence, "reccurrence");
	
	if(reccurrence.isSelected()) {
		List<WebElement> radio_button = driver.findElements(By.name("rectype"));
		radio_button.get(1).click();

		By enddate1_locator = By.id("RecurrenceEndDateOnly");
		WebElement enddate1 = findByVisibility(enddate1_locator,"enddate1_locator");
		//enterText(enddate1,"10/13/2022", "EndDate_date");
		clickButton(enddate1, "enddate1");
		dateChecker(enddate1);
	
	}
	
	
	
	/*By daySelect_locator = By.id("16");
	WebElement daySelect = findByVisibility(daySelect_locator,"daySelect_locator");
	clickButton(daySelect, "daySelect");*/
	
	
	saveButtonClick();
	By monthView_locator = By.xpath("//img[@class='monthViewIcon']");
	WebElement monthView = findByVisibility(monthView_locator,"monthView_locator");
	clickButton(monthView, "monthView");
	
}

}
