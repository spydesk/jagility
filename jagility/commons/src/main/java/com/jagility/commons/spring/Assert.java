/**
 * 
 */
package com.jagility.commons.spring;

/**
 * @author sbarbey
 */
public class Assert {

	private Assert() {
		//
	}

	public static void notNull(Object object, String name) {
		org.springframework.util.Assert.notNull(object, "Object '" + name + "' must not be null");
	}

	public static void notEmpty(Object[] array, String name) {
		org.springframework.util.Assert.notEmpty(array, "Array '" + name + "' must not be empty");
	}

}
