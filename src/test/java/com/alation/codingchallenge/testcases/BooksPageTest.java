package com.alation.codingchallenge.testcases;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alation.codingchallenge.base.TestBase;
import com.alation.codingchallenge.pages.BooksPage;
import com.alation.codingchallenge.pages.HomePage;
import com.alation.codingchallenge.util.Book;

public class BooksPageTest extends TestBase {
	
	HomePage homePage;
	BooksPage booksPage;
	Book book;
	
	Logger log = Logger.getLogger(BooksPageTest.class);
	
	public BooksPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException{
		initialization();
		homePage = new HomePage();
		booksPage = homePage.searchBooks();
		book = new Book();
		
	}
	

	
	@Test
	public void readFirstBookResults_Test() {
		
		book.setBestSeller(booksPage.isBookBestSeller());
		book.setTitle(booksPage.getBookTitle());
		book.setAuthor(booksPage.getBookAuthor());
		book.setReleaseDate(booksPage.getBookReleaseDate());
		book.setTotalReviews(new Integer(booksPage.getBookTotalReviews()));
		Map<String, String> editions = new HashMap<String, String>();
		editions.put(booksPage.getBookFirstEditionType(), booksPage.getBookFirstEditionPrice());
		editions.put(booksPage.getBookSecondEditionType(), booksPage.getBookSecondEditionPrice());
		
		book.setEditionTypes(editions);
		
		System.out.println(book.toString());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
