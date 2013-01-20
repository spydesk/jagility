<%@ include file="../../includes/common-declarations.jsp" %>
<%@page import="com.jagility.web.action.admin.PersonFormActionBean"%>
<stripes:layout-render name="/WEB-INF/layouts/main-layout.jsp">
<stripes:layout-component name="body">

<div>
<p>[<stripes:link beanclass="<%=PersonFormActionBean.class %>">new</stripes:link>]</p>
</div>

<div>
<display:table id="person" name="actionBean.persons">
<display:column property="id" title="#"/>
<display:column property="firstName" titleKey="person.firstName"/>
<display:column property="lastName" titleKey="person.lastName"/>
<display:column>
[<stripes:link beanclass="<%=PersonFormActionBean.class %>">
<stripes:param name="person.id" value="${person.id }"/>
edit
</stripes:link>]
</display:column>
</display:table>
</div>

</stripes:layout-component>
</stripes:layout-render>
