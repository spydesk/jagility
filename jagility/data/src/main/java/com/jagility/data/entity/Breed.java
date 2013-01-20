/*
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
@Table(name = "BREEDS")
public class Breed {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@Column(name = "NAME", nullable = false, unique = true, length = 50)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return stringBuilder(this).append(id).append(name).toString();
	}
}
