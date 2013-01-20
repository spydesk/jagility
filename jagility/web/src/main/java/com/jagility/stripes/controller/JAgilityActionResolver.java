/**
 * 
 */
package com.jagility.stripes.controller;

import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.NameBasedActionResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jagility.stripes.action.JspResolution;

/**
 * @author sbarbey
 */
public class JAgilityActionResolver extends NameBasedActionResolver {

	private static final Logger logger = LoggerFactory.getLogger(JAgilityActionResolver.class);

	private static final String BINDING_SUFFIX = ".url";

	@Override
	protected String getBindingSuffix() {
		return BINDING_SUFFIX;
	}

	@Override
	protected Resolution findView(String urlBinding) {
		int lastPeriod = urlBinding.lastIndexOf('.');
		String path = urlBinding.substring(0, urlBinding.lastIndexOf('/') + 1);
		String name = (lastPeriod >= path.length()) ? urlBinding.substring(path.length(), lastPeriod) : urlBinding
				.substring(path.length());

		String view = path + name;

		logger.info("Bind [" + urlBinding + "] to view [" + view + "]");

		return new JspResolution(view);
	}

}
