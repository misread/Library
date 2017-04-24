package com.library.service;

import com.library.model.Book;
import com.library.model.Librarian;
import com.library.model.Order;
import com.library.model.Visitor;

import java.util.List;

public interface LibrarianService {
	
	void save(Librarian librarian);
	
	void update(Librarian librarian);
	
	void delete(Librarian librarian);

	Librarian findLibrarianById(Long id);

	List findLibrarianByName(String name);

	List findAllBook();

	List findFreeBooks();

	List findAllVisitor();

	List findAllOrder();

}
