/*
 * 
 */
package com.jagility.data.entity;

import static com.jagility.commons.lang.StringUtils.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jagility.domain.DogCategory;
import com.jagility.domain.Gender;

/**
 * @author sbarbey
 */
@Entity
@Table(name = "DOGS")
public class Dog {

	@Id
	@GeneratedValue
	@Column(name = "UID")
	private Integer id = null;

	@Column(name = "LICENSE", nullable = false, length = 50)
	private String license = null;

	@Column(name = "LOS", length = 50)
	private String los = null;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name = null;

	@Column(name = "GENDER", nullable = false, length = 1)
	private Gender gender = null;

	@Column(name = "DOG_CATEGORY", nullable = false, length = 1)
	private DogCategory dogCategory = null;

	@ManyToOne(optional = false)
	@JoinColumn(name = "BREED_ID", nullable = false)
	private Breed breed = null;

	@ManyToOne(optional = false)
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLos() {
		return los;
	}

	public void setLos(String los) {
		this.los = los;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public DogCategory getDogCategory() {
		return dogCategory;
	}

	public void setDogCategory(DogCategory dogCategory) {
		this.dogCategory = dogCategory;
	}

	@Override
	public String toString() {
		return stringBuilder(this).append(id).append(name).append(license).toString();
	}
}
