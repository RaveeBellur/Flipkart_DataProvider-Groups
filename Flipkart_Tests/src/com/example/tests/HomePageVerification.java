package com.example.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.pages.FlipkartHomePage;

public class HomePageVerification {
	
	private WebDriver driver = new FirefoxDriver();
	FlipkartHomePage homePage;
	
	@BeforeTest(alwaysRun = true)
	public void setUp()
	{
		driver.get("http://www.flipkart.com");
		homePage = PageFactory.initElements(driver, FlipkartHomePage.class);
	}
	
	@Test(groups = { "search" })
	public void verifySearch()
	{
		homePage.searchFor("notebooks");
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException {
		driver.quit();
	}

}
