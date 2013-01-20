/**
 * 
 */
package com.jagility.data.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author sbarbey
 */
public interface IGenericDao<E, K extends Serializable> {

	List<E> find(IRowRange range, IRowOrder... orders);

	E get(K key);

	K save(E entity);

	void update(E entity);

	void delete(E entity);

}
