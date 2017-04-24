package com.library.service.impl;

import com.library.dao.OrderDao;
import com.library.model.Book;
import com.library.model.Order;
import com.library.model.Visitor;
import com.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void save(Order order){
		orderDao.save(order);
	}

	@Override
	public void update(Order order){
		orderDao.update(order);
	}

	@Override
	public void delete(Order order){
		orderDao.delete(order);
	}

	@Override
	public Order findOrderById(Long id) {
		return orderDao.findById(id);
	}

	@Override
	public List findOrdersByVisitor(Visitor visitor) {
		return orderDao.findOrdersByVisitor(visitor);
	}

	@Override
	public List findOrdersByBook(Book book) {
		return orderDao.findOrdersByBook(book);
	}

	@Override
	public List findOrdersByStatus(Order.Status status) {
		return orderDao.findOrdersByStatus(status);
	}

	@Override
	public List findOrdersByBookAndVisitor(Book book, Visitor visitor) {
		return orderDao.findOrdersByBookAndVisitor(book, visitor);
	}

	@Override
	public List findOrdersByBookAndStatus(Book book, Order.Status status) {
		return orderDao.findOrdersByBookAndStatus(book, status);
	}

	@Override
	public List findOrdersByVisitorAndStatus(Visitor visitor, Order.Status status) {
		return orderDao.findOrdersByVisitorAndStatus(visitor, status);
	}
}
