/**
 * 
 */
package com.jagility.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jagility.data.entity.Person;

/**
 * @author sbarbey
 */
@Repository
public class PersonDaoImpl extends SingleEntityDaoSupport<Person, Integer> implements IPersonDao {

	@Autowired
	public PersonDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory, Person.class);
	}

	@Override
	public List<Person> find() {
		return find(null, (IRowOrder[]) null);
	}

}
