/**
 * 
 */
package com.jagility.services.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jagility.commons.spring.Assert;
import com.jagility.data.dao.IPersonDao;
import com.jagility.data.entity.Person;
import com.jagility.services.admin.IAdminService;

/**
 * @author sbarbey
 */
@Service
public class AdminServiceImpl implements IAdminService {

	private IPersonDao personDao;

	@Autowired
	public AdminServiceImpl(IPersonDao personDao) {
		Assert.notNull(personDao, "personDao");
		this.personDao = personDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> findPersons() {
		return personDao.find();
	}

	@Override
	@Transactional
	public Integer savePerson(Person person) {
		return personDao.save(person);
	}

	@Override
	@Transactional
	public void deletePerson(Person person) {
		personDao.delete(person);
	}

	@Override
	@Transactional(readOnly = true)
	public Person findPerson(Integer personId) {
		return personDao.get(personId);
	}

}
