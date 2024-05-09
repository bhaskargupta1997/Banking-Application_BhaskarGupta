package com.qawingify_BankingApplication.testcases;

import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qawingify_BankingApplication.base.TestBase;
import com.qawingify_BankingApplication.pages.HomePage;
import com.qawingify_BankingApplication.pages.LoginPage;

public class LoginPageTest extends TestBase {

	public LoginPageTest() throws IOException {
		super();
	}
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() throws IOException {
		initialization(); // Initialize driver
		loginPage = new LoginPage(); // Initialize LoginPage object
		homePage = new HomePage();
	}

	@Test
	public void testValidogin() {
		
		String msg = loginPage.validateLogin("validateUsername", "ValidatePassword");
		Assert.assertEquals("John Doe", msg);  // compared string 
	}

	@Test
	public void testInvalidLogin() {
		String msg2 = loginPage.validateLogin("invalidUsername", "invalidPassword");
		assertEquals("abcd@gmail.com", msg2);
	}

	@Test
	public void validateRememberMeSelection() {    // Added new method 
		Assert.assertFalse(loginPage.rememberMe());
	}

	@Test    		
	public void verifyIsLogoPresent() {
		Assert.assertTrue(loginPage.isLogoPresent());
	}

	@Test  
	public void verifyFbLogoPresent() {
		Assert.assertTrue(loginPage.fbLogoPresent());
	}		


	@Test   
	public void verifyLinkedInLogoPresent() {
		Assert.assertTrue(loginPage.linkedInLogoPresent());
	}		


	@Test  
	public void verifyTwitterLogoPresent() {
		Assert.assertTrue(loginPage.twitterLogoPresent());
	}		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
