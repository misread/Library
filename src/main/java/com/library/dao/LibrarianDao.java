package com.library.dao;

import com.library.model.Book;
import com.library.model.Librarian;
import com.library.model.Order;
import com.library.model.Visitor;

import java.util.List;

public interface LibrarianDao extends Dao<Librarian> {

    List findLibrariansByName(String name);

    List findAllBook();

    List findFreeBooks();

    List findAllVisitor();

    List findAllOrder();
}
