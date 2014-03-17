package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartHomePage {
	
	 @FindBy(id = "fk-top-search-box")
	  private WebElement searchBox;
	 	 
	 public void searchFor(String text) {
	        searchBox.sendKeys(text);
	        searchBox.submit();
	        
	    }
}
