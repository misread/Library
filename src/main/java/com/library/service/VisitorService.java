package com.library.service;

import com.library.model.Visitor;

import java.util.List;

public interface VisitorService {
	
	void save(Visitor visitor);
	
	void update(Visitor visitor);
	
	void delete(Visitor visitor);

	Visitor findVisitorById(Long id);

	List findVisitorByName(String name);

}
