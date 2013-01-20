<%@ include file="../../includes/common-declarations.jsp" %>
<stripes:layout-render name="/WEB-INF/layouts/main-layout.jsp">
<stripes:layout-component name="head">
<script type="text/javascript">
$(function(){

	$("#cancelButton").click(function(){
		history.back();
		return false;
	});
	
});
</script>
</stripes:layout-component>
<stripes:layout-component name="body">

<div>
<stripes:form beanclass="${actionBean.class.name }">
<stripes:errors/>
<div>
<stripes:label name="person.firstName"/> :
<stripes:text name="person.firstName"/>
</div>
<div>
<stripes:label name="person.lastName"/> :
<stripes:text name="person.lastName"/>
</div>
<div>
<stripes:hidden name="person.id"/>
<stripes:submit name="save"/>
<stripes:submit name="update"/>
<stripes:submit name="delete"/>
<stripes:button id="cancelButton" name="cancel"/>
</div>
</stripes:form>
</div>

</stripes:layout-component>
</stripes:layout-render>