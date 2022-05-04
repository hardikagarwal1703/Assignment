package com.app.tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.app.exception.BookManagementException;
import com.app.library.Book;
import com.app.utils.BookMap;
import com.app.library.Category;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){

			HashMap<String,Book> bookMap = BookMap.populateMap();
			boolean exit = false;

			while(!exit) {
				System.out.println("Choose One Option:");
				System.out.println("1. Add Book");
				System.out.println("2. Display all books");
				System.out.println("3. Issue a single copy of a book");
				System.out.println("4. Return Book");
				System.out.println("5. Remove a Book");
				System.out.println("10. Exit");

				try {

					switch(Integer.parseInt(scan.nextLine())) {
						case 1:
								System.out.println("Enter Book Title:");
								String bookTitle = scan.nextLine();
								
								Book checkBook = bookMap.get(bookTitle);
								if(checkBook == null) {
									System.out.println("Enter Book Details!");
									System.out.println("Category, "
											+ "Price, "
											+ "Publish Date(yyyy-MM-dd), "
											+ "Author Name, Quantity");

									bookMap.put(bookTitle,new Book(bookTitle, 
											Category.valueOf(scan.nextLine().toUpperCase()), 
											Double.parseDouble(scan.nextLine()), 
											LocalDate.parse(scan.nextLine()), 
											scan.nextLine(), 
											Integer.parseInt(scan.nextLine())));
									System.out.println("Addede New Book!");

								}else {
									checkBook.updateQuantity(1);
									System.out.println("Updated Book Quantity");
								}
								break;

						case 2: 
								System.out.println("Books In Library Currently");
								for(Book book: bookMap.values()) {
									System.out.println(book);
								}
								break;

						case 3:
								System.out.println("Enter Book Title:");
								bookTitle = scan.nextLine();
								
								checkBook = bookMap.get(bookTitle);
								if(checkBook == null) {
									throw new BookManagementException("Book Out Of Stock!");
								}
								checkBook.updateQuantity(-1);
								System.out.println("Book is issued!");
								break;

						case 4:
								System.out.println("Enter Book Title:");
								bookTitle = scan.nextLine();
								
								checkBook = bookMap.get(bookTitle);
								if(checkBook == null) {
									throw new BookManagementException("Book Not Listed!");
								}
								checkBook.updateQuantity(1);
								System.out.println("Book is returned!");
								break;

						case 5:
								System.out.println("Enter Book Title:");
								bookTitle = scan.nextLine();
								
								checkBook = bookMap.get(bookTitle);
								if(checkBook == null) {
									throw new BookManagementException("Book Not Listed!");
								}
								bookMap.remove(bookTitle);
								System.out.println("Book removed!");
								break;

						case 10:
								exit = true;
								break;

					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
