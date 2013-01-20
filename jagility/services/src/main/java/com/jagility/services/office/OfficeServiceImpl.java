/**
 * 
 */
package com.jagility.services.office;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jagility.commons.spring.Assert;
import com.jagility.data.dao.IBillingItemDao;
import com.jagility.data.entity.BillingItem;

/**
 * @author sbarbey
 */
@Service("office-service")
public class OfficeServiceImpl implements IOfficeService {

	private IBillingItemDao billingItemDao;

	@Autowired
	public OfficeServiceImpl(IBillingItemDao billingItemDao) {
		Assert.notNull(billingItemDao, "billingItemDao");
		this.billingItemDao = billingItemDao;
	}

	@Override
	@Transactional(readOnly = true)
	public BillingItem findBillingItem(int id) {
		return billingItemDao.get(Integer.valueOf(id));
	}

	@Override
	@Transactional(readOnly = true)
	public List<BillingItem> findBillingItems() {
		return billingItemDao.find(null);
	}

	@Override
	@Transactional
	public int addBillingItem(BillingItem billingItem) {
		return billingItemDao.save(billingItem).intValue();
	}

	@Override
	@Transactional
	public void updateBillingItem(BillingItem billingItem) {
		billingItemDao.update(billingItem);
	}

	@Override
	@Transactional
	public void deleteBillingItem(int id) {
		billingItemDao.delete(Integer.valueOf(id));
	}

}
