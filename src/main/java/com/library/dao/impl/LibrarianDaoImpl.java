package com.library.dao.impl;

import com.library.dao.AbstractDao;
import com.library.dao.LibrarianDao;
import com.library.model.Librarian;
import com.library.model.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("librarianDao")
public class LibrarianDaoImpl extends AbstractDao implements LibrarianDao {

	@Override
	public void save(Librarian librarian) {
		getSession().save(librarian);
	}

	@Override
	public void update(Librarian librarian) {
		Session session = getSession();
		session.update(librarian);
		session.flush();
	}

	@Override
	public void delete(Librarian librarian) {
		Session session = getSession();
		getSession().delete(librarian);
		session.flush();
	}

	@Override
	public Librarian findById(Long id) {
		Query hqlQuery = getSession().createQuery("FROM Librarian WHERE id = :id");
		List librarians = hqlQuery.setLong("id", id).list();
		return (Librarian) librarians.get(0);
	}

	@Override
	public List findLibrariansByName(String name) {
		Query hqlQuery = getSession().createQuery("FROM Librarian WHERE name = :name");
		return hqlQuery.setString("name", name).list();
	}

	@Override
	public List findAllBook() {
		Query hqlQuery = getSession().createQuery("FROM Book");
		return hqlQuery.list();
	}

	@Override
	public List findFreeBooks() {
		Query hqlQuery = getSession().createQuery("SELECT o.book FROM Order AS o WHERE o.book.name = '" + Order.Status.RETURNED + "'");
		return hqlQuery.list();
	}

	@Override
	public List findAllVisitor() {
		Query hqlQuery = getSession().createQuery("FROM Visitor");
		return hqlQuery.list();
	}

	@Override
	public List findAllOrder() {
		Query hqlQuery = getSession().createQuery("FROM Order");
		return hqlQuery.list();
	}

}