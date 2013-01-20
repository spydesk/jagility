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
@Table(name = "COUNTRIES")
public class Country {

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id = null;

	@Column(name = "NAME", unique = true, nullable = false, length = 50)
	private String name = null;

	@Column(name = "ISO_CODE", unique = true, nullable = false, length = 2)
	private String isoCode = null;

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

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	@Override
	public String toString() {
		return stringBuilder(this).append(id).append(isoCode).append(name).toString();
	}
}
