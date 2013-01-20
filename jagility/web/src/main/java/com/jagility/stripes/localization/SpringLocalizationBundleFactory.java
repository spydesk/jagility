/**
 * 
 */
package com.jagility.stripes.localization;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.localization.LocalizationBundleFactory;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author sbarbey
 */
public class SpringLocalizationBundleFactory implements LocalizationBundleFactory {

	private MessageSource messageSource = null;

	@Override
	public void init(Configuration configuration) throws Exception {
		messageSource = WebApplicationContextUtils.getRequiredWebApplicationContext(configuration.getServletContext());
	}

	@Override
	public ResourceBundle getErrorMessageBundle(Locale locale) throws MissingResourceException {
		return createResourceBundle(locale);
	}

	@Override
	public ResourceBundle getFormFieldBundle(Locale locale) throws MissingResourceException {
		return createResourceBundle(locale);
	}

	protected ResourceBundle createResourceBundle(Locale locale) {
		return new MessageSourceResourceBundle(messageSource, locale);
	}
}
