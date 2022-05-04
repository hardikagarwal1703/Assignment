package com.app.library;

import java.time.LocalDate;

public class Book {
	private String title;
	private Category category;
	private double price;
	private LocalDate publishDate;
	private String authorName;
	private int quantity;

	public Book(String title, Category category, double price, LocalDate publishDate, String authorName, int quantity) {
		super();
		this.title = title;
		this.category = category;
		this.price = price;
		this.publishDate = publishDate;
		this.authorName = authorName;
		this.quantity = quantity;
	}
	
	public Book(String title) {
		super();
		this.title = title;
	}

	public void updateQuantity(String bookTitle,int quantity) {
		this.quantity += quantity;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", category=" + category + ", price=" + price + ", publishDate=" + publishDate
				+ ", authorName=" + authorName + ", quantity=" + quantity + "]";
	}
	
	@Override
	public int hashCode() {
		return title.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Book) {
			Book b = (Book)o;
			return this.title.equals(b.title);
		}
		return false;
	}
}
