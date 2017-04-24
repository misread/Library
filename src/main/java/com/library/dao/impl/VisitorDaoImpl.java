package com.library.dao.impl;

import com.library.dao.AbstractDao;
import com.library.dao.VisitorDao;
import com.library.model.Visitor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("visitorDao")
public class VisitorDaoImpl extends AbstractDao implements VisitorDao {

	@Override
	public void save(Visitor visitor) {
		getSession().save(visitor);
	}

	@Override
	public void update(Visitor visitor) {
		getSession().update(visitor);
	}

	@Override
	public void delete(Visitor visitor) {
		getSession().delete(visitor);
	}

	@Override
	public Visitor findById(Long id) {
		Query hqlQuery = getSession().createQuery("FROM Visitor WHERE id = :id");
		List visitor = hqlQuery.setLong("id", id).list();
		return (Visitor) visitor.get(0);
	}

	@Override
	public List findVisitorsByName(String name) {
		Query hqlQuery = getSession().createQuery("FROM Visitor WHERE name = :name");
		return hqlQuery.setString("name", name).list();
	}

}