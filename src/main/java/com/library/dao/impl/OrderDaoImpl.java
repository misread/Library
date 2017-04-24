package com.library.dao.impl;

import com.library.dao.AbstractDao;
import com.library.dao.OrderDao;
import com.library.model.Book;
import com.library.model.Order;
import com.library.model.Visitor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao implements OrderDao {

	@Override
	@Transactional
	public void save(Order order) {
		getSession().save(order);
	}

	@Override
	public void update(Order order) {
		Session session = getSession();
		session.update(order);
		session.flush();
	}

	@Override
	@Transactional
	public void delete(Order order) {
		Session session = getSession();
		getSession().delete(order);
		session.flush();
	}

	@Override
	public Order findById(Long id) {
		Query hqlQuery = getSession().createQuery("FROM Order WHERE id = :id");
		List orders = hqlQuery.setLong("id", id).list();
		return (Order) orders.get(0);
	}

	@Override
	public List findOrdersByVisitor(Visitor visitor) {
		Query hqlQuery = getSession().createQuery("FROM Order AS o WHERE o.visitor = :visitor");
		return hqlQuery.setEntity("visitor", visitor).list();
	}

	@Override
	public List findOrdersByBook(Book book) {
		Query hqlQuery = getSession().createQuery("FROM Order AS o WHERE o.book = :book");
		return hqlQuery.setEntity("book", book).list();
	}

	@Override
	public List findOrdersByStatus(Order.Status status) {
		Query hqlQuery = getSession().createQuery("FROM Order AS o WHERE o.status = :status");
		return hqlQuery.setEntity("status", status).list();
	}

	@Override
	public List findOrdersByBookAndVisitor(Book book, Visitor visitor) {
		Query hqlQuery = getSession().createQuery("FROM Order AS o WHERE o.book = :book and o.visitor = :visitor");
		hqlQuery.setEntity("book", book);
		hqlQuery.setEntity("visitor", visitor);
		return hqlQuery.list();
	}

	@Override
	public List findOrdersByBookAndStatus(Book book, Order.Status status) {
		Query hqlQuery = getSession().createQuery("FROM Order AS o WHERE o.book = :book and o.status = :status");
		hqlQuery.setEntity("book", book);
		hqlQuery.setEntity("status", status);
		return hqlQuery.list();
	}

	@Override
	public List findOrdersByVisitorAndStatus(Visitor visitor, Order.Status status) {
		Query hqlQuery = getSession().createQuery("FROM Order AS o WHERE o.visitor = :visitor and o.status = :status");
		hqlQuery.setEntity("visitor", visitor);
		hqlQuery.setEntity("status", status);
		return hqlQuery.list();
	}

}