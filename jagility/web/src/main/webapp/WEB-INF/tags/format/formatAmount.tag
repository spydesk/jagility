<%--
	 
--%><%@ tag language="java" pageEncoding="UTF-8"%><%--	 
--%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%--	 
--%><%@ attribute name="value" required="true" %><%--	 
--%><fmt:formatNumber value="${value }" minFractionDigits="2" maxFractionDigits="2"/>