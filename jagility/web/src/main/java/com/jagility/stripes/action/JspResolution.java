/**
 * 
 */
package com.jagility.stripes.action;

import java.util.Locale;

import net.sourceforge.stripes.action.ForwardResolution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sbarbey
 */
public class JspResolution extends ForwardResolution {

	private static final Logger logger = LoggerFactory.getLogger(JspResolution.class);

	public static final String VIEW_PATH_PREFIX = "/WEB-INF/jsps";
	public static final String VIEW_PATH_SUFFIX = ".jsp";

	public JspResolution(String view) {
		super(view);
	}

	@Override
	public String getUrl(Locale locale) {
		String url = super.getUrl(locale);
		if (logger.isDebugEnabled()) {
			logger.debug("Building JSP view from url [" + url + "]");
		}
		return VIEW_PATH_PREFIX + url + VIEW_PATH_SUFFIX;
	}

}
