package com.alation.codingchallenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.alation.codingchallenge.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory or Object Repository
	
	@FindBy(id="searchDropdownBox")
	@CacheLookup                       //improve the performance of the script
	WebElement searchInDropDown;

	@FindBy(id="twotabsearchtextbox")
	@CacheLookup						//improve the performance of the script
	WebElement searchInput;
	
	@FindBy(className="nav-input")
	@CacheLookup						//improve the performance of the script
	WebElement searchIcon;
	
	//Initializing the page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public BooksPage searchBooks() throws InterruptedException {
		new Select(searchInDropDown).selectByVisibleText("Books");
		searchInput.sendKeys("data catalog");
		searchIcon.click();
		Thread.sleep(3000);
		return new BooksPage();
	}
}
