package com.alation.codingchallenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import com.alation.codingchallenge.base.TestBase;

public class BooksPage extends TestBase {
	
	private String bookNo = prop.getProperty("searchbookno");
	String bookBaseXpath = prop.getProperty("bookbase")+bookNo+"']";
	
	//Initializing the page Objects
	public BooksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isBookBestSeller() {
		try {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("best-seller_flag"))).isDisplayed();
		} catch(NoSuchElementException e) {
			e.getStackTrace();
		}
		
		return false;
	}
	
	public String getBookTitle() {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("booktitle"))).getText();
	}
	
	public String getBookAuthor() {
		try {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("bookauthor") + "//following-sibling::a")).getAttribute("innerText");
	} catch(NoSuchElementException e) {
		e.getStackTrace();
	}
	
	return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("bookauthor") + "//following-sibling::span[1]")).getAttribute("innerText");
				
	}
	
	public String getBookReleaseDate() {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("bookreleasedate"))).getText();
	}
	
	public String getBookTotalReviews() {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("totalreviews"))).getText();
	}

	public String getBookFirstEditionType() {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("editiontype_01"))).getText();
	}
	public String getBookFirstEditionPrice() {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("editionprice_01"))).getAttribute("innerText");
	}
	
	public String getBookSecondEditionType() {
		try {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("editiontype_02"))).getText();
		} catch(NoSuchElementException e) {
			e.getStackTrace();
		}
		
		return null;
	}
	
	public String getBookSecondEditionPrice() {
		try {
		return driver.findElement(By.xpath(bookBaseXpath + prop.getProperty("editionprice_02"))).getAttribute("innerText");
		} catch(NoSuchElementException e) {
			e.getStackTrace();
		}
		
		return null;
	}
}
