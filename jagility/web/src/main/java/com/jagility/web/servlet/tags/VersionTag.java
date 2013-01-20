/**
 * 
 */
package com.jagility.web.servlet.tags;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

/**
 * @author sbarbey
 */
public class VersionTag extends SimpleTagSupport {

	private static final long serialVersionUID = 6330354275204543657L;

	private static final Logger logger = LoggerFactory.getLogger(VersionTag.class);

	private static Properties properties = new Properties();

	private static void loadProperties(PageContext pageContext) {
		if (properties.isEmpty()) {
			synchronized (properties) {
				if (properties.isEmpty()) {
					Resource resource = new ServletContextResource(pageContext.getServletContext(),
							"/META-INF/maven/com.jagility/jagility-web/pom.properties");
					InputStream in = null;
					try {
						in = resource.getInputStream();

						logger.info("Loading version from [" + resource.getDescription() + "]");
						properties.load(in);
					} catch (IOException e) {
						logger.warn("Failed to load properties from [" + resource.getDescription() + "] : " + e);
					} finally {
						IOUtils.closeQuietly(in);
					}
				}
			}
		}
	}

	@Override
	public void doTag() throws JspException, IOException {
		String version = properties.getProperty("version", "");
		getJspContext().getOut().write(version);
	}

	@Override
	public void setJspContext(JspContext pc) {
		super.setJspContext(pc);
		if (pc instanceof PageContext) {
			loadProperties((PageContext) pc);
		}
	}

}
