package com.library.dao;

import com.library.model.Visitor;

import java.util.List;

public interface VisitorDao extends Dao<Visitor> {

    List findVisitorsByName(String name);
}
