/**
 * 
 */
package com.jagility.data.dao;

import java.util.List;

import com.jagility.data.entity.BillingItem;

/**
 * @author sbarbey
 */
public interface IBillingItemDao {

	List<BillingItem> find(IRowRange range, IRowOrder... orders);

	BillingItem get(Integer id);

	Integer save(BillingItem billingItem);

	void delete(Integer id);

	void update(BillingItem billingItem);

}
