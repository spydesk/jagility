<%@ include file="../includes/common-jsp-declarations.jsp" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="org.apache.commons.lang.ClassUtils"%>
<%@ page import="org.apache.commons.lang.exception.ExceptionUtils"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<stripes:layout-render name="/WEB-INF/layouts/main-layout.jsp">
<stripes:layout-component name="head">
<script type="text/javascript">
$(function(){

	$("#toggleStackTrace").click(function(){
		$("#stackTrace").toggle();
		return false;
	});
	
	$("#backLink").click(function(){
		history.back();
		return false;
	});
	
});
</script>
<style type="text/css">
#stackTrace {
	overflow: auto;
}
</style>
</stripes:layout-component>
<stripes:layout-component name="body">

<c:set var="exception" value="${requestScope['javax.servlet.error.exception'] }"/>
<h1>${exception.class.name }</h1>
<ul>
<c:forEach items="<%=ExceptionUtils.getThrowableList((Throwable)pageContext.getAttribute("exception")) %>" var="currentCause">
<li>${currentCause }</li>
</c:forEach>
</ul>
<p><ui:button href="#" id="backLink">Back</ui:button><ui:button href="#" id="toggleStackTrace">See more</ui:button></p>
<code id="stackTrace" style="display: none;"><%=ExceptionUtils.getFullStackTrace((Throwable)pageContext.getAttribute("exception")) %></code>

</stripes:layout-component>
</stripes:layout-render>