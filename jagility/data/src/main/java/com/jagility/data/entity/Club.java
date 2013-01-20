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
@Table(name = "CLUBS")
public class Club {

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id = null;

	@Column(name = "NAME", unique = true, nullable = false, length = 50)
	private String name = null;

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
