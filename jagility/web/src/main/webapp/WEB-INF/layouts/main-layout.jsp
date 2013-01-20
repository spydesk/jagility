<%--

	Main application layout
	 
--%><%@ include file="../includes/common-jsp-declarations.jsp" %><%-- 
--%><stripes:layout-definition><%-- 
--%><?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>:: JAgility <stripes:layout-component name="title"/></title>
<res:style src="/theme.css"/>
<res:style src="/additionnal-theme.css"/>
<res:style src="/jquery/ui.all.css"/>
<res:script src="/jquery/jquery-core.js"/>
<res:script src="/jquery/jquery-ui.js"/>
<res:script src="/jquery/jquery-ui-i18n.js"/>
<script type="text/javascript">
$(function(){

	$('.display-table tbody tr').hover(
		function() {  
			$(this).addClass('highlighted');  
		}, 
		function() {  
			$(this).removeClass('highlighted');  
		}
	);
		
});
</script>
<stripes:layout-component name="head"/>
</head>
<body>
<div class="container">
<layout:header/>
<div class="main">
		
<div class="content">

<!-- ~~ CONTENT START ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<stripes:layout-component name="body"/>

<!-- ~~ CONTENT END ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

</div>

<!-- ~~ RIGHT MENU START ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<layout:sidenav/>
	
<!-- ~~ RIGHT MENU END ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<div class="clearer"><span></span></div>

</div>

</div>

<layout:footer/>
</body>
</html>
</stripes:layout-definition>