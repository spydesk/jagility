/**
 * 
 */
package com.jagility.data.dao;

/**
 * @author sbarbey
 */
public interface IRowOrder {

	boolean isAscending();

	boolean isIgnoreCase();

	String getPropertyName();

}
