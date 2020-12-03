package com.satish07.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.satish07.bootrestbook.entities.Book;

@Component
public class BookService {
	
	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12,"Java Complete Reference", "XYZ"));
		list.add(new Book(36,"Head First Java", "ABC"));
		list.add(new Book(48,"Think in Java", "LMN"));
		list.add(new Book(64,"Python", "DFC"));
	}
	
	//get all books
	public List<Book> getAllBooks() {
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book book = null;
		book = list.stream().filter(e->e.getId() == id).findFirst().get();
		return book;
	}
	
	//adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

}
