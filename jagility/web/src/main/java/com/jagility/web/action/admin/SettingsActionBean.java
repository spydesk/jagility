/**
 * 
 */
package com.jagility.web.action.admin;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jagility.stripes.action.JAgilityActionBean;
import com.jagility.stripes.action.JspResolution;

/**
 * @author sbarbey
 */
public class SettingsActionBean extends JAgilityActionBean {

	private static final Logger logger = LoggerFactory.getLogger(SettingsActionBean.class);

	@ValidateNestedProperties({
		@Validate(field = "gameName", required = true), //
		@Validate(field = "gameClubName", required = true)
	})
	private SettingsForm settingsForm;

	public void setSettingsForm(SettingsForm settingsForm) {
		this.settingsForm = settingsForm;
	}

	public SettingsForm getSettingsForm() {
		return settingsForm;
	}

	@DefaultHandler
	@DontValidate
	public Resolution displayForm() {
		return new JspResolution("/admin/settings");
	}

	public Resolution executeForm() {

		logger.info("doSubmitAction with command [" + settingsForm + "]");

		logger.info("gameName : " + settingsForm.getGameName());
		logger.info("externalGameUrl : " + settingsForm.getExternalGameUrl());
		logger.info("gameLogo : " + settingsForm.getGameLogo());
		logger.info("gameClubName : " + settingsForm.getGameClubName());

		return new RedirectResolution(this.getClass());
	}

}
