/**
 * 
 */
package com.jagility.services.admin;

import java.util.List;

import com.jagility.data.entity.Person;

/**
 * @author sbarbey
 */
public interface IAdminService {

	List<Person> findPersons();

	Integer savePerson(Person person);

	void deletePerson(Person person);

	Person findPerson(Integer personId);

}