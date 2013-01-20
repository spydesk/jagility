/*
 * 
 */
package com.jagility.web.servlet.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

/**
 * @author sbarbey
 */
public class LoggingFilter extends GenericFilterBean {

	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	protected void initFilterBean() throws ServletException {
		logContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
			throw new ServletException("OncePerRequestFilter just supports HTTP requests");
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (shouldNotFilter()) {
			// Proceed without invoking this filter...
			chain.doFilter(request, response);
		} else {
			doFilterInternal(httpRequest, httpResponse, chain);
		}
	}

	private void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		logger.debug("\n\n");
		logHeaders(request);
		logRequest(request);
		logCookies(request);
		logParameters(request);
		logAttributes(request);
		logSession(request.getSession(false));
		logger.debug("\n\n");
		try {
			filterChain.doFilter(request, response);
		} finally {
			logger.debug("\n\n");
			logAttributes(request);
			logSession(request.getSession(false));
			logResponse(response);
			logger.debug("\n\n");
		}
	}

	private boolean shouldNotFilter() {
		return logger.isDebugEnabled() == false;
	}

	protected void logResponse(HttpServletResponse response) {
		logger.debug("Response[ContentType] ..... " + response.getContentType());
		logger.debug("Response[Locale] .......... " + response.getLocale());
		logger.debug("Response[CharacterEncoding] " + response.getCharacterEncoding());
		logger.debug("Response[BufferSize] ...... " + response.getBufferSize());
	}

	protected void logContext() {
		ServletContext context = getServletContext();
		logger.debug("ServletContext[MajorVersion] ..... " + context.getMajorVersion());
		logger.debug("ServletContext[MinorVersion] ..... " + context.getMinorVersion());
		//logger.debug("ServletContext[ServerInfo] ....... " + context.getServerInfo());
		//logger.debug("ServletContext[ServletContextName] " + context.getServletContextName());
		logParameters(context);
		logAttributes(context);
	}

	protected void logRequest(HttpServletRequest request) {
		logger.debug("Request[RequestURI] ....... " + request.getRequestURI());
		logger.debug("Request[RequestURL] ....... " + request.getRequestURL());
		logger.debug("Request[ContextPath] ...... " + request.getContextPath());
		logger.debug("Request[ServletPath] ...... " + request.getServletPath());
		//logger.debug("Request[Protocol] ......... " + request.getProtocol());
		//logger.debug("Request[Scheme] ........... " + request.getScheme());
		logger.debug("Request[Method] ........... " + request.getMethod());
		logger.debug("Request[QueryString] ...... " + request.getQueryString());
		//logger.debug("Request[AuthType] ......... " + request.getAuthType());
		//logger.debug("Request[RemoteAddr] ....... " + request.getRemoteAddr());
		//logger.debug("Request[RemoteHost] ....... " + request.getRemoteHost());
		logger.debug("Request[RemoteUser] ....... " + request.getRemoteUser());
		//logger.debug("Request[UserPrincipal] .... " + request.getUserPrincipal());
		logger.debug("Request[Locale] ........... " + request.getLocale());
		logger.debug("CharacterEncoding ......... " + request.getCharacterEncoding());
		logger.debug("ContentLength ............. " + request.getContentLength());
		logger.debug("ContentType ............... " + request.getContentType());
		//logger.debug("LocalAddr ........ " + request.getLocalAddr());
		//logger.debug("LocalName ........ " + request.getLocalName());
		//logger.debug("LocalPort ........ " + request.getLocalPort());
		//logger.debug("PathInfo ......... " + request.getPathInfo());
		//logger.debug("PathTranslated ... " + request.getPathTranslated());
		//logger.debug("RemotePort ....... " + request.getRemotePort());
		//logger.debug("RequestedSessionId " + request.getRequestedSessionId());
		//logger.debug("ServerName ....... " + request.getServerName());
		//logger.debug("ServerPort ....... " + request.getServerPort());
		//logger.debug("Locales .......... " + request.getLocales());
	}

	protected void logSession(HttpSession session) {
		if (session == null) {
			return;
		}
		logger.debug("Session[Id] ................ " + session.getId());
		//logger.debug("Session[CreationTime] ...... " + session.getCreationTime());
		//logger.debug("Session[LastAccessedTime] .. " + session.getLastAccessedTime());
		//logger.debug("Session[MaxInactiveInterval] " + session.getMaxInactiveInterval());
		@SuppressWarnings("unchecked")
		Enumeration<String> en = session.getAttributeNames();
		while (en.hasMoreElements()) {
			String name = en.nextElement();
			logger.debug("Session[" + name + "] " + session.getAttribute(name));
		}
	}

	protected void logAttributes(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Enumeration<String> en = request.getAttributeNames();
		while (en.hasMoreElements()) {
			String name = en.nextElement();
			logger.debug("Attribute[" + name + "] " + request.getAttribute(name));
		}
	}

	protected void logAttributes(ServletContext context) {
		@SuppressWarnings("unchecked")
		Enumeration<String> en = context.getAttributeNames();
		while (en.hasMoreElements()) {
			String name = en.nextElement();

			//
			// TODO : problem with jasper compiler...
			//
			try {
				logger.debug("ContextAttribute[" + name + "] " + context.getAttribute(name));
			} catch (NullPointerException e) {
				logger.error("ContextAttribute[" + name + "] Jasper Compiler Bug", e);
			}
		}
	}

	protected void logParameters(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Enumeration<String> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			String name = en.nextElement();
			logger.debug("Parameter[" + name + "] " + request.getParameter(name));
		}
	}

	protected void logParameters(ServletContext context) {
		@SuppressWarnings("unchecked")
		Enumeration<String> en = context.getInitParameterNames();
		while (en.hasMoreElements()) {
			String name = en.nextElement();
			logger.debug("InitParameter[" + name + "] " + context.getInitParameter(name));
		}
	}

	protected void logHeaders(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Enumeration<String> en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String name = en.nextElement();
			logger.debug("Header[" + name + "] " + request.getHeader(name));
		}
	}

	protected void logCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return;
		}
		for (Cookie cookie : cookies) {
			logger.debug("Cookie[" + cookie.getName() + "] " + cookie.getValue());
		}
	}

}
