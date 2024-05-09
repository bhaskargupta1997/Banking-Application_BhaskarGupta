package com.qawingify_BankingApplication.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qawingify_BankingApplication.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(id ="amount")
	WebElement amountHeader;
	
	@FindBy(xpath = "//span[@class='text-danger' or @class='text-success']")
	List<WebElement> values;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public void clickAmountHeader() {
		amountHeader.click();
	}
	
    public List<Double> getAmounts() {
        List<Double> amounts = new ArrayList<>();
        
        for (WebElement element : values) {
            String amountText = element.getText().trim().replaceAll("[^\\d.]+", ""); // Extract only numbers and dots
            double amount = Double.parseDouble(amountText);
            amounts.add(amount);
        }
        return amounts;
    }
}