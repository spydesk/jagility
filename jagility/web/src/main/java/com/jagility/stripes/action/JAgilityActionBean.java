/**
 * 
 */
package com.jagility.stripes.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

/**
 * @author sbarbey
 */
public abstract class JAgilityActionBean implements ActionBean {

	private ActionBeanContext context = null;

	@Override
	public ActionBeanContext getContext() {
		return context;
	}

	@Override
	public void setContext(ActionBeanContext context) {
		this.context = context;
	}

}
