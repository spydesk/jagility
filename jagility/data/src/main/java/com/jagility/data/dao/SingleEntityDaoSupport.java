/**
 *
 */
package com.jagility.data.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.jagility.commons.spring.Assert;

/**
 * @author sbarbey
 */
public class SingleEntityDaoSupport<E, K extends Serializable> extends AbstractDaoSupport implements IGenericDao<E, K> {

	private Class<E> entityClass = null;

	public SingleEntityDaoSupport(SessionFactory sessionFactory, Class<E> entityClass) {
		super(sessionFactory);
		Assert.notNull(entityClass, "entityClass");
		this.entityClass = entityClass;
	}

	@SuppressWarnings("unchecked")
	public E get(K key) throws HibernateException {
		return (E) getSession().get(entityClass, key);
	}

	public void update(E entity) throws HibernateException {
		getSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	public K save(E entity) throws HibernateException {
		return (K) getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public void delete(K key) {
		E entity = (E) getSession().load(entityClass, key);
		getSession().delete(entity);
	}

	public void delete(E entity) throws HibernateException {
		getSession().delete(entity);
	}

	public List<E> find(IRowRange range, IRowOrder... orders) {
		Criteria criteria = getSession().createCriteria(entityClass);
		if (range != null) {
			if (range.getFirstResult() > 0) {
				criteria.setFirstResult(range.getFirstResult());
			}
			if (range.getMaxResults() > 0) {
				criteria.setMaxResults(range.getMaxResults());
			}
		}
		if (orders != null) {
			for (IRowOrder order : orders) {
				criteria.addOrder(adaptOrder(order));
			}
		}
		return list(criteria);
	}

}
