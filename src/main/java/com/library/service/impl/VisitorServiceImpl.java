package com.library.service.impl;

import com.library.dao.VisitorDao;
import com.library.dao.Dao;
import com.library.model.Visitor;
import com.library.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {
	
	@Autowired
	VisitorDao visitorDao;

	public void setVisitorDao(VisitorDao visitorDao) {
		this.visitorDao = visitorDao;
	}

	@Override
	public void save(Visitor visitor){
		visitorDao.save(visitor);
	}

	@Override
	public void update(Visitor visitor){
		visitorDao.update(visitor);
	}

	@Override
	public void delete(Visitor visitor){
		visitorDao.delete(visitor);
	}

	@Override
	public Visitor findVisitorById(Long id) {
		return visitorDao.findById(id);
	}

	@Override
	public List findVisitorByName(String name) {
		return visitorDao.findVisitorsByName(name);
	}
}
