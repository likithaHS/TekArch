package com.firebase.test.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.firebase.test.pages.base.BasePage;

public class ForgotPasswordPage extends BasePage{
	
	 @FindBy(id="un") WebElement username;
	 @FindBy(id="continue") WebElement continueButton;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUserName(String usernameString) {
		  waitByVisibility(username,"username");
		  enterText(username, usernameString, "valid-username");
		  
	  }
	
	public void clickcontinueButton() {
		  waitByVisibility(continueButton,"continueButton");
		  clickButton(continueButton, "continueButton");
	  }
	  

}
