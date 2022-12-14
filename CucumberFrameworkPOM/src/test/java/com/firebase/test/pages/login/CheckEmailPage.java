package com.firebase.test.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.firebase.test.pages.base.BasePage;

public class CheckEmailPage extends BasePage{
	@FindBy(linkText="Return to Login") WebElement return_to_login;

	public CheckEmailPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}
   
	 public String displayPageTitle() {
			waitByVisibility(return_to_login, "return_to_login");
			String title=driver.getTitle();
			return title;
		}
}
