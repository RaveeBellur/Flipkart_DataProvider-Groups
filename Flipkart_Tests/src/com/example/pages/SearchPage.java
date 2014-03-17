package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	private WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchAMobile(String modelName) {
		driver.findElement(By.id("fk-top-search-box")).clear();
		driver.findElement(By.id("fk-top-search-box")).sendKeys(modelName);
		driver.findElement(By.cssSelector("[class='search-bar-submit fk-font-13 fk-font-bold']")).click();
	}

	public void searchABook(String name) {
		driver.findElement(By.id("fk-top-search-box")).clear();
		driver.findElement(By.id("fk-top-search-box")).sendKeys(name);
		driver.findElement(By.cssSelector("[class='search-bar-submit fk-font-13 fk-font-bold']")).click();
	}			
		
}
