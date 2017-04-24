package com.library.service.impl;

import com.library.dao.BookDao;
import com.library.service.BookService;
import com.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.Dao;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void save(Book book){
		bookDao.save(book);
	}

	@Override
	public void update(Book book){
		bookDao.update(book);
	}

	@Override
	public void delete(Book book){
		bookDao.delete(book);
	}

	@Override
	public Book findBookById(Long id) {
		return bookDao.findById(id);
	}

	@Override
	public List findBookByName(String name) {
		return bookDao.findBooksByName(name);
	}
}
