/**
 *
 */
package com.jagility.data.dao;

import static com.jagility.commons.spring.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

/**
 * @author sbarbey
 */
public abstract class AbstractDaoSupport {

	private SessionFactory sessionFactory = null;

	public AbstractDaoSupport(SessionFactory sessionFactory) {
		notNull(sessionFactory, "sessionFactory");
		this.sessionFactory = sessionFactory;
	}

	protected final Session getSession() throws HibernateException {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected final <E> List<E> list(Criteria criteria) {
		return criteria.list();
	}

	protected final Order adaptOrder(IRowOrder order) {
		if (order != null) {
			Order o = null;
			if (order.isAscending()) {
				o = Order.asc(order.getPropertyName());
			} else {
				o = Order.desc(order.getPropertyName());
			}
			if (order.isIgnoreCase()) {
				o.ignoreCase();
			}
			return o;
		}
		return null;
	}

}
