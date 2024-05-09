package com.qawingify_BankingApplication.testcases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qawingify_BankingApplication.base.TestBase;
import com.qawingify_BankingApplication.pages.HomePage;
import com.qawingify_BankingApplication.pages.LoginPage;
import junit.framework.Assert;

public class HomePageTest extends TestBase{

	public HomePageTest() throws IOException {
		super();
	}
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() throws IOException {
	
		initialization();  // remove all the initialization
		
		loginPage = new LoginPage();
		homePage = new HomePage();
		
		// Login before each test
		loginPage.validateLogin("validUsername", "validPassword");
	}

	@Test
	public void validateTitle() {

		String expectedTitle = "Demo App";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
    @Test
    public void testAmountHeaderSorting() {
        // Click on the Amount header to sort
        homePage.clickAmountHeader();

        // Get the sorted amounts
        List<Double> sortedAmounts = homePage.getAmounts();

        // Check if the list is in ascending order
        boolean isAscending = isSortedAscending(sortedAmounts);

        // Assert that the list is in ascending order
        Assert.assertTrue("Amounts are not in ascending order", isAscending);
    }
    
    private boolean isSortedAscending(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {	
                return false;
            }
        }
        return true;
    }
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
