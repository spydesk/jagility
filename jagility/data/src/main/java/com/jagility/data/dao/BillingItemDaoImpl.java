/**
 * 
 */
package com.jagility.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jagility.data.entity.BillingItem;

/**
 * @author sbarbey
 */
@Repository("billing-item-dao")
public class BillingItemDaoImpl extends SingleEntityDaoSupport<BillingItem, Integer> implements IBillingItemDao {

	@Autowired
	public BillingItemDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory, BillingItem.class);
	}

}
