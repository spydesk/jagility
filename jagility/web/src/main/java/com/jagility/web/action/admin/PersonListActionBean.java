/**
 * 
 */
package com.jagility.web.action.admin;

import java.util.List;

import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jagility.data.dao.IRowOrder;
import com.jagility.data.entity.Person;
import com.jagility.services.admin.ICRUDService;
import com.jagility.stripes.action.JAgilityActionBean;
import com.jagility.stripes.action.JspResolution;

/**
 * @author sbarbey
 */
public class PersonListActionBean extends JAgilityActionBean {

	private static final Logger logger = LoggerFactory.getLogger(PersonListActionBean.class);

	private ICRUDService<Person, Integer> service;
	private List<Person> persons;

	public List<Person> getPersons() {
		return persons;
	}

	@SpringBean("admin-service")
	public void injectService(@SuppressWarnings("hiding") ICRUDService<Person, Integer> service) {
		this.service = service;
	}

	public Resolution displayList() {
		logger.info("On display list");

		persons = service.find(null, (IRowOrder[]) null);

		return new JspResolution("/admin/person-list");
	}

}
