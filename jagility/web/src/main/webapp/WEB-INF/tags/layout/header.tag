<%--
	 
--%><%@ include file="../../includes/common-tag-declarations.tag" %><%--
--%><%@ taglib prefix="nav" tagdir="/WEB-INF/tags/nav" %><%-- 
--%><c:url var="rootUrl" value="/"/><%-- 
--%><c:url var="logoutUrl" value="/logout.url"/><%-- 
--%><c:url var="adminUrl" value="/admin/home.url"/><%-- 
--%><c:url var="officeUrl" value="/office/home.url"/><%-- 
--%><c:url var="secretariatUrl" value="/secretariat/home.url"/><%-- 
--%>
<div class="header">
<div class="title"><h1><a href="${rootUrl }">JAgility</a></h1></div><%-- 
--%><nav:nav-buttons><%-- 
--%><nav:nav-button href="${adminUrl }" key="nav.admin"/><%-- 
--%><nav:nav-button href="${officeUrl }" key="nav.office"/><%-- 
--%><nav:nav-button href="${secretariatUrl }" key="nav.secretariat"/><%-- 
--%><nav:nav-button href="${logoutUrl }" key="nav.logout"/><%-- 
--%></nav:nav-buttons><%-- 
--%>
</div>