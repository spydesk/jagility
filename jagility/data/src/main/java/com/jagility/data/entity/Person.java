/**
 * 
 */
package com.jagility.data.entity;

import static com.jagility.commons.lang.StringUtils.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sbarbey
 */
@Entity
@Table(name = "PERSONS")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 50)
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return stringBuilder(this).append(id).append(firstName).append(lastName).toString();
	}

}
