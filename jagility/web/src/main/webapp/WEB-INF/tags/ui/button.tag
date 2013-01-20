<%-- 
--%><%@ tag language="java" pageEncoding="UTF-8" %><%-- 
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%-- 
--%><%@ attribute name="href" required="true" %><%-- 
--%><%@ attribute name="id" %><%-- 
--%><%@ attribute name="cssClass" %><%-- 
--%><c:if test="${not empty cssClass }"><c:set var="buttonClass">class="${cssClass }"</c:set></c:if><%-- 
--%><c:if test="${not empty id }"><c:set var="buttonId">id="${id }"</c:set></c:if><%--
--%>[&nbsp;<a href="${href }" ${buttonId } ${buttonClass }><jsp:doBody/></a>&nbsp;]