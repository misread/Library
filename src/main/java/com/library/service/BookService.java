package com.library.service;

import com.library.model.Book;

import java.util.List;

public interface BookService {
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(Book book);

	Book findBookById(Long id);

	List findBookByName(String name);

}
