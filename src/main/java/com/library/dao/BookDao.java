package com.library.dao;

import com.library.model.Book;

import java.util.List;

public interface BookDao extends Dao<Book> {

    List findBooksByName(String name);
}
