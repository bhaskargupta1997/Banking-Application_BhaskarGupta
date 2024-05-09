package com.qawingify_BankingApplication.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qawingify_BankingApplication.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "username")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;  

	@FindBy(id = "log-in")
	WebElement loginbutton;    

	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement rememberMe;  

	@FindBy(id = "logged-user-name")
	WebElement userName;

	@FindBy(xpath = "//*[@src=\"img/logo-big.png\"]")
	WebElement logo;

	@FindBy(xpath = "(//img[@style=\"width: 28px;\"])[1]")
	WebElement twitterLogo;

	@FindBy(xpath = "(//img[@style=\"width: 28px;\"])[2]")
	WebElement fbLogo;

	@FindBy(xpath ="(//img[@style=\"width: 28px;\"])[3]")
	WebElement linkedInLogo;

	public LoginPage(){
		
		PageFactory.initElements(driver, this); // Initialize elements using PageFactory
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String validateLogin(String username, String password) { // changes method to string
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginbutton.click();

		return userName.getText(); // verify user name after login
	}

	public boolean isLogoPresent() { 
		return logo.isDisplayed();
	}

	public boolean twitterLogoPresent() { 
		return twitterLogo.isDisplayed();
	}

	public boolean fbLogoPresent() { 
		return fbLogo.isDisplayed();
	}

	public boolean linkedInLogoPresent() {
		return linkedInLogo.isDisplayed();
	}

	public boolean rememberMe() {  
		return rememberMe.isSelected();
	}
}
