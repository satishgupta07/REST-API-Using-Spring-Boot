package com.satish07.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.satish07.bootrestbook.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findById(int id);
}
