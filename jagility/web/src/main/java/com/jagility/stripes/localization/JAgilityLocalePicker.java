/**
 * 
 */
package com.jagility.stripes.localization;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.stripes.localization.DefaultLocalePicker;

import org.apache.commons.lang.StringUtils;

/**
 * @author sbarbey
 */
public class JAgilityLocalePicker extends DefaultLocalePicker {

	private static final String LOCALE_PARAMETER = "_locale";

	@Override
	public Locale pickLocale(HttpServletRequest request) {
		String localeValue = request.getParameter(LOCALE_PARAMETER);
		if (StringUtils.isNotBlank(localeValue)) {
			return new Locale(localeValue);
		}
		return super.pickLocale(request);
	}

}
