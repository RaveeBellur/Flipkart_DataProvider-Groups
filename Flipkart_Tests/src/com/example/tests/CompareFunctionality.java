package com.example.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.config.DriverInitializer;
import com.example.config.PropertyFileReader;
import com.example.pages.HomePage;


public class CompareFunctionality {
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws IOException {
		PropertyFileReader propertyReader = new PropertyFileReader("App.properties");
		DriverInitializer init = new DriverInitializer();
		driver = init.getAppropriateDriver(propertyReader);
		driver.get(propertyReader.getProperty("url"));
	}

	@Test(description = "Functionality:Compare products")
	public void CompareProducts() throws InterruptedException {
		HomePage hompepage = new HomePage(driver);
		hompepage.compareProducts();
	}
	
	@AfterClass
	public void tearDown() throws IOException {
		driver.quit();
	}
}
