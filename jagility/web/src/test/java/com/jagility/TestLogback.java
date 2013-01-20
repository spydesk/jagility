/**
 * 
 */
package com.jagility;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * @author sbarbey
 */
public class TestLogback {

	@Test
	public void testConfiguration() {

		// print internal state
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);

		Logger logger = LoggerFactory.getLogger(getClass());
		logger.trace("TRACE message");
		logger.debug("DEBUG message");
		logger.info("INFO message");
		logger.warn("WARN message");
		logger.error("ERROR message");

	}

}
