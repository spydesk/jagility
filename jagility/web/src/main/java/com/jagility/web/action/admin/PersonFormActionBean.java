/**
 * 
 */
package com.jagility.web.action.admin;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jagility.data.entity.Person;
import com.jagility.services.admin.IAdminService;
import com.jagility.services.admin.ICRUDService;
import com.jagility.stripes.action.JAgilityActionBean;
import com.jagility.stripes.action.JspResolution;

/**
 * @author sbarbey
 */
public class PersonFormActionBean extends JAgilityActionBean {

	private static final Logger logger = LoggerFactory.getLogger(PersonFormActionBean.class);

	@ValidateNestedProperties({
		@Validate(field = "id", required = true, on = {
			"update", "delete"
		}), //
		@Validate(field = "firstName", required = true, on = {
			"save", "update"
		}), //
		@Validate(field = "lastName", required = true, on = {
			"save", "update"
		})
	})
	private Person person = null;

	private ICRUDService<Person, Integer> service;

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	@SpringBean("admin-service")
	public void injectService(@SuppressWarnings("hiding") ICRUDService<Person, Integer> service) {
		this.service = service;
	}

	@DefaultHandler
	@DontValidate
	public Resolution display() {
		logger.info("On display form " + person);
		if ((person != null) && (person.getId() != null)) {
			person = service.get(person.getId());
		}
		return new JspResolution("/admin/person-form");
	}

	public Resolution save() {
		logger.info("On save form " + person);
		Integer personId = service.save(person);
		logger.info("Saved person [" + personId + "]");
		//return new RedirectResolution(PersonListActionBean.class);
		return new JspResolution("/admin/person-form");
	}

	public Resolution update() {
		logger.info("On update form " + person);

		throw new UnsupportedOperationException("Cannot execute updateForm action");
	}

	public Resolution delete() {

		logger.info("On delete form " + person);
		service.delete(person);
		logger.info("Deleted person [" + person + "]");

		return new RedirectResolution(PersonListActionBean.class);
	}

	public static void main(String[] args) {
		ApplicationContext c = new FileSystemXmlApplicationContext(args[0]);
		IAdminService s = (IAdminService) c.getBean("admin-service");
		Person p = new Person();
		p.setFirstName("èéà");
		p.setLastName("üöä");
		s.savePerson(p);
	}
}
