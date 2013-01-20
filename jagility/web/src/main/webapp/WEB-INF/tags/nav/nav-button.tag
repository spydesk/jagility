<%@ tag language="java" pageEncoding="UTF-8" %><%-- 
--%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%-- 
--%><%@ attribute name="href" required="true" %><%-- 
--%><%@ attribute name="key" required="true" %><%-- 
--%>
<a href="${href }"><fmt:message key="${key }"/></a>