/**
 * 
 */
package com.jagility.services.office;

import java.util.List;

import com.jagility.data.entity.BillingItem;

/**
 * @author sbarbey
 */
public interface IOfficeService {

	List<BillingItem> findBillingItems();

	BillingItem findBillingItem(int id);

	int addBillingItem(BillingItem billingItem);

	void updateBillingItem(BillingItem billingItem);

	void deleteBillingItem(int id);

}
