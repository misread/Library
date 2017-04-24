package com.library.dao;

public interface Dao<T> {
	
	void save(T book);
	
	void update(T book);
	
	void delete(T book);

	T findById(Long id);

}
