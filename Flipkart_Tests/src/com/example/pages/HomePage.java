package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.example.config.UtilFunctions;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void compareProducts() throws InterruptedException {
		UtilFunctions.MouseHover(driver, driver.findElement(By.cssSelector(".menu-links>li:nth-child(6)")));
		driver.findElement(By.cssSelector("#menu-home-kitchen-tab-0-content>ul:nth-child(4)>li:nth-child(2)>a")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#products>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(2)>div:nth-child(6)>input")).click();
		driver.findElement(By.cssSelector("#products>div:nth-child(1)>div:nth-child(2)>div>div:nth-child(2)>div:nth-child(6)>input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector(".compare-items>div:nth-child(3)")).getText()
				.contains("Add Another Item"));
		UtilFunctions.takeScreenshot("compare");
	}

}
