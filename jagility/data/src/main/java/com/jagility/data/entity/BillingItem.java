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
@Table(name = "BILLING_ITEMS")
public class BillingItem {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@Column(name = "NAME", nullable = false, unique = true, length = 50)
	private String name;

	@Column(name = "DESCRIPTION", length = 255)
	private String description;

	@Column(name = "UNIT_PRICE", nullable = false)
	private Double unitPrice;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return stringBuilder(this).append(id).append(name).append(description).append(unitPrice).toString();
	}
}
