/**
 * 
 */
package com.jagility.commons.spring.i18n;

import static com.jagility.commons.lang.StringUtils.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.Resource;

import com.jagility.commons.spring.Assert;

/**
 * @author sbarbey
 */
public class PropertiesMessageSource extends AbstractMessageSource {

	private static final Logger logger = LoggerFactory.getLogger(PropertiesMessageSource.class);

	private static final String CODE_LOCALE_DELIMITER = ".";

	private Properties messages = null;

	private String codeLocaleDelimiter = CODE_LOCALE_DELIMITER;

	private Resource[] resources = new Resource[0];

	public PropertiesMessageSource(Resource[] resources) {
		Assert.notEmpty(resources, "resources");
		this.resources = resources;
	}

	public void readResources() throws IOException {

		messages = new Properties();
		for (Resource resource : resources) {
			loadResource(resource);
		}

	}

	private void loadResource(Resource resource) throws IOException {
		Properties properties = new Properties();
		InputStream in = null;
		try {
			logger.info("Loading messages from resource [" + resource.getDescription() + "]");
			in = resource.getInputStream();
			properties.load(in);
		}
		finally {
			IOUtils.closeQuietly(in);
		}

		messages.putAll(properties);
	}

	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		throw new IllegalStateException("Method should not be called");
	}

	@Override
	protected String resolveCodeWithoutArguments(String code, Locale locale) {

		String message = findMessage(code, locale);
		if (message == null) {
			logger.info("Message not found for [" + code + ":" + locale + "]");
			return null;
		}
		return message;
	}

	private String buildKey(String code, Locale locale) {
		return code + codeLocaleDelimiter + locale.toString();
	}

	private String findMessage(String code, Locale locale) {
		List<Locale> locales = getCandidateLocales(locale);
		return findMessage(code, locales, 0);
	}

	private List<Locale> getCandidateLocales(Locale locale) {
		String language = locale.getLanguage();
		String country = locale.getCountry();
		String variant = locale.getVariant();

		List<Locale> locales = new ArrayList<Locale>(4);
		if (variant.length() > 0) {
			locales.add(locale);
		}
		if (country.length() > 0) {
			locales.add(locales.size() == 0 ? locale : new Locale(language, country, ""));
		}
		if (language.length() > 0) {
			locales.add(locales.size() == 0 ? locale : new Locale(language, "", ""));
		}
		return locales;
	}

	private String findMessage(String code, List<Locale> candidateLocales, int index) {
		Locale targetLocale = candidateLocales.get(index);
		String key = buildKey(code, targetLocale);
		String message = messages.getProperty(key);
		if (message == null) {
			if (index < candidateLocales.size() - 1) {
				message = findMessage(code, candidateLocales, index + 1);
			}
		}
		return message;
	}

	@Override
	public String toString() {
		return stringBuilder(this).append(resources).toString();
	}

}
