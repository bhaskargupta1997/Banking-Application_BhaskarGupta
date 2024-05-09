package com.qawingify_BankingApplication.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase
{
	public static WebDriver driver;
	public static Properties p;

	public TestBase() {
		p = new Properties();
		loadConfigProperties();
	}


	private void loadConfigProperties() {
		try(FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\java course qspider\\qawingify_Banking-Application\\src\\main\\java\\com\\qawingify_BankingApplication\\config\\config.properties")) {

			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String browserName = p.getProperty("browser");
		System.out.println(browserName);
		if (browserName == null) {
			throw new RuntimeException("Browser is not specified in config.properties");
		}

		switch (browserName.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			throw new RuntimeException("Unsupported browser: " + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = p.getProperty("url");
		if (url == null) {
			throw new RuntimeException("URL is not specified in config.properties");
		}
		driver.get(url);
	}
	public void tearDown() 
	{
		if (driver != null) 
		{
			driver.quit();
		}
	}
}

