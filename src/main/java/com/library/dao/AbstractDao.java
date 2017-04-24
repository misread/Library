package com.library.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    protected Session getSession() {
        if (session == null || ! session.isOpen()) {
            try {
                session = getSessionFactory().getCurrentSession();
            } catch (HibernateException e) {
                session = getSessionFactory().openSession();
            }
        }

        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
