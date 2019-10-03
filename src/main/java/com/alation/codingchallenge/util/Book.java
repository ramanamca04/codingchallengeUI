package com.alation.codingchallenge.util;

import java.util.Map;

public class Book {
	
	private String title;
	private String author;
	private String releaseDate;
	private boolean isBestSeller;
	private int totalReviews;
	Map<String, String> editionTypes;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isBestSeller() {
		return isBestSeller;
	}
	public void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}
	public int getTotalReviews() {
		return totalReviews;
	}
	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}
	public Map<String, String> getEditionTypes() {
		return editionTypes;
	}
	public void setEditionTypes(Map<String, String> editionTypes) {
		this.editionTypes = editionTypes;
	}
	
	
	public String toString() {
		
		String bookDetails = null;
		try {
		   bookDetails =  " Title  :" + title + 
			   " Author :" + author + 
			   " ReleaseDate :" + releaseDate + 
			   " IsBestSeller :" + isBestSeller + 
			   " TotalReviews :" + totalReviews + 
			   " EditionTypes :" + editionTypes.toString();
			   
		} catch(NullPointerException e) {
			e.getStackTrace();
		}
		
		return bookDetails;
		
	}

}
