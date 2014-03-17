package com.example.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.config.DriverInitializer;
import com.example.config.PropertyFileReader;
import com.example.config.UtilFunctions;
import com.example.pages.SearchPage;

public class SearchFunctionality {

	private WebDriver driver;
	SearchPage searchPage;

	@BeforeTest(alwaysRun = true)
	public void setUp() throws IOException {
		PropertyFileReader propertyReader = new PropertyFileReader("App.properties");
		DriverInitializer init = new DriverInitializer();
		driver = init.getAppropriateDriver(propertyReader);
		driver.get(propertyReader.getProperty("url"));
		searchPage = new SearchPage(driver);
	}

	@DataProvider(name = "TestData1")
	public Object[][] createBookSearchData(){
		return new Object[][] {
				{"Jeffrey Archer"},				
				{"The Alchemist"},
				{"Stay Hungry Stay Foolish"}
		};
	}
	
	@DataProvider(name = "DataSource")
	 public Object[][] dataProvider() {
		Object[][] retObjArr=UtilFunctions.getTabledata("testdata/data.xls","DataPool", "TestDataSet1");
	        return(retObjArr);
	 }
	
	@DataProvider(name = "TestData2")
	public Object[][] createMobileSearchData(){
		return new Object[][] {
				{"Sony Experia Z1"},				
				{"iPhone 5S"},
				{"Samsung Galaxy s4"}
		};
	}

	@Test(dataProvider = "DataSource" , groups = { "search" })	
	public void searchForBooksUsingExcelInput(String item){
		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchABook(item);
	}


	@Test(description = "Functionality: Search for mobile", groups = { "search" }, dependsOnMethods = { "searchForMobilesUsingArray" })
	public void SearchMobile() throws InterruptedException, IOException {
		searchPage.searchAMobile("samsung galaxy s4");
	}


	
	@Test(dataProvider = "TestData1" , groups = { "search" })	
	public void searchForBooksUsingArray(String item){
		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchABook(item);
	}
	
	@Test(dataProvider = "TestData2" , groups = { "search" })	
	public void searchForMobilesUsingArray(String item){
		SearchPage searchPage = new SearchPage(driver);
		searchPage.searchAMobile(item);
	}
	

	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException {
		driver.quit();
	}
}
