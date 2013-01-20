<%--
	 
--%><%@ include file="../../includes/common-jsp-declarations.jsp" %><%-- 
--%><%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %><%-- 
--%><%@ taglib prefix="display" uri="http://displaytag.sf.net" %><%-- 
--%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%-- 
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%-- 
--%><%@ taglib prefix="format" tagdir="/WEB-INF/tags/format" %><%-- 
--%><%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %><%-- 
--%>
<%@page import="com.jagility.web.action.office.BillingItemsActionBean"%>
<%@page import="net.sourceforge.stripes.controller.StripesConstants"%>
<c:set var="beanClass" value="<%=BillingItemsActionBean.class %>"/>
<stripes:layout-render name="/WEB-INF/layouts/main-layout.jsp"><%-- 
--%><stripes:layout-component name="head">
<script type="text/javascript">
$(function(){
	
	$('#addButtonTrigger').click(function(){
		$('#eventName').val('add');
		$('#form').submit();
	});

});
</script>
<c:if test="${actionBean.billingItem != null }">
<script type="text/javascript">
$(function(){

	$('#updateButtonTrigger').click(function(){
		$('#eventName').val('update');
		$('#form').submit();
	});
	
	$('#deleteButtonTrigger').click(function(){
		$('#eventName').val('delete');
		$('#form').submit();
	});
	
});
</script>
</c:if>
</stripes:layout-component><%-- 
--%><stripes:layout-component name="body">

<h1><fmt:message key="nav.office.billing.items"/></h1>

<stripes:form id="form" beanclass="${beanClass }">

<stripes:errors/>

<table><tbody><tr>
<td><stripes:label for="billingItem.name"/></td>
<td><stripes:text id="billingItem.name" name="billingItem.name"/></td>
</tr><tr>
<td><stripes:label for="billingItem.description"/></td>
<td><stripes:textarea name="billingItem.description"/></td>
</tr><tr>
<td><stripes:label for="billingItem.unitPrice"/></td>
<td><stripes:text name="billingItem.unitPrice"/></td>
</tr><tr>
</tr></tbody></table>

<ui:button href="#" id="addButtonTrigger"><fmt:message key="add.button"/></ui:button>
<c:if test="${actionBean.billingItem != null }">
<ui:button href="#" id="updateButtonTrigger"><fmt:message key="update.button"/></ui:button>
<ui:button href="#" id="deleteButtonTrigger"><fmt:message key="delete.button"/></ui:button>
</c:if>

<stripes:hidden id="eventName" name="<%=StripesConstants.URL_KEY_EVENT_NAME %>"/>
<stripes:hidden name="billingItem.id"/>

</stripes:form>

<br />
<br />

<display:table list="${actionBean.billingItems }" class="display-table" uid="billingItem">

<display:setProperty name="basic.empty.showtable" value="true"/>
<display:setProperty name="basic.msg.empty_list_row">
<tr class="empty"><td colspan="{0}"><fmt:message key="empty.list"/></td></tr>
</display:setProperty>

<display:column property="id" titleKey="billingItem.id" class="column-id" headerClass="column-id"/>
<display:column property="name" titleKey="billingItem.name"/>
<display:column property="description" titleKey="billingItem.description"/>

<display:column titleKey="billingItem.unitPrice" class="column-amount">
<format:formatAmount value="${billingItem.unitPrice }"/>
</display:column>

<display:column class="column-action" headerClass="column-action">
<stripes:url var="displayUrl" beanclass="${beanClass }">
<stripes:param name="billingItem.id" value="${billingItem.id }"/>
</stripes:url>
<ui:button href="${displayUrl }"><fmt:message key="display.button"/></ui:button>
</display:column>

</display:table>

</stripes:layout-component><%-- 
--%></stripes:layout-render>