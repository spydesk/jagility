/**
 * 
 */
package com.jagility.services.admin;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jagility.data.dao.IGenericDao;
import com.jagility.data.dao.IRowOrder;
import com.jagility.data.dao.IRowRange;

/**
 * @author sbarbey
 */
public class CRUDServiceImpl<E, K extends Serializable> implements ICRUDService<E, K> {

	private IGenericDao<E, K> dao;

	public CRUDServiceImpl(IGenericDao<E, K> dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public void delete(E entity) {
		dao.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public E get(K key) {
		return dao.get(key);
	}

	@Override
	@Transactional
	public K save(E entity) {
		return dao.save(entity);
	}

	@Override
	@Transactional
	public void update(E entity) {
		dao.update(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<E> find(IRowRange range, IRowOrder... orders) {
		return dao.find(range, orders);
	}

}
