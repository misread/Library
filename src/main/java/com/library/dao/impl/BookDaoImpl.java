package com.library.dao.impl;

import java.util.List;

import com.library.dao.AbstractDao;
import com.library.dao.BookDao;
import com.library.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDao implements BookDao {

	@Override
	public void save(Book book) {
		getSession().save(book);
	}

	@Override
	public void update(Book book) {
		Session session = getSession();
		session.update(book);
		session.flush();
	}

	@Override
	public void delete(Book book) {
		Session session = getSession();
		session.delete(book);
		session.flush();
	}

	@Override
	public Book findById(Long id) {
		Query hqlQuery = getSession().createQuery("FROM Book WHERE id = :id");
		List books = hqlQuery.setLong("id", id).list();
		return (Book) books.get(0);
	}

	@Override
	public List findBooksByName(String name) {
		Query hqlQuery = getSession().createQuery("FROM Book WHERE name = :name");
		return hqlQuery.setString("name", name).list();
	}

}