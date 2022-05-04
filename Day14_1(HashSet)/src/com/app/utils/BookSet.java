package com.app.utils;

import java.time.LocalDate;
import java.util.HashSet;

import com.app.library.Book;
import static com.app.library.Category.*;

public class BookSet {
	public static HashSet<Book> populateHashSet() {
		HashSet<Book> hashSet = new HashSet<>();

		hashSet.add(new Book("Harry Potter", FICTION, 999.99, LocalDate.parse("2021-12-12"), "JK Rowling", 100));
		hashSet.add(new Book("Gravity", NON_FICTION, 499.99, LocalDate.parse("2020-10-12"), "Franklin", 50));
		hashSet.add(new Book("APJ Abdul Kalam", BIOGRAPHY, 299.99, LocalDate.parse("1947-08-15"), "Missile Man", 10));
		hashSet.add(new Book("Chacha Chowdhary", COMIC, 99.99, LocalDate.parse("2000-08-17"), "PK Sharma", 200));
		hashSet.add(new Book("Avengers", FICTION, 799.99, LocalDate.parse("2014-01-01"), "Stan Lee", 1000));
		
		return hashSet;
	}
}
