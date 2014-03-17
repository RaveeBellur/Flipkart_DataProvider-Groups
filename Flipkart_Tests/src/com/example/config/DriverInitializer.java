package com.example.config;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverInitializer {

	public WebDriver getAppropriateDriver(PropertyFileReader propertyReader)
			throws IOException {
		WebDriver driver = null;

		if (propertyReader.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (propertyReader.getProperty("browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver-exe/chromedriver.exe");
			driver = new ChromeDriver();
		}else if (propertyReader.getProperty("browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./driver-exe/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}	
	return driver;
	}

}
