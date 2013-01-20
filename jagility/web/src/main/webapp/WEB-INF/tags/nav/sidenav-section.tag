<%@ tag language="java" pageEncoding="UTF-8" %><%-- 
--%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%-- 
--%><%@ attribute name="key" required="true" %><%-- 
--%>
<h1><fmt:message key="${key }"/></h1>
<ul>
<jsp:doBody/>
</ul>