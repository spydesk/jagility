/**
 * 
 */
package com.jagility.services.admin;

import java.io.Serializable;
import java.util.List;

import com.jagility.data.dao.IRowOrder;
import com.jagility.data.dao.IRowRange;

/**
 * @author sbarbey
 */
public interface ICRUDService<E, K extends Serializable> {

	List<E> find(IRowRange range, IRowOrder... orders);

	E get(K key);

	K save(E entity);

	void update(E entity);

	void delete(E entity);

}
