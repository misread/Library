package com.library.common;

import com.library.model.Book;
import com.library.model.Order;
import com.library.model.Visitor;
import com.library.service.BookService;
import com.library.service.LibrarianService;
import com.library.service.OrderService;
import com.library.service.VisitorService;
import com.library.service.impl.LibrarianServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Runner {
    public static void main( String[] args ) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

    	BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("----- Started --------");

//    	Book book = new Book();
//    	book.setName("AAAA");
//    	bookService.save(book);
//    	Book book1 = new Book();
//    	book1.setName("BBB");
//    	bookService.save(book1);
//    	Book book2 = new Book();
//    	book2.setName("CCC");
//    	bookService.save(book2);

//    	List books = bookService.findBookByName("New");
//		Book aBook = null;
//		if (! books.isEmpty()) {
//			aBook = (Book) books.get(0);
//		}
//    	System.out.println(aBook);
//
//		Book book = (Book) bookService.findBookById(1L);
//		bookService.delete(book);
//		Book secondBook = (Book) bookService.findBookById(2L);
//		bookService.delete(secondBook);

//		Book myBook = bookService.findBookById(3L);
//		myBook.setName("New name 3");
//		bookService.update(myBook);

//		LibrarianService librarianService = (LibrarianService) context.getBean("librarianService");
//		List allBook = librarianService.findAllBook();
//		for (Object b : allBook) {
//			System.out.println(b);
//		}
//
//        aBook.setName("New bible");
//    	bookService.update(aBook);
//
//    	bookService.delete(aBook);

//        Book mybook = bookService.findBookById(5L);
//        bookService.delete(mybook);


		OrderService orderService = (OrderService) context.getBean("orderService");
		VisitorService visitorService = (VisitorService) context.getBean("visitorService");
        Visitor firstVisitor = new Visitor("Nick", (short) 25);

		Visitor secondVisitor = new Visitor("Tom", (short) 30);

		Book firtsBook = new Book();
		firtsBook.setName("First book");
		bookService.save(firtsBook);
		Book secondBook = new Book();
		secondBook.setName("Second book");
		bookService.save(secondBook);

		Order firstOrder = new Order(firtsBook, firstVisitor);
		Order secondOrder = new Order(secondBook, secondVisitor);

		orderService.save(firstOrder);
		orderService.save(secondOrder);


		List ordersByBookAndVisitor = orderService.findOrdersByBookAndVisitor(secondBook, secondVisitor);
		Order order = (Order) ordersByBookAndVisitor.get(0);
		order.setStatus(Order.Status.APPROVED);
		orderService.update(order);


		System.out.println("----- Done --------");
    }
}
