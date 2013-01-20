/**
 * 
 */
package com.jagility.data.dao;

import java.util.List;

import com.jagility.data.entity.Person;

/**
 * @author sbarbey
 */
public interface IPersonDao {

	List<Person> find();

	Person get(Integer id);

	Integer save(Person person);

	void delete(Person person);

}
