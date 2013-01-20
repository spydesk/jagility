/**
 * 
 */
package com.jagility.stripes.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.ExecutionContext;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.Intercepts;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.controller.StripesFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author sbarbey
 */
@Intercepts(LifecycleStage.ResolutionExecution)
public class JstlResolutionInterceptor implements Interceptor {

	private static final Logger logger = LoggerFactory.getLogger(JstlResolutionInterceptor.class);

	@Override
	public Resolution intercept(ExecutionContext context) throws Exception {
		Resolution resolution = context.getResolution();
		if (resolution instanceof ForwardResolution) {

			ServletContext servletContext = StripesFilter.getConfiguration().getServletContext();
			MessageSource messageSource = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			exposeLocalizationContext(context.getActionBeanContext().getRequest(), messageSource);

		}
		return context.proceed();
	}

	private void exposeLocalizationContext(HttpServletRequest request, MessageSource messageSource) {
		Locale jstlLocale = request.getLocale();
		Config.set(request, Config.FMT_LOCALE, jstlLocale);
		LocalizationContext jstlContext = new StripesLocalizationContext(messageSource, request);
		Config.set(request, Config.FMT_LOCALIZATION_CONTEXT, jstlContext);
		if (logger.isDebugEnabled()) {
			logger.debug("Configured JSTL localization context with locale [" + jstlLocale + "] and message source ["
					+ messageSource + "]");
		}
	}

	private static class StripesLocalizationContext extends LocalizationContext {

		private final MessageSource messageSource;
		private final HttpServletRequest request;

		public StripesLocalizationContext(MessageSource messageSource, HttpServletRequest request) {
			this.messageSource = messageSource;
			this.request = request;
		}

		@Override
		public Locale getLocale() {
			return request.getLocale();
		}

		@Override
		public ResourceBundle getResourceBundle() {
			return new MessageSourceResourceBundle(messageSource, getLocale());
		}

	}

}
