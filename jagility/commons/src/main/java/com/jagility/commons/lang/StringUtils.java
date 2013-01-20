/**
 * 
 */
package com.jagility.commons.lang;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author sbarbey
 */
public class StringUtils {

	private StringUtils() {
		// 
	}

	public static ToStringBuilder stringBuilder(Object object) {
		return new ToStringBuilder(object, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
