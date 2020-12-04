package com.satish07.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.satish07.bootrestbook.dao.BookRepository;
import com.satish07.bootrestbook.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(12,"Java Complete Reference", "XYZ"));
//		list.add(new Book(36,"Head First Java", "ABC"));
//		list.add(new Book(48,"Think in Java", "LMN"));
//		list.add(new Book(64,"Python", "DFC"));
//	}
	
	//get all books
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
//			book = list.stream().filter(e->e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return book;
	}
	
	//adding the book
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}

	public void deleteBook(int bid) {
		
//		list = list.stream().filter(book->(book.getId() != bid). 
//		       collect(Collectors.toList()));
		
		bookRepository.deleteById(bid);
		
	}

	public void updateBook(Book book, int bookId) {
		
//		list=list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
		
	}

}
