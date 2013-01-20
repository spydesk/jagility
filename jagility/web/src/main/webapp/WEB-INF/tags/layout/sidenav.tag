<%--
	 
--%><%@ include file="../../includes/common-tag-declarations.tag" %><%--
--%><%@ taglib prefix="nav" tagdir="/WEB-INF/tags/nav" %><%-- 
--%><c:url var="adminSettingsUrl" value="/admin/settings.url"/><%-- 
--%><c:url var="adminUsersUrl" value="/admin/users.url"/><%-- 
--%><c:url var="personListUrl" value="/admin/PersonList.url"/><%-- 
--%><c:url var="subscriptionUrl" value="/office/subscription.url"/><%-- 
--%><c:url var="billingItemsUrl" value="/office/BillingItems.url"/><%-- 
--%>
<div class="sidenav"><%-- 

--%><nav:sidenav-section key="nav.admin"><%-- 
--%><nav:sidenav-button href="${adminSettingsUrl }" key="nav.admin.settings"/><%-- 
--%><nav:sidenav-button href="${adminUsersUrl }" key="nav.admin.users"/><%-- 
--%><nav:sidenav-button href="${personListUrl }" key="nav.admin.person.list"/><%-- 
--%><nav:sidenav-button href="#" key="convallis"/><%-- 
--%></nav:sidenav-section><%-- 

--%><nav:sidenav-section key="nav.office"><%-- 
--%><nav:sidenav-button href="${subscriptionUrl }" key="nav.office.subscription"/><%-- 
--%><nav:sidenav-button href="${billingItemsUrl }" key="nav.office.billing.items"/><%-- 
--%></nav:sidenav-section><%-- 

--%><nav:sidenav-section key="nav.secretariat"><%-- 
--%><nav:sidenav-button href="#" key="sociis.natoque"/><%-- 
--%><nav:sidenav-button href="#" key="magna.sed.purus"/><%-- 
--%><nav:sidenav-button href="#" key="tincidunt"/><%-- 
--%></nav:sidenav-section><%-- 

--%>
</div>