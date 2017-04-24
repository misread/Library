package com.library.service.impl;

import com.library.dao.LibrarianDao;
import com.library.dao.Dao;
import com.library.model.Book;
import com.library.model.Librarian;
import com.library.model.Order;
import com.library.model.Visitor;
import com.library.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("librarianService")
public class LibrarianServiceImpl implements LibrarianService {
	
	@Autowired
	LibrarianDao librarianDao;

	public void setLibrarianDao(LibrarianDao librarianDao) {
		this.librarianDao = librarianDao;
	}

	@Override
	public void save(Librarian librarian){
		librarianDao.save(librarian);
	}

	@Override
	public void update(Librarian librarian){
		librarianDao.update(librarian);
	}

	@Override
	public void delete(Librarian librarian){
		librarianDao.delete(librarian);
	}

	@Override
	public Librarian findLibrarianById(Long id) {
		return librarianDao.findById(id);
	}

	@Override
	public List findLibrarianByName(String name) {
		return librarianDao.findLibrariansByName(name);
	}

	@Override
	public List findAllBook() {
		return librarianDao.findAllBook();
	}

	@Override
	public List findFreeBooks() {
		return librarianDao.findFreeBooks();
	}

	@Override
	public List findAllVisitor() {
		return librarianDao.findAllVisitor();
	}

	@Override
	public List findAllOrder() {
		return librarianDao.findAllOrder();
	}
}
