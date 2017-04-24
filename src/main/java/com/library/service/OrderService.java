package com.library.service;

import com.library.model.Book;
import com.library.model.Order;
import com.library.model.Visitor;

import java.util.List;

public interface OrderService {
	
	void save(Order order);
	
	void update(Order order);
	
	void delete(Order order);

	Order findOrderById(Long id);

	List findOrdersByVisitor(Visitor visitor);

	List findOrdersByBook(Book book);

	List findOrdersByStatus(Order.Status status);

	List findOrdersByBookAndVisitor(Book book, Visitor visitor);

	List findOrdersByBookAndStatus(Book book, Order.Status status);

	List findOrdersByVisitorAndStatus(Visitor visitor, Order.Status status);

}
