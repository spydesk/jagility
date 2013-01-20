<%@ include file="../../includes/common-declarations.jsp" %>
<stripes:layout-render name="/WEB-INF/layouts/main-layout.jsp">
<stripes:layout-component name="head">
<res:script src="/jq-filestyle/jquery.filestyle.js"/>
<script type="text/javascript">
$(function(){
	$("#gameLogo").filestyle({ 
	    image: "choose-file.gif",
	    imageheight : 22,
	    imagewidth : 82,
	    width : 250
	});
});
</script>
</stripes:layout-component>
<stripes:layout-component name="body">

<h1><fmt:message key="nav.admin"/> : <fmt:message key="nav.admin.settings"/></h1>
<%-- 
<spring-form:form id="settingsForm" action="${actionUrl }" enctype="multipart/form-data">

<spring-form:label path="gameName" for="gameName" cssErrorClass="error"><fmt:message key="game.name"/></spring-form:label>
<spring-form:input path="gameName" cssClass="styled" id="gameName" cssErrorClass="styled error"/>
<spring-form:errors cssClass="error" path="gameName"/>
<br/>
<spring-form:label path="externalGameUrl" for="externalGameUrl" cssErrorClass="error"><fmt:message key="external.game.url"/></spring-form:label>
<spring-form:input path="externalGameUrl" cssClass="styled" id="externalGameUrl" cssErrorClass="styled error"/>
<spring-form:errors cssClass="error" path="externalGameUrl"/>
<br/>
<spring-form:label path="gameLogo" for="gameLogo" cssErrorClass="error"><fmt:message key="game.logo"/></spring-form:label>
<input id="gameLogo" name="gameLogo" type="file" class="styled"/>
<spring-form:errors cssClass="error" path="gameLogo"/>
<br/>
<spring-form:label path="gameClubName" for="gameClubName" cssErrorClass="error"><fmt:message key="game.club.name"/></spring-form:label>
<spring-form:input path="gameClubName" cssClass="styled" id="gameClubName" cssErrorClass="styled error"/>
<spring-form:errors cssClass="error" path="gameClubName"/>
<br>
<input type="submit" value="submit"/>
</spring-form:form>
--%>

</stripes:layout-component>
</stripes:layout-render>
