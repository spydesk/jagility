/**
 * 
 */
package com.jagility.web.action.office;

import java.util.List;

import net.sourceforge.stripes.action.After;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jagility.data.entity.BillingItem;
import com.jagility.services.office.IOfficeService;
import com.jagility.stripes.action.JAgilityActionBean;
import com.jagility.stripes.action.JspResolution;

/**
 * @author sbarbey
 */
public class BillingItemsActionBean extends JAgilityActionBean {

	private static final Logger logger = LoggerFactory.getLogger(BillingItemsActionBean.class);

	private IOfficeService officeService;

	@ValidateNestedProperties(value = { //
		@Validate(on = {
			"delete", "update"
		}, field = "id", required = true), //
		@Validate(on = {
			"add", "update"
		}, field = "name", required = true), //
		@Validate(on = {
			"add", "update"
		}, field = "description"), //
		@Validate(on = {
			"add", "update"
		}, field = "unitPrice", required = true)
	})
	private BillingItem billingItem;

	private List<BillingItem> billingItems;

	@SpringBean("office-service")
	public void injectOfficeService(@SuppressWarnings("hiding") IOfficeService officeService) {
		this.officeService = officeService;
	}

	public List<BillingItem> getBillingItems() {
		return billingItems;
	}

	public BillingItem getBillingItem() {
		return billingItem;
	}

	public void setBillingItem(BillingItem billingItem) {
		this.billingItem = billingItem;
	}

	@After(stages = LifecycleStage.BindingAndValidation)
	public void prepareView() {
		billingItems = officeService.findBillingItems();
	}

	@DefaultHandler
	@DontValidate
	public Resolution displayView() {
		if ((billingItem != null) && (billingItem.getId() != null)) {
			billingItem = officeService.findBillingItem(billingItem.getId().intValue());
			if (billingItem == null) {
				throw new IllegalStateException("Invalid billing item id");
			}
		}
		return new JspResolution("/office/billing-items");
	}

	public Resolution add() {

		logger.info(">>>>>>>>>>>>>> " + billingItem.getName());

		int id = officeService.addBillingItem(billingItem);
		logger.info("Added Billing Item [" + id + "]");
		return new RedirectResolution(this.getClass());
	}

	public Resolution update() {
		int id = billingItem.getId().intValue();
		officeService.updateBillingItem(billingItem);
		logger.info("Updated Billing Item [" + id + "]");
		return new RedirectResolution(this.getClass());
	}

	public Resolution delete() {
		int id = billingItem.getId().intValue();
		officeService.deleteBillingItem(id);
		logger.info("Deleted Billing Item [" + id + "]");
		return new RedirectResolution(this.getClass());
	}

}
