package com.alation.codingchallenge.testcases;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alation.codingchallenge.base.TestBase;
import com.alation.codingchallenge.pages.BooksPage;
import com.alation.codingchallenge.pages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	BooksPage booksPage;
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException{
		initialization();
		homePage = new HomePage();
		
	}
	
	@Test
	public void homePageTest01() throws InterruptedException {
		log.info("Searching Books test execution begins");
		booksPage = homePage.searchBooks();
		log.info("Searching Books test execution end");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
